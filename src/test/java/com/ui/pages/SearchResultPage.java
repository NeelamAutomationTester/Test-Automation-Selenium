package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class=\"lighter\"]");

	private static final By ALL_PRODUCT_LIST_NAME = By.xpath("//h5[@itemprop=\"name\"]/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);

	}

	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}

	public boolean isSearchTermPresentProductList(String searchTerm) {

		List<String> searchTextWords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNamesList = getAllVisibleText(ALL_PRODUCT_LIST_NAME);

		boolean result = productNamesList.stream()
				.anyMatch(name -> (searchTextWords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;
	}

	public ProductDetailsPage clickOnTheProductAt(int index) {
		clickOn(getAllElements(ALL_PRODUCT_LIST_NAME).get(index));
		ProductDetailsPage productDetailsPage = new ProductDetailsPage(getDriver());

		return productDetailsPage;

	}

}
