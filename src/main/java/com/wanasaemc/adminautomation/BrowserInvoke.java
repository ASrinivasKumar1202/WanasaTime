package com.wanasaemc.adminautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BrowserInvoke extends BaseClass
{

	
	
	 @BeforeSuite
	  
	 public void browserType()
		{
		 	System.out.println("BS---");
		 	//browserLaunch(properties.getProperty("browsertype"));
		 	browserLaunch("Chrome");
		}
	
	 
	 //@AfterSuite
	 public void browserClose()
	 {
		 driver.quit();
	 }
	
}
