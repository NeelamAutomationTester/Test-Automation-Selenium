package com.utility;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
	}

	public BrowserUtility(String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver.set(new EdgeDriver());
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver.set(new FirefoxDriver());
		} else {
			System.err.println("Invalid browser name!!");
		}
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
		} else {
			System.err.println("Invalid browser name!!");
		}
	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		
		//logger.info("Launching Browser for "+browserName );
		if (browserName == Browser.CHROME) {
			if(isHeadless) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=new");
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
			} else {
				driver.set(new ChromeDriver());
			}
		
		} else if (browserName == Browser.EDGE) {
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless=new");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				} else {
					driver.set(new EdgeDriver());
				}
			
		} else if (browserName == Browser.FIREFOX) {
			if(isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				
				driver.set(new FirefoxDriver(options));
				}
			driver.set(new FirefoxDriver());
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

		WebElement element = driver.get().findElement(locator);
		element.click();
	}

	public void enterText(By locator, String value) {

		WebElement element = driver.get().findElement(locator);
		element.sendKeys(value);
	}

	public String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		return element.getText();

	}
	
	
	public String takeScreenshot(String name) {
		
		TakesScreenshot screenshot = (TakesScreenshot)driver.get();
		File screenshotdata = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timestamp = format.format(date);
		String path = System.getProperty("user.dir")+"//screenshots//"+name + " - "+timestamp+".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotdata,screenshotFile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return path;
		
		
	}
	
	public void quit() {
		driver.get().quit();
	}
}
