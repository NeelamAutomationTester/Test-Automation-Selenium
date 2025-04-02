package com.utility;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v131.indexeddb.model.Key;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.utility.LoggerUtility;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;
	

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			System.err.println("Invalid browser name!!");
		}
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			System.err.println("Invalid browser name!!");
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {

		logger.info("Launching Browser for " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}

		} else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");

				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
			}
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
		} else {
			System.err.println("Invalid browser name!!");
		}
	}

	public void goToWebsite(String url) {

		driver.get().get(url); // navigates to the url and waits till the page is loaded completely.
	}

	public void maximizeBrowserWindow() {

		driver.get().manage().window().maximize(); // Maximizes browser window.
	}
	
	public void clickOn(By locator) {

		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void clickOnCheckbox(By locator) {

		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
	}

	public void clickOn(WebElement webElement) {

		logger.info("Clicking on the webelement " + webElement);

		webElement.click();
	}

	public void enterText(By locator, String value) {

		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(value);
	}

	public void clearText(By textboxlocator) {

		logger.info("Finding element with the locator " + textboxlocator);
		//WebElement element = driver.get().findElement(textboxlocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textboxlocator));

		logger.info("Element found!! and now clearing the text in the text box.." + textboxlocator);
		element.clear();
	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {

		logger.info("Finding element with the locator " + locator);
		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element found!! and now enter special key.." + keyToEnter);
		element.sendKeys(keyToEnter);
	}

	public void selectFromDropdown(By locator, String optionToBeSelected) {

		logger.info("Finding element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);

		Select select = new Select(element);
		logger.info("Selecting the option from dropdown " + optionToBeSelected);

		select.selectByVisibleText(optionToBeSelected);

	}

	public String getVisibleText(By locator) {
		logger.info("Finding element with the locator " + locator);
		WebElement element = driver.get().findElement(locator);

		logger.info("Element found!! and now printing the text..");
		return element.getText();

	}

	public String getVisibleText(WebElement element) {

		logger.info("Printing the visible text for the element" + element);
		return element.getText();

	}

	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding elements with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		List<String> visibleTextList = new ArrayList<String>();

		logger.info("Elements found!! and now printing all the elements: ");
		for (WebElement element : elementList) {

			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));

		}
		return visibleTextList;
	}

	public List<WebElement> getAllElements(By locator) {
		logger.info("Finding elements with the locator " + locator);
		List<WebElement> elementList = driver.get().findElements(locator);

		return elementList;
	}
	
	public String acceptAlert() {
		
		Alert alert = driver.get().switchTo().alert();		
		logger.info("Accepting alert..");
		String alertMessage = alert.getText();
		alert.accept();
		return alertMessage;
		
	}

	public String takeScreenshot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotdata = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		// String path = System.getProperty("user.dir")+"//screenshots//"+name + " -
		// "+timestamp+".png";
		String path = "./screenshots/" + name + " - " + timestamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotdata, screenshotFile);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return path;

	}

	public void quit() {
		driver.get().quit();
	}
}
