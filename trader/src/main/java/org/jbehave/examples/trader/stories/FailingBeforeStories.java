package org.jbehave.examples.trader.stories;

import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.examples.trader.TraderStory;
import org.jbehave.examples.trader.service.TradingService;
import org.jbehave.examples.trader.steps.TraderSteps;

public class FailingBeforeStories extends TraderStory {

    @Override
    public Configuration configuration() {
        return super.configuration().useStoryControls(new StoryControls().doResetStateBeforeStory(false).doResetStateBeforeScenario(false));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new TraderSteps(new TradingService()), this);
    }

    @BeforeStories
    public void beforeStories(){
        throw new RuntimeException("Bum go the stories");
    }
}
