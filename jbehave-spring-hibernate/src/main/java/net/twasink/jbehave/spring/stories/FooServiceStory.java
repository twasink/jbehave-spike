package net.twasink.jbehave.spring.stories;

import net.twasink.jbehave.spring.steps.FooServiceSteps;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/testContext.xml")
public class FooServiceStory extends JUnitStory {
    @Autowired
    private FooServiceSteps steps;
    
    @Autowired
    private JdbcTemplate jdbc;
    
    @After
    public void cleanData() {
        jdbc.execute("truncate schema PUBLIC and commit");
    }

    @Override public Configuration configuration() {
        return new MostUsefulConfiguration();
    }
    
    @Override public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), steps);
    }

}
