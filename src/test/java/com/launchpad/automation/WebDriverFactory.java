package com.launchpad.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.launchpad.utils.ConfigReader.getConfigProperty;

public class WebDriverFactory {

	private static String chromeDriverPath = "src/test/resources/drivers/chromedriver";
	
	public WebDriver getDriver(){
		
		if (getConfigProperty("Browser")=="firefox") {
			return getFirefoxDriver();
		} else if (getConfigProperty("Browser")=="Chrome") {
			return getChromeDriver(chromeDriverPath);
		} {

		}
		
		
		
		return getFirefoxDriver();
		
		
	}

	private WebDriver getChromeDriver(String driverpath) {
		// TODO Auto-generated method stub
		return null;
	}

	private WebDriver getFirefoxDriver() {
		// TODO Auto-generated method stub
		
		return new FirefoxDriver();
	}
	
	
}
