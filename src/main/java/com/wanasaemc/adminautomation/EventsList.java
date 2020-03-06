package com.wanasaemc.adminautomation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EventsList
{

	
	WebDriver driver =  BaseClass.driver;
	
	//EMC Events  :
	By EventsList = By.xpath("//*[@id='events']/ul/li");
		
	
	public void EventListDetails()
	{
		
		List<WebElement> eventListitems = driver.findElements(EventsList);
		for(WebElement eventname : eventListitems)
		{
			
			//eventname.f
			
		}
		
		
	}
	
	
	
}
