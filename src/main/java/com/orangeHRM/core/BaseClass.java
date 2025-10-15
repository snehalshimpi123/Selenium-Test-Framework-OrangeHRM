package com.orangeHRM.core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;
import com.orangeHRM.helper.BaseHelper;
import com.orangeHRM.utils.ExtentReportUtils;
import com.orangeHRM.utils.LoggerManager;
import com.orangeHRM.utils.PropertiesReader;

public class BaseClass {
	public static ChromeDriver driver;
	public static String reportFolder;
	public static final Logger logger = LoggerManager.getLogger(BaseClass.class);
	
	@BeforeSuite(alwaysRun = true)
	public void setup() throws InterruptedException {
		//reportFolder = System.getProperty("user.dir")+"/reports/"+BaseHelper.TimeStamp();
		
		reportFolder = System.getProperty("user.dir")+"/resources/";
		BaseHelper.createFolder(reportFolder);
		ExtentReportUtils.initialize(reportFolder+"/ExtentReport.html");
	
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
		options.addArguments("--disable-notifications");
		options.addArguments("--no-sandbox");
		
		
		
		driver = new ChromeDriver(options);
		driver.get(PropertiesReader.getConfigValue("url"));
		driver.manage().window().maximize();
		logger.info("WebDriver intialized and launched the bowser");
		//driver.manage().deleteAllCookies();
				
	}
	
	@BeforeMethod(alwaysRun = true)
	public void setupReport(Method m)
	{
		ExtentReportUtils.extentLog = ExtentReportUtils.extentReport.createTest(m.getName(), "Test Started");
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {
		
		switch(result.getStatus()) {
		
		case ITestResult.SUCCESS:
			ExtentReportUtils.extentLog.log(Status.PASS, "Test case "+result.getName()+" is PASSED");
			break;
		
		case ITestResult.FAILURE:
			ExtentReportUtils.extentLog.log(Status.FAIL, "Test case "+result.getName()+" is FAILED" );
			ExtentReportUtils.extentLog.log(Status.INFO, result.getThrowable());
			break;
			
		case ITestResult.SKIP:
			ExtentReportUtils.extentLog.log(Status.SKIP, "Test case "+result.getName()+" is SKIPPED");
			break;
			
		default:
			ExtentReportUtils.extentLog.log(Status.INFO, "Test Case in default area");
		}
			
		//ExtentReportUtils.extentReport.endTest(ExtentReportUtils.extentLog);	
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		driver.quit();
		//ExtentReportUtils.extentReport.close();
		ExtentReportUtils.extentReport.flush();
	}
	
    public static String captureScreenShot() {
    	String destinationfilePath=null;
    	try {
	    	File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);	
	    	destinationfilePath = reportFolder+"/screenshots"+BaseHelper.TimeStamp()+".png";
			FileUtils.copyFile(file, new File(destinationfilePath));
			//ExtentReportUtils.extentLog.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath(destinationfilePath).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return destinationfilePath;
    	
	}
	
}
