package net.twasink.jbehave.simple.steps;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class BaconCookingSteps {
    /*
     * And a frypan on a medium heat When I put the bacon into the frypan
     */

    @Given("12 strips of bacon")
    public void howManyStripsOfBacon() {
        System.out.println(">>>> you're making how many pieces of bacon?");
    }

    @Given("a frypan on a medium heat")
    public void heatTheFrypan() {
        System.out.println(">>>> how hot did you want that?");
    }

    @When("I put the bacon into the frypan")
    public void startCooking() {
        System.out.println(">>>> Yeah - put that stuff there");
    }

    @When("wait for 10 minutes or until the bacon sizzles")
    public void cookUntilSatisifed() {
        System.out.println(">>>> I'm hungry! Why are we waiting?");
    }

    @When("flip the bacon")
    public void flipBacon() {
        System.out.println(">>>> These aren't panckes!");
    }

    @When("wait for 5 minutes")
    public void cookSomeMore() {
        System.out.println(">>>> More waiting?");
    }

    @Then("I get perfectly cooked crispy bacon")
    public void nomNomNom() {
        System.out.println(">>>> Finally! Nom nom nom nom");
    }
}
