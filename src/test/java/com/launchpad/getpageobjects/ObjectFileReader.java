package com.launchpad.getpageobjects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class ObjectFileReader {


	static String sFilePath = "src/test/resources/PageObjectRepository/";
	static String tier;
	
	// In this method i am going to pass the element name and this will read the value of that element name 
	//??? I still have to figure out how to get the type
	
/*	public static void main (String[] args){
		
		//String[] s = getPageTitle("LoginPage");
		String[] s2 = textFileReader("LoginPage", "loginbutton");
		
		//System.out.println(s[1]);
		System.out.println(s2[2]);
	}*/
	
	
	public static String[] getPageElementFromFile(String pageName, String ElementName){
				
		//Create a FileReader Object
		FileReader fr = null;
		//Create a bufferReader Object
		BufferedReader textReader= null;
		//Handling exception using try catch
		String returnElement = "";
		try{
			String sCurrentLine;
			fr = new FileReader(sFilePath + "LaunchPad" + File.separator + "QA" + File.separator + pageName + ".txt");
			textReader = new BufferedReader(fr);
			//Reading the file until the file is null
			
			while ((sCurrentLine = textReader.readLine()) !=null){
								
				if (sCurrentLine.split(":", 3)[0].equalsIgnoreCase(ElementName)) {
					returnElement= sCurrentLine;
					break;
				}
				
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
	
	public static String[] getPageTitleFromFile(String pageName){
		
		FileReader fr = null;
		BufferedReader textReader = null;
		String returnElement = null;
		try{
			String sCurrentline;
			fr = new FileReader(sFilePath + "LaunchPad" + File.separator + "QA" + File.separator + pageName + ".txt");
			textReader = new BufferedReader(fr);
			while ((sCurrentline = textReader.readLine()) != null){
				if (sCurrentline.split(":", 2)[0].equalsIgnoreCase("Title")
					|| (sCurrentline.split(":", 2)[0].equalsIgnoreCase("Pagetitle")))
					{
					returnElement=sCurrentline;
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(textReader != null)textReader.close();
			} catch (IOException er){
				er.printStackTrace();
			}
		}
		
		return returnElement.split(":", 2);
		
	}
}
