package com.ui.tests;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.constants.Size.*;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pages.ProductDetailsPage;
import com.ui.pages.SearchResultPage;
import com.ui.pojo.AddressPojo;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;

	@BeforeMethod(description = "User logs in to the application and searches for a product")
	public void setUp() {

		searchResultPage = homePage.goToLoginPage().doLoginWith("pagojeb607@kimasoft.com", "password")
				.searchForAProduct(SEARCH_TERM);

	}

	@Test(priority = 4, description = "Verify if the logged-in user is able to buy the product", groups = { "E2E",
			"smoke" })
	public void checkoutTest() {
		String orderStatusMessage = searchResultPage.clickOnTheProductAt(1).changeSize(L).addProductToCart()
				.proceedToCheckout().goToConfirmAddressPage().goToShipmentPage().goToPaymentPage().confirmOrder();
		Assert.assertTrue(orderStatusMessage.contains("complete"));

	}

}
