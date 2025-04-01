package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPojo;
import com.utility.FakerUtility;

public class AddFirstNewAdressTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private AddressPojo address;
	
	@BeforeMethod(description = "A valid first time user is logged into the application")
	public void setUp() {
		
		myAccountPage = homePage.goToLoginPage().doLoginWith("pagojeb607@kimasoft.com","password");
		address = FakerUtility.getFakeAddress();
	}
	
	@Test(priority = 3, description = "Add address", groups = {"Sanity", "Smoke", "E2E" })
	public void addNewAddress() {
		
		String addressAlias = myAccountPage.goToAddAddressPage().saveAddress(address);
		Assert.assertEquals(addressAlias,address.getAddressAlias().toUpperCase());
		
	}

}
