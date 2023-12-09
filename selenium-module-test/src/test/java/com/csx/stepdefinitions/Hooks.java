package com.csx.stepdefinitions;

import com.csx.test.util.WebDriverProvider;
import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import jakarta.inject.Inject;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks{
	@Inject
	private WebDriverProvider driverProvider;
	@Inject
	private ScenarioContext scenarioContext;

	@Before("@Chrome and not (@Headless or @Firefox or @Edge)")
	public void chromeDriver(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.CHROME);
		scenarioContext.setScenario(scenario);
	}
	@Before("(@Chrome and @Headless) and not (@Firefox or @Edge)")
	public void chromeHeadless(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.CHROME, true);
		scenarioContext.setScenario(scenario);
	}

	@Before("@Edge and not (@Headless or @Firefox or @Chrome)")
	public void edgeBrowser(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.EDGE);
		scenarioContext.setScenario(scenario);
	}
	@Before("(@Edge and @Headless) and not (@Firefox or @Chrome)")
	public void edgeBrowserWithHeadless(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.EDGE, true);
		scenarioContext.setScenario(scenario);
	}

	@Before("@Firefox and not (@Headless or @Edge or @Chrome)")
	public void firefoxBrowser(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.FIRE_FOX);
		scenarioContext.setScenario(scenario);
	}
	@Before("(@Firefox and @Headless) and not (@Edge or @Chrome)")
	public void firefoxBrowserwithHeadless(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.FIRE_FOX, true);
		scenarioContext.setScenario(scenario);
	}

	@Before("not (@Chrome or @IE or @Safari or @Firefox or @Edge)")
	public void defaultBrowser(final Scenario scenario) throws Exception {
		//driverProvider.generateWebDriver(WebDriverProvider.BrowserType.CHROME);
		scenarioContext.setScenario(scenario);
	}

	@After()
	public void afterMethod(final Scenario scenario) throws Exception {
		scenarioContext.clearContextData();
		if (scenario.isFailed()) {
			scenario.attach(((TakesScreenshot) driverProvider.getInstance()).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
		}
		driverProvider.getInstance().quit();
	}

}
