package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility {

	private static final By EMAIL_ADDRESS_TEXTBOX_LOCATOR = By.id("email");
	private static final By PASSWORD_TEXTBOX_LOCATOR = By.id("passwd");
	private static final By SIGNIN_BUTTON_LOCATOR = By.id("SubmitLogin");
	private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");

	public LoginPage(WebDriver driver) {
		super(driver);

	}

	public MyAccountPage doLoginWith(String emailAddress, String password) {

		enterText(EMAIL_ADDRESS_TEXTBOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SIGNIN_BUTTON_LOCATOR);

		MyAccountPage myAccountPage = new MyAccountPage(getDriver());
		return myAccountPage;
	}

	public LoginPage doLoginWithInvalidCredentials(String emailAddress, String password) {

		enterText(EMAIL_ADDRESS_TEXTBOX_LOCATOR, emailAddress);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SIGNIN_BUTTON_LOCATOR);

		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
	
	
	public String getErrorMessage() {
		return getVisibleText(ERROR_MESSAGE_LOCATOR);
	}

}
