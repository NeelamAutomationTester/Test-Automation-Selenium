package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.*;


import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class InvalidCredLoginTest extends TestBase{

	Logger logger =LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS = "pagojeb707@kimasoft.com";
	private static final String INVALID_PASSWORD = "Qhj123";
	
	@Test(priority = 0, description="Verify if the error message is displayed for the user when they enter invalid credentials",groups= {"Sanity","E2E"})
	public void loginTest() {
		
		assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMessage(),"Authentication failed.");
				
	
	}
	
}
