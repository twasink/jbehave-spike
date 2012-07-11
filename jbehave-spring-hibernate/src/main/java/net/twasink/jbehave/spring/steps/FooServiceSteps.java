package net.twasink.jbehave.spring.steps;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FooServiceSteps {


    @When("we create a Foo called 'bar'")
    public void createFoo() {
        
    }
    
    @Then("Then it gets saved in the database with the name 'bar'")
    public void lookForFoo() {
        
    }
}
