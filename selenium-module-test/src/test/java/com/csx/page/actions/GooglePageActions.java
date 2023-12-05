package com.csx.page.actions;

import com.csx.page.objects.GooglePageObjects;
import com.csx.stepdefinitions.ScenarioContext;
import com.csx.test.util.ScreenshotUtils;
import com.csx.utils.AppConfigHolder;
import com.csx.test.util.WebDriverProvider;
import io.cucumber.java.Scenario;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Singleton
public class GooglePageActions {
    @Inject
    WebDriverProvider driver;
    @Inject
    ScreenshotUtils screenshotUtils;
    @Inject
    GooglePageObjects pageObjects;

    WebDriverWait wait;
    String googleurl = AppConfigHolder.getInstance().googleurl();

    @Inject
    ScenarioContext scenarioContext;
    Scenario scenario;

    @PostConstruct
    private void init(){
        PageFactory.initElements(this.driver.getInstance(), this.pageObjects);
        wait= new WebDriverWait(driver.getInstance(), Duration.ofSeconds(60));
        scenario =scenarioContext.getScenario();
    }

    public void goTo() throws InterruptedException {
        driver.getInstance().get(googleurl);
    }

    public void search(final String keyword) {
        pageObjects.searchBox.sendKeys(keyword);
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenario,"screenshot");
        pageObjects.searchBox.sendKeys(Keys.TAB);
        pageObjects.searchBtns
                .stream()
                .filter(e -> e.isDisplayed() && e.isEnabled())
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public int getCount() {
        return pageObjects.results.size();
    }

    public boolean isAt() {
        return this.wait.until((d) -> pageObjects.searchBox.isDisplayed());
    }
}
