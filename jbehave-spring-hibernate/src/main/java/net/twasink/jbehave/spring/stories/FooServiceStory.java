package net.twasink.jbehave.spring.stories;

import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.spring.SpringStepsFactory;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
public class FooServiceStory extends JUnitStory {
    @Autowired
    private ApplicationContext context;
    
    @Autowired
    private JdbcTemplate jdbc;
    
    @After
    public void cleanData() {
        jdbc.execute("truncate schema PUBLIC and commit");
    }

    @Override public Configuration configuration() {
        return new MostUsefulConfiguration();
    }
    
    @Override
    public List<CandidateSteps> candidateSteps() {
        return new SpringStepsFactory(configuration(), context).createCandidateSteps();
    }

}
