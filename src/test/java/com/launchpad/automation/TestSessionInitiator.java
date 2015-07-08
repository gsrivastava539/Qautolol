package com.launchpad.automation;

import java.util.HashMap;
import java.util.Map;
import static com.launchpad.utils.ConfigReader.getConfigProperty;

public class TestSessionInitiator {

	/*public static void main (String[] args){
		System.out.println(getBrowser());
	}*/
	
	
	
	private  Map<String, String> _getSessionConfig(){
		String[] configKeys = {"tier","browser"};
		Map<String, String> config = new HashMap<String, String>();
		for (String string : configKeys) {
			config.put(string, getConfigProperty("./Config.properties", string));
		}
		
		return config;
		
	}
	
	public  String getBrowser(){
		String browser = System.getProperty("browser");
		if (browser == null) {
			browser = _getSessionConfig().get("browser");
		}
		
		return browser;
	}
	
	public  String getTier(){
		String tier = System.getProperty("tier");
		if (tier == null) {
			tier = _getSessionConfig().get("tier");
		}
		
		return tier;
	}
	
	
}
