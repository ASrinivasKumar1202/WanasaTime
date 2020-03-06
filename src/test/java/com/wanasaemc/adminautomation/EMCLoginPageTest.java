package com.wanasaemc.adminautomation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@Listeners
public class EMCLoginPageTest extends BaseClass
{
	
	EMCLoginPage emcloginpage; 
	
	@BeforeMethod
	public void propertiesfile()
	{
		dataFromProperiesFile();
	}
	
	@Test
	public void titlePageChecking()
	{
		System.out.println("Test1");
		//driver.get("http://staging.emc.wanasatime.com/");
		
		emcloginpage = new EMCLoginPage();
		emcloginpage.titleCheck();
		
		//System.out.println("----"+ emcloginpage.title);
		
		//System.out.println("=====" +properties.getProperty("emclogintitle"));
		
		if(!emcloginpage.title.equalsIgnoreCase(properties.getProperty("emclogintitle")))
		{
			System.out.println("URL is wrong");
		}
	}
	
	
	
	@Test(dependsOnMethods="titlePageChecking")
	public void emcLogin() throws InterruptedException
	{
		
		System.out.println("Test 2");
		emcloginpage.enterLoginDetails();
		//String titlename = driver.getTitle();
		
		/*
		 * System.out.println("****" +emcloginpage.xx); System.out.println("+++"
		 * +properties.getProperty("emcloginhomepage"));
		 */
		
		
		if(!emcloginpage.xx.equalsIgnoreCase(properties.getProperty("emcloginhomepage")))
		{
			Thread.sleep(2000);
			String name = driver.findElement(By.xpath("//*[contains(text(),'toast')]")).getText();
					
					
					
					//emcloginpage.notRegistered).getText();
			System.out.println("-----" +name);
		}
		
				
	}
	
	
	@AfterMethod
	public void testcasestatus(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			reportGeneration();
		}
		else
		{
			System.out.println("----------" + result.getStatus());
		}
	}
	
	
}
