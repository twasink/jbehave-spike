package net.twasink.jbehave.spring.steps;

import static org.junit.Assert.assertEquals;
import net.twasink.jbehave.spring.service.FooService;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FooServiceSteps {
    @Autowired
    private FooService test;
    @Autowired
    private JdbcTemplate jdbc;


    @When("we create a Foo called 'bar'")
    public void createFoo() {
        test.createFoo("foo", "this is a test foo");     
    }
    
    @Then("it gets saved in the database with the name 'bar'")
    public void lookForFoo() {
        assertEquals("we end with one foo", 1, jdbc.queryForInt("select count(*) from foo"));
    }
}
