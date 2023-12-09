package com.csx.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import jakarta.inject.Inject;

/**
 *
 * This Hooks class has to be present in the same package as step definitions
 *
 */
public class Hooks {

    @Inject
    ScenarioContext scenarioContext;
    @Before
    public void before(final Scenario scenario){
        scenarioContext.setScenario(scenario);
    }

}
