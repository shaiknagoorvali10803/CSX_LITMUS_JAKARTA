package com.csx.stepdefinitions;


import com.csx.page.actions.HRMDashboardPageActions;
import com.csx.page.actions.HRMLoginPageActions;
import com.csx.test.util.WebDriverProvider;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;


public class DashboardPageStepDefinitions {

    @Inject
    private WebDriverProvider driverProvider;
    private WebDriver driver;
    @Inject
    private HRMLoginPageActions login;
    @Inject
    private HRMDashboardPageActions dashboard;

    @Inject
    private ScenarioContext scenarioContext;

    @PostConstruct
    private void init() {
        driver = driverProvider.getInstance();
    }


    @Then("i will veryfy the Dashboard content Apple leave")
    public void user_should_be_able_verify_applyleave() throws InterruptedException {
        login.verifyLoginAsValidUser();
        String verifyUserAccess = dashboard.verifyUserAccess();
        Assertions.assertEquals(verifyUserAccess, "Dashboard");
        Thread.sleep(2000);
        dashboard.verifyassignleave_link();
        Thread.sleep(2000);
        login.logout();

    }

    @Then("i will veryfy the Dashboard content leave link")
    public void user_should_be_able_verify_leavelink() throws InterruptedException {
        login.verifyLoginAsValidUser();
        String verifyUserAccess = dashboard.verifyUserAccess();
        Assertions.assertEquals(verifyUserAccess, "Dashboard");
        Thread.sleep(2000);
        dashboard.verifyleavelist_link();
        Thread.sleep(12000);

    }
}
