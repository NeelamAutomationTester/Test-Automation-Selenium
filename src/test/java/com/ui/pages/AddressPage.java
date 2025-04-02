package com.ui.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPojo;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility{
	
	private static final By COMPANY_TEXTBOX_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXTBOX_LOCATOR = By.id("address1");
	private static final By ADDRESS2_TEXTBOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXTBOX_LOCATOR = By.id("city");
	private static final By POSTALCODE_TEXTBOX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_TEXTBOX_LOCATOR = By.id("phone");
	private static final By MOBILE_PHONE_TEXTBOX_LOCATOR = By.id("phone_mobile");
	private static final By ADDITIONAL_INFO_TEXTBOX_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.id("alias");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By SAVE_ADDRESS_BUTTON_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADING = By.tagName("h3");
	private static final By DELETE_ADDRESS_BUTTON_LOCATOR = By.xpath("//a[@title=\"Delete\"]");
	//private static final By DELETE_ADDRESS2_BUTTON_LOCATOR = By.xpath("//ul[@class=\"last_item alternate_item box\"]/li[9]/a[@title=\"Delete\"]");
	private static final By ADD_A_NEW_ADDRESS_BUTTON_LOCATOR = By.xpath("//a[@title=\"Add an address\"]");
	

	public AddressPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	
	public String saveAddress(AddressPojo address) {
		
		enterText(COMPANY_TEXTBOX_LOCATOR, address.getCompanyName());
		enterText(ADDRESS1_TEXTBOX_LOCATOR, address.getAddress1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR, address.getAddress2());
		enterText(CITY_TEXTBOX_LOCATOR, address.getCityName());
		enterText(POSTALCODE_TEXTBOX_LOCATOR, address.getPostcode());
		enterText(HOME_PHONE_TEXTBOX_LOCATOR, address.getHomePhone());
		enterText(MOBILE_PHONE_TEXTBOX_LOCATOR, address.getMobilePhone());
		clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR, address.getAddressAlias());
		enterText(ADDITIONAL_INFO_TEXTBOX_LOCATOR, address.getAdditionalInfo());
		selectFromDropdown(STATE_DROPDOWN_LOCATOR,address.getStateName());
		clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
		String addressAlias = getVisibleText(ADDRESS_HEADING);
		
		 return addressAlias;	
		
	}
	
	public AddressPage goToaddANewAddressFromMyAddresses() {
		
		clickOn(ADD_A_NEW_ADDRESS_BUTTON_LOCATOR);
		return new AddressPage(getDriver());
	}
	
	public String deleteAddress() {
		
		
		clickOn(DELETE_ADDRESS_BUTTON_LOCATOR);
		return acceptAlert();
		
		
	}
	
		
	public String addAddressForDeleteAddressTest(AddressPojo address) {
		
		enterText(COMPANY_TEXTBOX_LOCATOR, address.getCompanyName());
		enterText(ADDRESS1_TEXTBOX_LOCATOR, address.getAddress1());
		enterText(ADDRESS2_TEXTBOX_LOCATOR, address.getAddress2());
		enterText(CITY_TEXTBOX_LOCATOR, address.getCityName());
		enterText(POSTALCODE_TEXTBOX_LOCATOR, address.getPostcode());
		enterText(HOME_PHONE_TEXTBOX_LOCATOR, address.getHomePhone());
		enterText(MOBILE_PHONE_TEXTBOX_LOCATOR, address.getMobilePhone());
		clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR, "Delete Address");
		enterText(ADDITIONAL_INFO_TEXTBOX_LOCATOR, address.getAdditionalInfo());
		selectFromDropdown(STATE_DROPDOWN_LOCATOR,address.getStateName());
		clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
		String addressAlias = getVisibleText(ADDRESS_HEADING);
		
		 return addressAlias;	
	
		
		
	}

}
