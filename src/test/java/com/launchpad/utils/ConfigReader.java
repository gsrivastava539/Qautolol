package com.launchpad.utils;

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class ConfigReader {

	static String filePath = "Config.properties";
		
	public static String getConfigProperty(String key) {

		Reader doc = null;
		Properties prop = new Properties();

		try {
			doc = new FileReader(filePath);
			prop.load(doc);
			return prop.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String getConfigProperty(String yourfilePath, String key) {

		Reader doc = null;
		Properties prop = new Properties();

		try {
			doc = new FileReader(yourfilePath);
			prop.load(doc);
			return prop.getProperty(key);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	
}
