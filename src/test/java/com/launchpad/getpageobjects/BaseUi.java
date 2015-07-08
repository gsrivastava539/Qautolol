package com.launchpad.getpageobjects;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import static com.launchpad.getpageobjects.ObjectFileReader.getPageTitleFromFile;
public class BaseUi {

	WebDriver driver;
	String pageName;
	
	// Since we will be using webdriver so we have to pass the driver to the entire class as an constructor
	public BaseUi(WebDriver driver, String pageName){
		this.driver = driver;
		this.pageName = pageName;
	}
	
	
	protected String getPageTitle(){
		return driver.getTitle();
	}
	
	protected String getPageUrl(){
		return driver.getCurrentUrl();
		
	}
	
	protected void logMessage(String message){
		Reporter.log(message, true);
	}
	
	protected void verifyPageTitleExact(){
		
		String[] pageTitle=getPageTitleFromFile(pageName);
		
	}
	
}
