package com.launchpad.automation;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.launchpad.getpageobjects.Browsers;

public class WebDriverFactory {

	private static String chromeDriverPath = "src/test/resources/drivers/chromedriver";
	private static String browser, seleniumserver;
	private static String iEDriverPath = "src/test/resources/drivers/IEDriverServer" ;
	private static DesiredCapabilities capabilities = new DesiredCapabilities();
		
	/*public WebDriver getDriver(){
		
		if (getConfigProperty("Browser")=="firefox") {
			return getFirefoxDriver();
		} else if (getConfigProperty("Browser")=="Chrome") {
			return getChromeDriver(chromeDriverPath);
		} 
		
		
		{

		}
		
		
		
		return getFirefoxDriver();
		
		
	}*/

	private WebDriver getChromeDriver(String driverpath) {
		System.setProperty("webdriver.chrome.driver", driverpath);
		capabilities.setJavascriptEnabled(true);
		return new ChromeDriver(capabilities);
	}

	private WebDriver getFirefoxDriver() {
		// TODO Auto-generated method stub
		
		return new FirefoxDriver();
	}

	public  WebDriver getDriver(Map<String, String> seleniumconfig) {
		// TODO Auto-generated method stub
		browser = System.getProperty("browser");
		seleniumserver=System.getProperty("seleniumserver");
		 
		if (browser==null) {
			browser=seleniumconfig.get("browser").toString();
			
		}
		if (seleniumserver==null) {
			seleniumserver = seleniumconfig.get("seleniumserver").toString();
			
		}
		if (seleniumserver.equalsIgnoreCase("remote")) {
			return setRemoteDriver(seleniumconfig);
		}else{
			switch (Browsers.valueOf(browser)) {
			case firefox:
			case FIREFOX:
				return getFirefoxDriver();
			case chrome:
			case CHROME:
				if(System.getProperty("os.name").toUpperCase().equals("LINUX")){
					return getChromeDriver(chromeDriverPath);
				}
				else return getChromeDriver(chromeDriverPath+".exe");
			case ie:
			case IE:
			case internetexplorer:
			case InternetExplorer:
				return getInternetExplorerDriver(iEDriverPath+".exe");
				
			case Safari:
           	case SAFARI:
           	case safari:
           				return getSafariDriver();
			
			default:
				return new FirefoxDriver();
			}
		}
		
	}

	private WebDriver getSafariDriver() {
		// TODO Auto-generated method stub
		return null;
	}

	private WebDriver getInternetExplorerDriver(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	private WebDriver setRemoteDriver(Map<String, String> selConfig) {
		// TODO Auto-generated method stub
		 DesiredCapabilities cap = null;
	        browser = System.getProperty("browser");
	        if(browser==null)
	        		browser = selConfig.get("browser").toString();
	        if (browser.equalsIgnoreCase("firefox")) {
	            cap = DesiredCapabilities.firefox();
	        } else if (browser.equalsIgnoreCase("chrome")) {
	            cap = DesiredCapabilities.chrome();
	        } else if (browser.equalsIgnoreCase("Safari")) {
	            cap = DesiredCapabilities.safari();
	        } else if ((browser.equalsIgnoreCase("ie"))
	                || (browser.equalsIgnoreCase("internetexplorer"))
	                || (browser.equalsIgnoreCase("internet explorer"))) {
	            cap = DesiredCapabilities.internetExplorer();
	        }
	        String seleniuhubaddress = System.getProperty("hub");
	        if (seleniuhubaddress==null) seleniuhubaddress = selConfig.get("seleniumserverhost1");
	        else{
	        	if(System.getProperty("hub").equals("hub1"))
	        		seleniuhubaddress = selConfig.get("seleniumserverhost1");
	        	else if(System.getProperty("hub").equals("hub2"))
	        		seleniuhubaddress = selConfig.get("seleniumserverhost2");
	        }
	        URL selserverhost = null;
	        try {
	            selserverhost = new URL(seleniuhubaddress);
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	        cap.setJavascriptEnabled(true);
	        return new RemoteWebDriver(selserverhost, cap);
	}
	
	
}
