package com.launchpad.getpageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.launchpad.utils.*;
import static com.launchpad.utils.ConfigReader.getConfigProperty;

import static com.launchpad.getpageobjects.ObjectFileReader.getPageTitleFromFile;

/*This is a base class and it will contain the methods like
 * Getpagetitle, get current url, log messages etc.
 * 
 * 
 */




public class BaseUi {

	WebDriver driver;
	private String pageName;
	protected SeleniumWait wait;
	
	// Since we will be using webdriver so we have to pass the driver to the entire class as an constructor
	public BaseUi(WebDriver driver, String pageName){
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.pageName = pageName;
		this.wait= new SeleniumWait(driver, Integer.parseInt(getConfigProperty("timeout")));
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
