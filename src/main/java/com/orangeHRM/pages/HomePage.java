package com.orangeHRM.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.orangeHRM.core.BaseClass;

public class HomePage{

	WebDriver driver;
	public HomePage(ChromeDriver driver) {
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='container-fluid navbar-menu']//img[@alt='OrangeHRM Logo']")
	public WebElement hrmLogo;
	
	@FindBy(xpath = "//li[@class='nav-item']/a")
	public List<WebElement> menuList;
	
	@FindBy(xpath = "//h6[text()='Dashboard']")
	public WebElement dashboardHeader;
	
	@FindBy(xpath = "//span[text()='Admin']/parent::a")
	public WebElement adminLink;
	
	@FindBy(xpath = "//div[@class='orangehrm-dashboard-widget-header']//p")
	public List<WebElement> dashboardWidgetHeaders;
		
}
