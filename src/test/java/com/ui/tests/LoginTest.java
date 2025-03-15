package com.ui.tests;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.*;


import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase{

	Logger logger =LoggerUtility.getLogger(this.getClass());
	
	@Test(description="Login Test",groups= {"Sanity","E2E"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider")
	public void LoginTest(User user) {
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Neelam C");		
	}
	
	@Test(description="Login Test",groups= {"Sanity","E2E"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestCSVDataProvider")
	public void LoginCSVTest(User user) {
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Viren C");		
	}
	
	@Test(description="Login Test",groups= {"Sanity","E2E"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestExcelDataProvider",retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void LoginExcelTest(User user) {
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Viren C");
		
	}


}
