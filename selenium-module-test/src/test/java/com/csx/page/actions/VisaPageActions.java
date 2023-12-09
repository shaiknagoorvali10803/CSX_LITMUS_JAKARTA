package com.csx.page.actions;

import com.csx.page.objects.VisaPageObjects;
import com.csx.stepdefinitions.ScenarioContext;
import com.csx.test.util.ScreenshotUtils;
import com.csx.test.util.SeleniumUtil;
import com.csx.test.util.WebDriverProvider;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Objects;

@Singleton
public class VisaPageActions {
    @Inject
    private ScreenshotUtils screenshotUtils;

   private WebDriver driver;
    @Inject
    private WebDriverProvider driverProvider;

    @Inject
    private VisaPageObjects pageObjects;

    private WebDriverWait wait;

    @Inject
    private ScenarioContext scenarioContext;

    @PostConstruct
    private void init(){
        driver=driverProvider.getInstance();
        PageFactory.initElements(driver, this.pageObjects);
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void setNames(String firstName, String lastName) {
        pageObjects.firstName.sendKeys(firstName);
        pageObjects.lastName.sendKeys(lastName);
    }

    public void setCountryFromAndTo(String countryFrom, String countryTo) {
        new Select(pageObjects.fromCountry).selectByValue(countryFrom);
        new Select(pageObjects.toCountry).selectByValue(countryTo);
    }

    public void setBirthDate(LocalDate localDate) {
        new Select(pageObjects.year).selectByVisibleText(String.valueOf(localDate.getYear()));
        new Select(pageObjects.day).selectByVisibleText(String.valueOf(localDate.getDayOfMonth()));
        new Select(pageObjects.month).selectByValue(localDate.getMonth().toString());
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");
    }

    public void setContactDetails(String email, String phone) {
        pageObjects.email.sendKeys(email);
        pageObjects.phone.sendKeys(phone);
    }

    public void setComments(String comments) {
        pageObjects.comments.sendKeys(Objects.toString(comments, ""));
    }

    public void submit() {
        SeleniumUtil.clickElementByJS(driver, pageObjects.submit);
    }

    public String getConfirmationNumber() {
        this.wait.until((d) -> pageObjects.requestNumber.isDisplayed());
        return pageObjects.requestNumber.getText();
    }


}
