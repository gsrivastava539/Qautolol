package com.launchpad.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author 
 *
 */
public class SeleniumWait {

	WebDriver driver;
	WebDriverWait wait;
	public int timeout;
	
	public SeleniumWait(WebDriver driver, int timeout){
		this.driver=driver;
		this.timeout=timeout;
		this.wait=new WebDriverWait(driver, timeout);
	}
	
	
	
	/**
	 * If the element is visible it returns the webElement found by locator
	 * @param locator
	 * @return
	 */
	public WebElement getWhenVisible(By locator){
		WebElement element;
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
		
	}
	
	/**
	 * Wait for an element to be clickable 
	 * @param locator
	 * @return
	 */
	public WebElement getWhenClickable(By locator){
		WebElement element;
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element;
	}
	
	
	 /**
	  * Wait for a page title to be exact the same
	 * @param expectedPagetitle
	 * @return
	 */
	public boolean waitForPageTitleToBeExact(String expectedPagetitle) {
	        return wait.until(ExpectedConditions.titleIs(expectedPagetitle));
	    }
	
	
	/**
	 * @param expectedPagetitle
	 * @return
	 */
	public boolean waitForPageTitleToContain(String expectedPagetitle) {
        return wait.until(ExpectedConditions.titleContains(expectedPagetitle));
    }
    
	
	/**
	 * @param element
	 * @return
	 */
	public WebElement waitForElementToBeVisible(WebElement element) {	
    	try{
    		return wait.until(ExpectedConditions.visibilityOf(element));
    	}
    	catch(StaleElementReferenceException e){
    		return wait.until(ExpectedConditions.visibilityOf(element));
    	}
    }
	
	
	 /**
	 * @param locator
	 */
	public void waitForFrameToBeAvailableAndSwitchToIt(By locator) {
	        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	    }
	    
	 
	 
	 /**
	 * @param elements
	 * @return
	 */
	public List<WebElement> waitForElementsToBeVisible(List<WebElement> elements) {
	        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	    }
	
	/**
	 * @param locator
	 * @return
	 */
	public boolean waitForElementToBeInVisible(By locator) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
	
	
	/**
	 * @param element
	 * @return
	 */
	public WebElement waitForElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
	
	
	/**
	 * @param locator
	 */
	public void clickWhenReady(By locator) {
        WebElement element = wait.until(ExpectedConditions
                .elementToBeClickable(locator));
        element.click();
    }
	
	
	
	
}
