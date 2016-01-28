package com.proware.common;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.sun.jna.platform.FileUtils;

public class BasePageObject 
{
	WebDriver uiDriver=null;
	
	public BasePageObject(WebDriver uiDriver)
	{
		this.uiDriver=uiDriver;
	}
	
	
	/****************variables**************************/
	String titleValue=null;
	
	public void typeValue(By ele,String input) throws Exception
	{
		try
		{
		uiDriver.findElement(ele).sendKeys(input);
		Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			Assert.assertTrue(false);
			throw new Exception("Error in entering the text to the specified field..\n"+e.getLocalizedMessage());
		}
	}
	
	
	public void clickOnElement(By clickEle) throws Exception
	{
		
		try
		{
			uiDriver.findElement(clickEle).click();
		}
		catch(Exception e)
		{
			throw new Exception("Unable to click on given element..\n"+e.getLocalizedMessage());
		}
	}
	
	
	
	public void verifyTitle(String expTit) throws Exception
	{
		try
		{
			String actTit=getTitle();
			
				Assert.assertEquals(actTit.trim(), expTit.trim(),"Titles do not match...");
			
		}
		catch(Exception e)
		{
			throw new Exception("Unable to verify the Title..\n"+e.getLocalizedMessage());
		}
	}
	
	public String getTitle() throws Exception
	{
		
		try
		{
			titleValue=uiDriver.getTitle();
		}
		catch(Exception e)
		{
			throw new Exception("unable to get the Title..\n"+e.getLocalizedMessage());
		}
		
		return titleValue;
	}

	
	public void getScreenShot(String filename) throws Exception
	{
		filename=filename+System.nanoTime();
		try
		{
			File screenshot=((TakesScreenshot)uiDriver).getScreenshotAs(OutputType.FILE);
			org.apache.commons.io.FileUtils.copyFile(screenshot, new File("D:\\screenshots\\"+filename+".jpeg"));
			
		}
		catch(Exception e)
		{
			throw new Exception("Error in taking screenshot..\n"+e.getLocalizedMessage());
		}
	}
}
