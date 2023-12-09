package com.csx.stepdefinitions;


import com.csx.page.actions.GooglePageActions;
import com.csx.page.actions.VisaPageActions;
import com.csx.stepdefinitions.ScenarioContext;
import com.csx.test.util.ScreenshotUtils;
import com.csx.test.util.WebDriverProvider;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;

public class VisaSteps {

    @Inject
    private WebDriverProvider driverProvider;
    private WebDriver driver;

    @Inject
    private VisaPageActions registrationPage;

    @Inject
    private GooglePageActions googlePage;
    @Inject
    private ScenarioContext scenarioContext;

    @Inject
    private ScreenshotUtils screenshotUtils;

    @PostConstruct
    private void init() {
        driver = driverProvider.getInstance();
    }

    @Given("I am on VISA registration form")
    public void launchSite() throws InterruptedException {
        this.driver.navigate().to("https://vins-udemy.s3.amazonaws.com/sb/visa/udemy-visa.html");
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(), "screenshot");
    }

    @When("I select my from country {string} and to country {string}")
    public void selectCountry(String from, String to) {
        this.registrationPage.setCountryFromAndTo(from, to);
    }

    @And("I enter my dob as {string}")
    public void enterDob(String dob) {
        this.registrationPage.setBirthDate(LocalDate.parse(dob));
    }

    @And("I enter my name as {string} and {string}")
    public void enterNames(String fn, String ln) {
        this.registrationPage.setNames(fn, ln);
    }

    @And("I enter my contact details as {string} and {string}")
    public void enterContactDetails(String email, String phone) {
        this.registrationPage.setContactDetails(email, phone);
    }

    @And("I enter the comment {string}")
    public void enterComment(String comment) {
        this.registrationPage.setComments(comment);
    }

    @And("I submit the form")
    public void submit() throws InterruptedException {
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(), "screenshot");
        this.registrationPage.submit();
    }

    @Then("I should see get the confirmation number")
    public void verifyConfirmationNumber() throws InterruptedException {
        boolean isEmpty = StringUtils.isEmpty(this.registrationPage.getConfirmationNumber().trim());
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(), "screenshot");
        Assert.assertFalse(isEmpty);
        Thread.sleep(2000);
    }

}
