package com.proware.common;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.proware.Utils.ReadConfig;

public class BasePageTest
{
    public static WebDriver uiDriver=null;
    
    ReadConfig objReadConfig=null;
    
    @BeforeMethod
    public void preSetup() throws Exception
    {   
    	objReadConfig=new ReadConfig();
    	String browser=objReadConfig.getProperty("browser");
		String url=objReadConfig.getProperty("url");
		
    	try
    	{
    		
    		if(browser.equalsIgnoreCase("FF"))
    		{
    			uiDriver=new FirefoxDriver();
    		}
    		else if(browser.equalsIgnoreCase("IE"))
    		{
    			System.setProperty("webdriver.ie.driver", "D:\\Broswer Binidings\\IEDriverServer.exe");
    			uiDriver=new InternetExplorerDriver();
    		}
    		else if(browser.equalsIgnoreCase("GC"))
    		{
    			System.setProperty("webdriver.chrome.driver", "D:\\Broswer Binidings\\chromedriver.exe");
    			uiDriver=new ChromeDriver();
    		}
    		
        	
        	uiDriver.get(url);
        	uiDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        	uiDriver.manage().window().maximize();
        	
    	}
    	
    	
    	catch(Exception e)
    	{
    		throw new Exception("Error in launching the browser...\n"+e.getLocalizedMessage());
    	}

    }
    
    @AfterMethod
    public void tearup()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	uiDriver.quit();
    }
    
    

    
    
}
