package com.csx.page.actions;

import com.csx.page.objects.HRMAdminPageObjects;
import com.csx.stepdefinitions.ScenarioContext;
import com.csx.test.util.ScreenshotUtils;
import com.csx.test.util.WebDriverProvider;
import io.cucumber.java.Scenario;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
@Singleton
public class HRMAdminPageActions {
    @Inject
    WebDriverProvider driverProvider;
    private WebDriverWait driverWait;
    @Inject
    HRMAdminPageObjects pageObjects;

    @Inject
    ScreenshotUtils screenshotUtils;

    @Inject
    ScenarioContext scenarioContext;
    @PostConstruct
    private void init(){
        PageFactory.initElements(this.driverProvider.getInstance(), this.pageObjects);
        wait=new WebDriverWait(driverProvider.getInstance(), Duration.ofSeconds(60));
    }

    private WebDriverWait wait = new WebDriverWait(driverProvider.getInstance(), Duration.ofSeconds(30));

    public void navigateToUserManagement() throws InterruptedException {
        pageObjects.admin_link.click();
        Thread.sleep(2000);
        Actions action = new Actions(driverProvider.getInstance());
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");
        action.moveToElement(pageObjects.employmentStatus).perform();
        Thread.sleep(2000);
        pageObjects.users.click();
        Thread.sleep(2000);
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");
    }

    public String randomNumber() {
        Random rand = new Random();
        return Integer.toString(rand.nextInt(1000));

    }
}
