package com.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


public class Demo {

	@Test
	public void setup() throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("deviceName", "emulator-5554");
		dc.setCapability("platformVersion", "");
		
		URL url = new URL("https://127.0.0.0:4723/wd/hub");
		AppiumDriver driver = new AndroidDriver(url, dc);
		
		driver.findElement(By.id("digit7")).click();
		driver.findElement(By.id("op_add")).click();
		driver.findElement(By.id("digit3")).click();
		
				
	}
}
