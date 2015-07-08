package com.launchpad.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class YamlReader {

	static String YamlFilePath = "src/test/resources/testdata/";
	

	public static void main(String[] args){
		System.out.println(getYamlValue("bookidentifier.calculus"));
	}
	

	@SuppressWarnings("unchecked")
	private static String getYamlValue(String token){
		
		try{
		Reader doc = new FileReader(YamlFilePath + File.separator + "LAUNCHPAD" + File.separator + "QA" + "_testdata.yml");
		Yaml yml = new Yaml();
		Map<String, Object> object = (Map<String, Object>) yml.load(doc);
		return getMapValue(object, token);
		}catch (IOException e){
			e.printStackTrace();
			return null;
		}
		
	}


	private static String getMapValue(Map<String, Object> object, String token) {
		// TODO Auto-generated method stub
		Map<String, Object> mm = parseMap(object, token);
		String[] str = token.split("\\.");
		return 	mm.get(str[str.length - 1]).toString();
				//parseMap(object, token).get(str[str.length - 1]).toString();
		
		
	}


	@SuppressWarnings("unchecked")
	private static Map<String, Object> parseMap(Map<String, Object> object,
			String token) {
		// TODO Auto-generated method stub
		System.out.println("This is the third " + token);
		if (token.contains(".")) {
			String[] str = token.split("\\.");
			object = parseMap((Map<String, Object>) object.get(str[0]), token.replace(str[0] + ".", "123"));
		}
		return object;
		
		
	}
	
}
