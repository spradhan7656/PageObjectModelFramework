package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Hooks 
{
	public WebDriver driver;// web driver object
	public static Properties configData;// this is access the config file data
	@BeforeSuite
	public void beforeSuite()
	{
		readConfig();
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		lunchBrowser();
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.quit();
	}
	
	@AfterSuite
	public void afterSuite()
	{
		
	}
	/*
	 * <p> This method read the config and parses the same into key value pairs </p>
	 */
	public void readConfig()
	{
		
		try {

			FileInputStream fis = new FileInputStream(new File ("./src/test/resources/config.properties"));
			// This config file is the property class it contains lot of feature 
			// first of all read the config file data 
			configData =new Properties();
			
			configData.load(fis);
			
			System.out.println(configData.getProperty("browser.name"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
			System.out.println("Unable to Read Config"+e.getMessage());
		}
	}
	
	public void lunchBrowser()
	{
		if(configData.getProperty("browser.name").equalsIgnoreCase("chrome"))
		{
			System.setProperty("webDriver.chrome.driver",configData.getProperty("browser.executable"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		else
		{
			//implement of other block
		}
	}
}
