package com.practice;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orangeHRM.core.BaseClass;
import com.orangeHRM.pages.HomePage;

public class SeleniumPractice extends BaseClass{
	
	HomePage homepage;
	
	@Test
	public void validateTitleofThePage() {
		
		String title = driver.getTitle();
		assertTrue(title.equalsIgnoreCase("Human Resources Management Software | HRMS | OrangeHRM"), "Title verified");
	}
	
	
	@Test
	public void validatePageLogo() {
		homepage = new HomePage(driver);
		String logoText = homepage.hrmLogo.getAttribute("alt");
		System.out.println(logoText);
		assertTrue(logoText.contains("OrangeHRM"), logoText);
		
		
		
	}
	
	@Test
	public void validateMenu() {
		homepage = new HomePage(driver);
		List<String> menuList = new ArrayList<>();
		menuList.add("Solutions");
		menuList.add("Why OrangeHRM");
		menuList.add("Resources");
		menuList.add("Company");
		menuList.add("Pricing");
		
		System.out.println(menuList);
		
		for(WebElement menu: homepage.menuList)
		{
			assertTrue(menuList.contains(menu.getText()), "Menu Option is not available");
		}
		
	}
	
}
