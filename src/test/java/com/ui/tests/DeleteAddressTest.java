package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPojo;
import com.utility.FakerUtility;


public class DeleteAddressTest extends TestBase{
	
	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private String addressAlias;
	private AddressPojo address;
	
	@BeforeMethod(description = "User should navigate to the MyAddresses page")
	public void setUp() {
		
		address = FakerUtility.getFakeAddress();
		//addressPage = homePage.goToLoginPage().doLoginWith("pagojeb607@kimasoft.com","password").goToMyAddressesPage().goToaddANewAddressFromMyAddresses();
		//addressPage.addAddressForDeleteAddressTest(address);
		addressPage = homePage.goToLoginPage().doLoginWith("pagojeb607@kimasoft.com","password").goToMyAddressesPage();
		
	}
	
	@Test(priority = 5, description = "Delete address", groups = {"Sanity", "Smoke", "E2E" })
	public void deleteAddress() {
		
		String alertMessage = addressPage.deleteAddress();
		Assert.assertEquals(alertMessage,"Are you sure?");
		
	}
	
	

}
