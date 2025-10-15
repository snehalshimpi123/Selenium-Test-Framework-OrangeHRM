package com.orangeHRM.helper;

import java.io.File;
import java.util.Date;

public class BaseHelper {

	public static void createFolder(String path) {
		
		File file = new File(path);
		if(!file.exists()) {
			
			file.mkdir();
			System.out.println("Report folder created!!!");
		}
		else {
			System.out.println("Report folder already exists...");
		}
	}
	
	public static String TimeStamp() {
		
		
		return new Date().toString().replace(":", "-");
		
	}	
	
}
