package com.ui.tests;

import org.apache.logging.log4j.Logger;
import static org.testng.Assert.*;
import org.testng.annotations.*;

import com.ui.pages.HomePage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public class SearchProductTest extends TestBase {
	
	private MyAccountPage myaccountpage;
	private static final String SEARCH_TERM = "printed summer dress";
	Logger logger = LoggerUtility.getLogger(this.getClass());

	@BeforeMethod(description = "A valid user is logged into the application")
	public void setUp() {
		
		 myaccountpage = homePage.goToLoginPage().doLoginWith("pagojeb607@kimasoft.com","password");

	}

	@Test(priority = 2, description = "Verify that the user is able to search a product and correct results are displayed as a search result", groups = {
			"Sanity", "Smoke", "E2E" })
	public void verifyProductSearchTest() {

		boolean actualResult = myaccountpage.searchForAProduct(SEARCH_TERM).isSearchTermPresentProductList(SEARCH_TERM);
		assertEquals(actualResult,true);
		
	}

}