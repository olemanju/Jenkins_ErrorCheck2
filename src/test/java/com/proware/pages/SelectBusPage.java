package com.proware.pages;

import org.openqa.selenium.WebDriver;

import com.proware.common.BasePageObject;

public class SelectBusPage extends BasePageObject
{
	WebDriver uiDriver=null;
	
	public SelectBusPage(WebDriver uiDriver)
	{
		super(uiDriver);
		this.uiDriver=uiDriver;
		
	}
	
	
	
	
	public void VerifyTitle(String expTit) throws Exception
	{
		try
		{
			verifyTitle(expTit);
		}
		catch(Exception e)
		{
			throw new Exception("unable to verify the Title..\n"+e.getLocalizedMessage());
		}
	}
	

}
