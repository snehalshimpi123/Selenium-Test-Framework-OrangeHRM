package com.practice;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.orangeHRM.core.BaseClass;
import com.orangeHRM.listeners.ListnerClass;
import com.orangeHRM.pages.HomePage;
import com.orangeHRM.pages.LoginPage;
import com.orangeHRM.utils.ExtentReportUtils;


@Listeners(com.orangeHRM.listeners.ListnerClass.class)
public class LoginTest extends BaseClass{

	@Test
	public void TC_validateLoginToApp() {
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		ExtentReportUtils.extentLog.log(Status.INFO, "Validate Login Successful");
		
		loginPage.loginApp();
		assertTrue(homePage.dashboardHeader.isDisplayed(), "Login Unsuccessful");
		
		ExtentReportUtils.extentLog.log(Status.INFO, "Validate dashboard widget tiles");
		assertTrue(homePage.dashboardWidgetHeaders.get(0).getText().trim().contains("Time at Work"));
		assertTrue(homePage.dashboardWidgetHeaders.get(1).getText().trim().contains("My Actions"));
		assertTrue(homePage.dashboardWidgetHeaders.get(2).getText().trim().contains("Quick Launch"));
		assertTrue(homePage.dashboardWidgetHeaders.get(3).getText().trim().contains("Buzz Latest Posts"));
		assertTrue(homePage.dashboardWidgetHeaders.get(4).getText().trim().contains("Employees on Leave Today"));
		assertTrue(homePage.dashboardWidgetHeaders.get(5).getText().trim().contains("Employee Distribution by Sub Unit"));
		assertTrue(homePage.dashboardWidgetHeaders.get(6).getText().trim().contains("Employee Distribution by Location"));
		logger.info("Test case TC_validateLoginToApp is passed");
	}
	
	
	@Test
	public void TC_validateLoginToApp2() {
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		ExtentReportUtils.extentLog.log(Status.INFO, "Validate Login Successful");
		//loginPage.loginApp();
		assertTrue(homePage.dashboardHeader.isDisplayed(), "Login Unsuccessful");
		ExtentReportUtils.extentLog.log(Status.INFO, "Validate dashboard widget tiles");
		assertTrue(homePage.dashboardWidgetHeaders.get(0).getText().trim().contains("Time at Work"));
		assertTrue(homePage.dashboardWidgetHeaders.get(1).getText().trim().contains("My Actions"));
		assertTrue(homePage.dashboardWidgetHeaders.get(2).getText().trim().contains("Quick Launch"));
		assertTrue(homePage.dashboardWidgetHeaders.get(3).getText().trim().contains("Buzz Latest Posts"));
		assertTrue(homePage.dashboardWidgetHeaders.get(4).getText().trim().contains("Employees on Leave Today"));
		assertTrue(homePage.dashboardWidgetHeaders.get(5).getText().trim().contains("Employee Distribution by Sub Unit"));
		assertTrue(homePage.dashboardWidgetHeaders.get(6).getText().trim().contains("Employee Distribution by Location"));
		
		
	}
	
	@Test()
	public void depenedentMethod() {
		ExtentReportUtils.extentLog.log(Status.INFO, "In the depenedentMethod method..");
		
	}
		
		
	
}
