package com.csx.page.actions;

import com.csx.page.objects.HRMLoginPageObjects;
import com.csx.stepdefinitions.ScenarioContext;
import com.csx.test.util.ScreenshotUtils;
import com.csx.test.util.WebDriverProvider;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
@Singleton
public class HRMLoginPageActions {
    WebDriver driver;
    @Inject
    private WebDriverProvider driverProvider;
    private WebDriverWait driverWait;
    @Inject
    private HRMLoginPageObjects pageObjects;

    @Inject
    private ScreenshotUtils screenshotUtils;
    @Inject
    private ScenarioContext scenarioContext;

    @PostConstruct
    private void init(){
        driver=driverProvider.getInstance();
        PageFactory.initElements(driver, this.pageObjects);
        driverWait=new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void enterCredentials(String username, String password) {
        driverWait.until(ExpectedConditions.visibilityOf(pageObjects.txtUsername)).isDisplayed();
        driverWait.until(ExpectedConditions.visibilityOf(pageObjects.txtPassword)).isDisplayed();
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");
        pageObjects.txtUsername.sendKeys(username);
        pageObjects.txtPassword.sendKeys(password);
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");

    }
    public void clickOnLoginButton() {
        pageObjects.btnLogin.click();
    }
    public String getInvalidCredentialsMessage() {
        driverWait.until(ExpectedConditions.visibilityOf(pageObjects.lblInvalidCredentials)).isDisplayed();
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");
        return pageObjects.lblInvalidCredentials.getText();
    }

    public void logout() throws InterruptedException {
        driverWait.until(ExpectedConditions.visibilityOf(pageObjects.lblWelcome)).isDisplayed();
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");
        pageObjects.lblWelcome.click();
        Thread.sleep(2000);
        pageObjects.lnkLogout.click();

    }
    public boolean isHRMLogoDisplayed() {
        driverWait.until(ExpectedConditions.visibilityOf(pageObjects.imgLogo));
        return pageObjects.imgLogo.isDisplayed();
    }

    public boolean isLoginFailedErrorDisplayed() {
        driverWait.until(ExpectedConditions.visibilityOf(pageObjects.lblInvalidCredentials));
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");
        return pageObjects.lblInvalidCredentials.isDisplayed();
    }

    public void verifyLoginAsValidUser() {
        //DriverFactory.getInstance().getDriver().get("https://opensource-demo.orangehrmlive.com/");
        pageObjects.txtUsername.sendKeys("Admin");
        pageObjects.txtPassword.sendKeys("admin123");
        pageObjects.btnLogin.click();
    }

    public void verifyLoginAsInvalidUser() {
        //DriverFactory.getInstance().getDriver().get("https://opensource-demo.orangehrmlive.com/");
        pageObjects.txtUsername.sendKeys("Admin");
        pageObjects.txtPassword.sendKeys("Admin");
        pageObjects.btnLogin.click();

    }
}
