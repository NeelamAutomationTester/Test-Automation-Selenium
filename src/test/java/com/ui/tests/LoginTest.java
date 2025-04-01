package com.ui.tests;

import org.apache.logging.log4j.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.*;


import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest extends TestBase{

	Logger logger =LoggerUtility.getLogger(this.getClass());
	
	@Test(priority = 0, description="Login Test",groups= {"Sanity","E2E"},dataProviderClass=com.ui.dataproviders.LoginDataProvider.class,dataProvider="LoginTestDataProvider")
	public void loginTest(User user) {
		
		assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Neelam C");		
	}
	



}
