package com.proware.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.proware.common.BasePageObject;

public class PlaceSelectionPage  extends BasePageObject
{
	
	public static WebDriver uiDriver=null;
	
	public PlaceSelectionPage(WebDriver uiDriver)
	{
		super(uiDriver);
		this.uiDriver=uiDriver;
	}
	
	/******************UI Elements*********************/
	By srcLocele=By.id("txtSource");
	By destLocEle=By.id("txtDestination");
	By selectDate=By.id("txtOnwardCalendar");
	By searchBusEle=By.id("searchBtn");
	
	
	
	/*******************************************************************
	 * @author MRamadurga
	 * @param srcloc
	 * @throws Exception
	 * This method enters the source Location
	 */
	
	
	public void selectSrcLocation(String srcloc) throws Exception
	{
		try
		{
			typeValue(srcLocele, srcloc);
			
		}
		catch(Exception e)
		{
			throw new Exception("unable to select the src location...\n"+e.getLocalizedMessage());
		}
		
	}
	
	
	/*******************************************************************
	 * @author MRamadurga
	 * @param srcloc
	 * @throws Exception
	 * This method enters the Destination Location
	 */

	public void selectDesLocation(String desloc) throws Exception
	{
		try
		{
			typeValue(destLocEle,desloc );
		}
		catch(Exception e)
		{
			throw new Exception("unable to enter the destination location..\n"+e.getLocalizedMessage());
		}
	}
	
	
	
	public void selectSrcDate(String dateval) throws Exception
	{
		try
		{
			By dateselval=By.xpath("//div[@style='position: absolute; top: 332px; left: 491.5px; display: block; width: 448px;']//table[@class='monthTable first']/tbody/tr/td[contains(text(),'"+dateval+"')]");
			clickOnElement(selectDate);
			Thread.sleep(3000);
			clickOnElement(dateselval);
		
		}
		catch(Exception e)
		{
			throw new Exception("unable to click on given date\n"+e.getLocalizedMessage());
		}
	}
	
	
	public SelectBusPage clickOnSearchBuses() throws Exception
	{
		try
		{
			clickOnElement(searchBusEle);
		}
		catch(Exception e)
		{
			throw new Exception("Click on Search button...\n"+e.getLocalizedMessage());
		}
		
		return new SelectBusPage(uiDriver);
		
	}
	
}
