package com.csx.page.actions;

import com.csx.stepDefinitions.ScenarioContext;
import com.csx.test.util.ScreenshotUtils;
import com.csx.test.util.SeleniumUtil;
import com.csx.test.util.WebDriverProvider;
import io.cucumber.java.Scenario;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@ApplicationScoped
public class CsxDemoPageActions {

  @Inject
  private CsxDemoPageObjects pageObjects;

  @Inject
  private WebDriverProvider driver;


  @Inject
  ScreenshotUtils screenshotUtils;

  @Inject
  ScenarioContext scenarioContext;
  Scenario scenario;

  @PostConstruct
  private void init(){
    PageFactory.initElements(this.driver.getInstance(), this.pageObjects);
    scenario =scenarioContext.getScenario();
  }

  public boolean isHeaderImagePresent() {
    return SeleniumUtil.isElementDisplayed(driver.getInstance(),pageObjects.csxImage);
  }
}
