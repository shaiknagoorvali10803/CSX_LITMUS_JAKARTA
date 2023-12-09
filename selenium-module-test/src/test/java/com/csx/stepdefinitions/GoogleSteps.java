package com.csx.stepdefinitions;


import com.csx.page.actions.GooglePageActions;
import com.csx.test.util.ScreenshotUtils;
import com.csx.test.util.SeleniumUtil;
import com.csx.test.util.WebDriverProvider;
import com.google.common.util.concurrent.Uninterruptibles;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;

public class GoogleSteps {
    @Inject
    private WebDriverProvider driverProvider;
    private WebDriver driver;
    @Inject
    private GooglePageActions googlePage;
    @Inject
    private ScenarioContext scenarioContext;

    @Inject
    private ScreenshotUtils screenshotUtils;

    @PostConstruct
    private  void init(){
        driver=driverProvider.getInstance();
    }

    @Given("I am on the google site")
    public void launchSite() throws InterruptedException {
        this.googlePage.goTo();
    }

    @When("I enter {string} as a keyword")
    public void enterKeyword(String keyword) {
        this.googlePage.search(keyword);
    }

    @Then("I should see search results page")
    public void clickSearch() throws IOException {
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(4));
        Assertions.assertTrue(this.googlePage.isAt());
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");

    }

    @Then("I should see at least {int} results")
    public void verifyResults(int count) throws InterruptedException, IOException {
        Assertions.assertTrue(this.googlePage.getCount() >= count);
        SeleniumUtil.clickElementByJS(driver, "//a[normalize-space()='Images']");
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");
        Thread.sleep(3000);
        System.out.println("Current Thread Number " + Thread.currentThread().getThreadGroup() + "thread number" + Thread.currentThread().getId());
        driver.findElement(By.xpath("//a[normalize-space()='Videos']")).click();
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");
        Thread.sleep(3000);
    }
}
