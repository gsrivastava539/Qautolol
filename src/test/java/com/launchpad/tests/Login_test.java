package com.launchpad.tests;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.launchpad.actions.LoginPageActions;

public class Login_test {
	
	public WebDriver driver;
	LoginPageActions lpactions;
		
	
	@BeforeClass(alwaysRun=true)
	public void setup(){
		driver = new FirefoxDriver();
		//lpactions = new LoginPageActions(driver); //initialize the actions class
		lpactions = PageFactory.initElements(driver, LoginPageActions.class);
	}
	
	@AfterClass(alwaysRun=true)
	public void teardown(){
		//driver.quit();
	}
	
	
	/*@Test(groups={"p1", "Pageloads"})
	public void loadPage(){
		driver.get(lpactions.PAGE_URL);
		Assert.assertEquals(driver.getTitle(), lpactions.PAGE_TITLE );
	}
	
	@Test(groups={"p2", "emailfield"},dependsOnMethods="loadPage")
	public void fillOutEmailField(){
		lpactions.setText_EmailLogin("g.s.instructor@macmillan.com");
		
		
	}
	
	@Test(groups={"p2", "passwordfield"},dependsOnMethods="fillOutEmailField")
	public void fillOutPasswordField(){
		lpactions.setText_PasswordLogin("Password1");
	
	}*/
	
	@Test
	public void signin(){
		driver.get(lpactions.PAGE_URL);
		lpactions.setText_EmailLogin("g.s.instructor@macmillan.com");
		lpactions.setText_PasswordLogin("Password1");
		lpactions.clickSignInButton_on_homepage();
	}
	
	
}
