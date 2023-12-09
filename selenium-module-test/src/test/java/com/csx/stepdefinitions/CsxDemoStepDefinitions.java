package com.csx.stepdefinitions;

import com.csx.page.actions.CsxDemoPageActions;
import com.csx.test.util.LoggingException;
import com.csx.test.util.ScreenshotUtils;
import com.csx.test.util.SeleniumUtil;
import com.csx.test.util.WebDriverProvider;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CsxDemoStepDefinitions {
    private static final Logger LOGGER = LoggerFactory.getLogger(CsxDemoStepDefinitions.class);
    @Inject
    private CsxDemoPageActions pageActions;
    @Inject
    private WebDriverProvider driver;

    @Inject
    ScreenshotUtils screenshotUtils;
    @Inject
    ScenarioContext scenarioContext;

    @Given("I am on a {string} browser")
    public void determineBrowserType(final String browserType) {
        switch (browserType) {
            case "mobile":
                LOGGER.info("resizing window size for mobile");
                SeleniumUtil.resizeWindowForMobile(driver.getInstance());
                break;
            case "tablet":
                LOGGER.info("resizing window size for tablet");
                SeleniumUtil.resizeWindowForTablet(driver.getInstance());
                break;
            case "desktop":
                LOGGER.info("resizing window size for desktop");
            default:
                SeleniumUtil.waitByTime(3000);
                SeleniumUtil.maximizeWindow(driver.getInstance());
                break;
        }
    }

    @When("I navigate to csx.com")
    public void navigateToCsxWebsite() throws LoggingException, InterruptedException {
        driver.getInstance().get("https://www.csx.com");
        driver.getInstance().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    @Then("I should see the copyright information")
    public void verifyCopyrightInformation() throws LoggingException {
        Assertions.assertTrue(pageActions.isHeaderImagePresent());
        screenshotUtils.insertScreenshot("CSX Home Page");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"CSX Home Page");

    }
}
