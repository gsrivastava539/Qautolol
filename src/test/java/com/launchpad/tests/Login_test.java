package com.launchpad.tests;

import static com.launchpad.utils.YamlReader.getData;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.launchpad.automation.LaunchPadTestSessionInitiator;
import com.launchpad.automation.TestSessionInitiator;

public class Login_test {
	
	
	
	TestSessionInitiator test;
	String baseurl; 
	
	@BeforeClass(alwaysRun=true)
	public void setup(){
		test = new LaunchPadTestSessionInitiator();
		baseurl= getData("URL.myers10e");
	}
	
	@AfterClass(alwaysRun=true)
	public void teardown(){
		//driver.quit();
	}
	
	@Test
	public void signin(){
		
		test.launchApplication(baseurl);
	
	}
	
	
}
