package com.launchpad.getpageobjects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ObjectFileReader {


	static String sFilePath = "src/test/resources/PageObjectRepository/LaunchPad/QA/LoginPage.txt";
	
	
	// In this method i am going to pass the element name and this will read the value of that element name 
	//??? I still have to figure out how to get the type
	public static void main(String[] args){
	 
		String[] field = textFileReader("field_email");
		
		System.out.println(field[2]);	
		
		
		/*String[] field = textFileReader(field_Email);
		field.toString();
		System.out.println(String.valueOf(field).toString());
		
		//
*/		
	}
		
public static String[] textFileReader(String ElementName){
		
		
				
		//Create a FileReader Object
		FileReader fr = null;
		//Create a bufferReader Object
		BufferedReader textReader= null;
		//Handling exception using try catch
		String returnElement = "";
		try{
			String sCurrentLine;
			fr = new FileReader(sFilePath);
			textReader = new BufferedReader(fr);
			//Reading the file until the file is null
			
			while ((sCurrentLine = textReader.readLine()) !=null){
				/*if (sCurrentLine.trim().startsWith("#")) {
					continue;
				}*/
				
				if (sCurrentLine.split(":", 3)[0].equalsIgnoreCase(ElementName)) {
					returnElement= sCurrentLine;
					break;
				}
				//sCurrentLine = textReader.readLine();
				
				
			}
		} catch (IOException e){
			e.printStackTrace();
		} finally{
			try{
				if(textReader != null)textReader.close();
			} catch (IOException ex){
				ex.printStackTrace();
			}
		}
		
		
		return returnElement.split(":", 3);
		
		
				
		
	}

	
	
}
