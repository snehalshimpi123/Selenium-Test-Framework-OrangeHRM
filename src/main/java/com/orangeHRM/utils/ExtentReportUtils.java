package com.orangeHRM.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.orangeHRM.helper.BaseHelper;



public class ExtentReportUtils {

	public static ExtentReports extentReport=null;
	public static ExtentTest extentLog;
	public static String reportPath;
	
	
	public static void initialize(String path) {
		
		if(extentReport==null) {
			
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
			
			extentReport = new ExtentReports();
			extentReport.attachReporter(sparkReporter);
			
			extentReport.setSystemInfo("OS","Windows 11");
			extentReport.setSystemInfo("Hostname", System.getProperty("user.name"));
			extentReport.setSystemInfo("Environment", "QA");
			
		
			//extentReport.loadConfig(new File(System.getProperty("user.dir")+"/resources/extent-config.xml"));
			
		}
		
	}
	
	
}
