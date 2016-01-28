package com.proware.tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.proware.common.BasePageObject;
import com.proware.common.BasePageTest;

public class Launchtest 
{
	@Test
	public void test() throws Exception
	{
		WebDriver uiDriver=new FirefoxDriver();
		uiDriver.get("https://www.redbus.in/Booking/SelectBus.aspx?fromCityId=138&toCityId=122_1&doj=23-Jan-2016&busType=Any&opId=0");
		uiDriver.manage().window().maximize();
		uiDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		uiDriver.findElement(By.id("txtOnwardCalendar")).click();
		
//		uiDriver.findElement(By.xpath("//div[@style='position: absolute; top: 332px; left: 491.5px; display: block; width: 448px;']//table[@class='monthTable first']/tbody/tr/td[contains(text(),'18')]")).click();
		
//		uiDriver.findElement(By.id("searchBtn")).click();
		int max=0;
		List<WebElement> li = uiDriver.findElements(By.xpath("//span[@class='Fare']"));
		for(int i=0;i<li.size();i++)
		{
			
			int val=Integer.valueOf(li.get(i).getText());
			if(val>max)
			{
				
				max=val;
			}
			
		}
		
		System.out.println("maximum fare is-->"+max);
		
		BasePageObject obj=new BasePageObject(uiDriver);
		obj.getScreenShot("LaunchTest");

		
	}

}
