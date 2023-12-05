package com.csx.stepdefinitions;

import io.cucumber.java.Scenario;
import jakarta.inject.Singleton;

@Singleton
public class ScenarioContext {

	protected Scenario scenario;

	public Scenario getScenario() {
		return scenario;
	}
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

}
