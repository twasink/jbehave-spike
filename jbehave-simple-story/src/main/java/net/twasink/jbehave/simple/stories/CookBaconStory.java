package net.twasink.jbehave.simple.stories;

import net.twasink.jbehave.simple.steps.BaconCookingSteps;

import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class CookBaconStory extends JUnitStory {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new BaconCookingSteps());
    }

}
