package com.ui.tests;

import static com.constants.Browser.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	private boolean isLambdaTest;

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Parameters({ "browser", "isLambdaTest", "isHeadless" })
	@BeforeMethod(description = "Load the home page of the website")
	public void setUp(@Optional("edge") String browser, @Optional("false") boolean isLambdaTest,
			@Optional("false") boolean isHeadless, ITestResult result) {
		WebDriver lambdaDriver;
		this.isLambdaTest = isLambdaTest;
		if (isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
			homePage = new HomePage(lambdaDriver);

		} else {
			logger.info("Load the Homepage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}

	public BrowserUtility getInstance() {

		return homePage;
	}

	@AfterMethod(description = "Tear down the browser")
	public void tearDown() {		
		
		if (isLambdaTest) {
			LambdaTestUtility.quitSession();
		} else {
			homePage.quit();
		}

	}

}
