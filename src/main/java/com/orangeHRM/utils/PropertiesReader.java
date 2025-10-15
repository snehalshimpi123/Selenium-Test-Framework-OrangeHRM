package com.orangeHRM.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	private static String readConfig(String filePath, String key) {
		
		
		InputStream input;
		Properties prop=null;
		try {
			input = new FileInputStream(filePath);		
			prop = new Properties();
			prop.load(input);
			prop.getProperty(key);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(key);
	}

	
	
	public static String getConfigValue(String key) {
		String filepath = "config.properties";
		return readConfig(filepath, key);
			
	}

}


