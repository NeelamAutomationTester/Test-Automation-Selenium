package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;


public class deleteAddressTest extends TestBase{
	
	private AddressPage addressPage;
	
	@BeforeMethod(description = "User should navigate to the MyAddresses page")
	public void setUp() {
		
		addressPage = homePage.goToLoginPage().doLoginWith("pagojeb607@kimasoft.com","password").goToMyAddressesPage();		
		
	}
	
	@Test(priority = 1, description = "Delete address", groups = {"Sanity", "Smoke", "E2E" })
	public void deleteAddress() {
		
		String alertMessage = addressPage.deleteAddress();
		Assert.assertEquals(alertMessage,"Are you sure?");
		
	}
	
	

}
