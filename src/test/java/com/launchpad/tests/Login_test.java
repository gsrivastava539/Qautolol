package com.launchpad.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.launchpad.actions.LoginPageActions;
import com.launchpad.automation.TestSessionInitiator;
import static com.launchpad.utils.YamlReader.getData;

public class Login_test {
	
	
	LoginPageActions lpactions;
	TestSessionInitiator test;
	String baseurl; 
	
	@BeforeClass(alwaysRun=true)
	public void setup(){
		
		//lpactions = new LoginPageActions(driver); //initialize the actions class
		//lpactions = PageFactory.initElements(driver, LoginPageActions.class);
		test = new TestSessionInitiator();
		baseurl= getData("URL.myers10e");
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
		//test.launchApplication(baseurl);
		test.loadbrowser();
		test.launchApplication(baseurl);
		/*driver.get(lpactions.PAGE_URL);
		lpactions.setText_EmailLogin("g.s.instructor@macmillan.com");
		lpactions.setText_PasswordLogin("Password1");
		lpactions.clickSignInButton_on_homepage();*/
	}
	
	
}
