package com.launchpad.actions;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;

public class LoginPageActions {
	
	public static final String PAGE_TITLE="Macmillan Launchpad: Login";
	public static final String PAGE_URL="http://qa.macmillanhighered.com/launchpad/hockenbury6e/";
	
	@FindBy(xpath=".//*[@placeholder='Email']") WebElement field_Email;
	@FindBy(xpath=".//*[@placeholder='Password']") 	WebElement field_Password;
	@FindBy(className="ladda-label") WebElement button;
	
	//String field_Email=".//*[@placeholder='Email']";
	//String field_Password=".//*[@placeholder='Password']";
	
	WebDriver driver;
	
	public LoginPageActions(WebDriver driver){this.driver=driver;}

	
	public void setText_EmailLogin(String text){
		System.out.println("test11ad1sss112121221111");
		field_Email.clear();
		field_Email.sendKeys(text);
		Assert.assertEquals(field_Email.getAttribute("value"), text);
	}
	
	
	public void setText_PasswordLogin(String text){
		//WebElement element=driver.findElement(By.xpath(field_Password));
		
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
