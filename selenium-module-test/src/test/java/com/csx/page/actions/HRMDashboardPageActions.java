package com.csx.page.actions;
import com.csx.stepDefinitions.ScenarioContext;
import com.csx.test.util.ScreenshotUtils;
import io.cucumber.java.Scenario;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.csx.test.util.WebDriverProvider;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@Singleton
public class HRMDashboardPageActions {
    @Inject
    WebDriverProvider driverProvider;
    private WebDriverWait driverWait;
    @Inject
    HRMDashboardPageObjects pageObjects;
    @Inject
    ScreenshotUtils screenshotUtils;

    @Inject
    ScenarioContext scenarioContext;

    Scenario scenario;

    @PostConstruct
    private void init(){
        PageFactory.initElements(this.driverProvider.getInstance(), this.pageObjects);
        driverWait=new WebDriverWait(driverProvider.getInstance(), Duration.ofSeconds(60));
        scenario=scenarioContext.getScenario();
    }

    public String verifyassignleave_link() throws InterruptedException {
        driverWait.until(ExpectedConditions.visibilityOf(pageObjects.assignleave_link)).isDisplayed();
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenario,"screenshot");
        pageObjects.assignleave_link.click();
        Thread.sleep(2000);
        return pageObjects.assignleave_menu.getText();
    }

    public String verifyleavelist_link() throws InterruptedException {
        driverWait.until(ExpectedConditions.visibilityOf(pageObjects.leavelist_link)).isDisplayed();
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenario,"screenshot");
        pageObjects.leavelist_link.click();
        Thread.sleep(2000);
        return pageObjects.leavelist_menu.getText();
    }

    public String verifyUserAccess() throws InterruptedException {
        Thread.sleep(2000);
        driverWait.until(ExpectedConditions.visibilityOf(pageObjects.dashboard_menu)).isDisplayed();
        Thread.sleep(2000);
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenario,"screenshot");
        return pageObjects.dashboard_menu.getText();

    }
}
