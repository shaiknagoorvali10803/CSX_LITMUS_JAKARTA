package com.csx.page.actions;

import com.csx.page.objects.GooglePageObjects;
import com.csx.stepdefinitions.ScenarioContext;
import com.csx.test.util.ScreenshotUtils;
import com.csx.util.AppConfigHolder;
import com.csx.test.util.WebDriverProvider;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Singleton
public class GooglePageActions {
    private WebDriver driver;
    @Inject
    private WebDriverProvider driverProvider;
    @Inject
    private ScreenshotUtils screenshotUtils;
    @Inject
    private GooglePageObjects pageObjects;

    private WebDriverWait wait;
    String googleurl = AppConfigHolder.getInstance().googleurl();

    @Inject
    private ScenarioContext scenarioContext;

    @PostConstruct
    private void init(){
        driver=driverProvider.getInstance();
        PageFactory.initElements(driver, this.pageObjects);
        wait= new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    public void goTo() throws InterruptedException {
        driver.get(googleurl);
    }

    public void search(final String keyword) {
        pageObjects.searchBox.sendKeys(keyword);
        screenshotUtils.insertScreenshot("screenshot");
        screenshotUtils.insertScreenshot1(scenarioContext.getScenario(),"screenshot");
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
