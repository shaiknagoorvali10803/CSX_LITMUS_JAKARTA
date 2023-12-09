package com.csx.page.actions;

import com.csx.page.objects.CsxDemoPageObjects;
import com.csx.stepdefinitions.ScenarioContext;
import com.csx.test.util.ScreenshotUtils;
import com.csx.test.util.SeleniumUtil;
import com.csx.test.util.WebDriverProvider;
import io.cucumber.java.Scenario;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.openqa.selenium.support.PageFactory;

@Singleton
public class CsxDemoPageActions {

  @Inject
  private CsxDemoPageObjects pageObjects;

  @Inject
  private WebDriverProvider driver;

  @Inject
  ScreenshotUtils screenshotUtils;

  @Inject
  ScenarioContext scenarioContext;

  @PostConstruct
  private void init(){
    PageFactory.initElements(this.driver.getInstance(), this.pageObjects);
  }

  public boolean isHeaderImagePresent() {
    return SeleniumUtil.isElementDisplayed(driver.getInstance(),pageObjects.csxImage);
  }
}
