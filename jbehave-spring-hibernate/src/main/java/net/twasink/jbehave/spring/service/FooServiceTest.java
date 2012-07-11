package net.twasink.jbehave.spring.service;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
public class FooServiceTest {

    @Autowired
    private FooService test;
    
    @Autowired
    private JdbcTemplate jdbc;
    
    @After
    public void cleanData() {
        jdbc.execute("truncate schema PUBLIC and commit");
    }
    
    @Test
    public void test() {
        assertEquals("we start with no foo", 0, jdbc.queryForInt("select count(*) from foo"));

        test.createFoo("foo", "this is a test foo");

        assertEquals("we end with one foo", 1, jdbc.queryForInt("select count(*) from foo"));
        
        Map<String, Object> results = jdbc.queryForMap("select * from foo");
        assertEquals("foo", results.get("name"));
        assertEquals("this is a test foo", results.get("description"));
    }
}