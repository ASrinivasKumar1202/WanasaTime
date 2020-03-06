package com.wanasaemc.adminautomation;

import java.io.FileReader;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class EMCLoginPage  extends BaseClass
{
	String title;
	String xx ;
	
	//Xpath for Login webPage 
	
	By emailId = By.id("userEmail");
	By password = By.id("password");
	By Loginbutton = By.id("validateLogin");
	//By notRegistered = By.xpath("//*[contains(test(),'toast-container')]");
	
	WebDriver driver =  BaseClass.driver;
	
	public void titleCheck()
	{
		System.out.println("Test started");
		
		dataFromProperiesFile();
		
		driver.get(properties.getProperty("url"));
		System.out.println("@@@@" +driver);
		
		//driver.get("http://staging.emc.wanasatime.com/");
		
		 title = driver.getTitle();
		System.out.println("Title is :" +title);
		//return title;
			
	}
	
	
	
	public void enterLoginDetails() throws InterruptedException
	{
		
		System.out.println("Test 1777");
		Thread.sleep(5000);
		dataFromProperiesFile();
		driver.findElement(emailId).sendKeys(properties.getProperty("emailID"));
		driver.findElement(password).sendKeys(properties.getProperty("password"));
		driver.findElement(Loginbutton).click();
		 xx = driver.getTitle();
	
	}
	
	
	
	

}
