package com.orangeHRM.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.orangeHRM.core.BaseClass;
import com.orangeHRM.helper.BaseHelper;
import com.orangeHRM.utils.ExtentReportUtils;

public class ListnerClass extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReportUtils.extentLog.log(Status.INFO, result.getName()+" test started!");
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentReportUtils.extentLog.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromPath(captureScreenShot()).build());
	}

	
	

}
