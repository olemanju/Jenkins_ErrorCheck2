package com.proware.Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	String retval=null;
	public String getProperty(String propname) throws Exception
	{ 
		try
		{
			FileInputStream fis=new FileInputStream("./Config.properties");
			Properties prop=new Properties();
			prop.load(fis);
			 retval=prop.getProperty(propname);
		}
		catch(Exception e)
		 {
			retval=null;
			throw new Exception("Error in getting property value...\n"+e.getLocalizedMessage());
		 }
		return retval;	
	}
	


}
