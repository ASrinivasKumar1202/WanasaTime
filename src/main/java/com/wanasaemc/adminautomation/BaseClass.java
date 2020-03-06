package com.wanasaemc.adminautomation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass 
{

	public static  WebDriver driver;
	FileReader file;
	Properties properties;
	ExtentHtmlReporter reporter=null;
	ExtentReports reports=null;
	ExtentTest test=null;
	String projectlocation;

	
	 public void browserLaunch(String brwosername)
		{
		 projectlocation = System.getProperty("user.dir");
			switch(brwosername)
			{
				
				case "Chrome" :
					System.setProperty("webdriver.chrome.driver", projectlocation+"\\Drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
					break;
			
				case "Firefox" :
					System.setProperty("webdriver.gecko.driver", projectlocation+"\\Drivers\\geckodriver.exe");
					driver = new FirefoxDriver();
					driver.manage().window().maximize();
					break;
					
				default:
					System.setProperty("webdriver.chrome.driver", projectlocation+"\\Drivers\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().window().maximize();
			}
		}
	
	 
	 
	 @BeforeSuite
	  
	 public void browserType()
		{
		 	System.out.println("BS---");
		 	//browserLaunch(properties.getProperty("browsertype"));
		 	browserLaunch("Chrome");
		}
	
	 
	
	public void dataFromProperiesFile()
	{
		properties = new Properties();
		
		try 
		{
			file = new FileReader("E:\\Mytest\\adminautomation\\Inputs.properties");
			
		} 
		
		catch (FileNotFoundException e)
		{
			System.out.println("File Not Found and Exception is"+e);
		}
		
		
		try 
		{
			properties.load(file);
		} 
		
		catch (IOException e) 
		{
			System.out.println("IOException is"+e);
			
		};
		
		
	}
	
	public void reportGeneration()
	{
		System.out.println("Failed Block");
		reporter = new ExtentHtmlReporter("E:\\Mytest\\adminautomation\\Reports\\Reports1.html");
		reports = new ExtentReports();
		reports.attachReporter(reporter);
		test = reports.createTest("WanasaLoginTitlecheck");
		test.assignAuthor("Srinivas");
		test.assignCategory("Smoke Testing");
		test.log(Status.PASS, "Login Test Passed");
		reports.flush();

		/*
		 * test = reports.createTest(result.getMethod().getMethodName());
		 * 
		 * 
		 * test.log(Status.FAIL, result.getMethod().getMethodName());
		 */
	
		
		
		
		
		
	}
	
	
	
	
}
