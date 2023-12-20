package com.csx.stepdefinitions;

import com.csx.test.util.FileHandlingUtil;
import com.csx.test.util.SeleniumUtil;
import com.csx.test.util.VideoRecorder;
import com.csx.test.util.WebDriverProvider;
import com.csx.util.PropertyHandler;
import io.cucumber.java.After;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import jakarta.inject.Inject;
import org.apache.commons.lang3.BooleanUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks{
	public static final String LOCAL_VIDEO_RECORD_FLAG = "localVideoRecord";
	public static final String downloadPath = System.getProperty("user.dir");
	public static final String videoFileType = "avi";
	public static boolean localheadlessMode;
	private static final String BUILD_TOOL_RUN = PropertyHandler.setGridExecutionMode(System.getProperty("buildToolRun"));
	private static final String HEADLESS = PropertyHandler.setHeadlessProperty(System.getProperty("headless"));

	@Inject
	private WebDriverProvider driverProvider;
	@Inject
	private ScenarioContext scenarioContext;

	@Before("@Chrome and not (@Headless or @Firefox or @Edge)")
	public void chromeDriver(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.CHROME);
		scenarioContext.setScenario(scenario);
		if (!BooleanUtils.toBoolean(BUILD_TOOL_RUN) && !BooleanUtils.toBoolean(HEADLESS)) {
			localVideoRecord();
		}
	}
	@Before("(@Chrome and @Headless) and not (@Firefox or @Edge)")
	public void chromeHeadless(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.CHROME, true);
		localheadlessMode=true;
		scenarioContext.setScenario(scenario);
	}

	@Before("@Edge and not (@Headless or @Firefox or @Chrome)")
	public void edgeBrowser(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.EDGE);
		scenarioContext.setScenario(scenario);
		if (!BooleanUtils.toBoolean(BUILD_TOOL_RUN) && !BooleanUtils.toBoolean(HEADLESS)) {
			localVideoRecord();
		}
	}
	@Before("(@Edge and @Headless) and not (@Firefox or @Chrome)")
	public void edgeBrowserWithHeadless(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.EDGE, true);
		localheadlessMode=true;
		scenarioContext.setScenario(scenario);
	}

	@Before("@Firefox and not (@Headless or @Edge or @Chrome)")
	public void firefoxBrowser(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.FIRE_FOX);
		scenarioContext.setScenario(scenario);
		if (!BooleanUtils.toBoolean(BUILD_TOOL_RUN) && !BooleanUtils.toBoolean(HEADLESS)) {
			localVideoRecord();
		}
	}
	@Before("(@Firefox and @Headless) and not (@Edge or @Chrome)")
	public void firefoxBrowserwithHeadless(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.FIRE_FOX, true);
		localheadlessMode=true;
		scenarioContext.setScenario(scenario);
	}

	@Before("not (@Chrome or @Firefox or @Edge)")
	public void defaultBrowser(final Scenario scenario) throws Exception {
		driverProvider.generateWebDriver(WebDriverProvider.BrowserType.CHROME);
		if (!BooleanUtils.toBoolean(BUILD_TOOL_RUN) && !BooleanUtils.toBoolean(HEADLESS)) {
			localVideoRecord();
		}
		scenarioContext.setScenario(scenario);
	}

	@After()
	public void afterMethod(final Scenario scenario) throws Exception {
		scenarioContext.clearContextData();
		if (scenario.isFailed()) {
			scenario.attach(((TakesScreenshot) driverProvider.getInstance()).getScreenshotAs(OutputType.BYTES), "image/png", scenario.getName());
		}
		if (!BooleanUtils.toBoolean(BUILD_TOOL_RUN) && !BooleanUtils.toBoolean(HEADLESS) && !localheadlessMode) {
			VideoRecorder.stopRecording();
			String fileName = FileHandlingUtil.getTheNewestFile(downloadPath, videoFileType);
			//FileHandlingUtil.deleteExistingFile(fileName);
		}
		driverProvider.getInstance().quit();
	}
	private void localVideoRecord() throws Exception {
		if (!BooleanUtils.toBoolean(System.getProperty("buildToolRun"))) {
			VideoRecorder.startRecording();
		}
	}

}
