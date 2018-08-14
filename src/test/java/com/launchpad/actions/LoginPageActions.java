package com.launchpad.actions;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class LoginPageActions {
	
	public static final String PAGE_TITLE="Macmillan Launchpad: Login";
	public static final String PAGE_URL="";
	
	@FindBy(xpath=".//*[@placeholder='Email']") WebElement field_Email;
	@FindBy(xpath=".//*[@placeholder='Password']") 	WebElement field_Password;
	@FindBy(className="ladda-label") WebElement button;
		
	// Create a instance object of a webdriver class
	WebDriver driver;
	
	// Create a constructor and pass the driver
	public LoginPageActions(WebDriver driver){this.driver=driver;}

	
	public void setText_EmailLogin(String text){
		System.out.println("test");
		field_Email.clear();
		field_Email.sendKeys(text);
		Assert.assertEquals(field_Email.getAttribute("value"), text);
	}
	
	
	public void setText_PasswordLogin(String text){
		field_Password.sendKeys(text);
		Assert.assertEquals(field_Password.getAttribute("value"), text);
	}
	
	
	public void clickSignInButton_on_homepage(){
		button.click();
	}
	
	
	@DataProvider
	public void username_Password_check(){
		
		
	}
	
	
}
