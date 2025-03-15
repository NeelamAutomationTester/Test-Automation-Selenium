package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;

import static com.utility.PropertiesUtil.*;

public final class HomePage extends BrowserUtility{

	public HomePage(Browser browserName) {
		super(browserName);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}
	
	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName,isHeadless);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}
	

	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(QA).getUrl());
	}


	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");
	
	public LoginPage goToLoginPage() {
		
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}

	
	
	
	
}
