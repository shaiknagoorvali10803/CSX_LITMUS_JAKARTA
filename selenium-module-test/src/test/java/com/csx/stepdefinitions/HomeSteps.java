package com.csx.stepdefinitions;

import com.csx.page.actions.HomePageActions;
import com.csx.stepdefinitions.ScenarioContext;
import com.csx.test.util.WebDriverProvider;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.openqa.selenium.support.ui.WebDriverWait;
@ApplicationScoped
public class HomeSteps {
    @Inject
    private HomePageActions homePage;
    @Inject
    protected WebDriverProvider driverProvider;

    protected WebDriverWait wait;

    @Inject
    ScenarioContext scenarioContext;

    @Given("I am Google Page")
    public void launchSite() {
        this.homePage.goTo();
         }

    @When("Search for the Word {string}")
    public void enterKeyword(String keyword) throws InterruptedException {
        this.homePage.search(keyword);
    }

}
