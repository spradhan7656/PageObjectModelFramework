package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/*
 * <p>This class consists of Re-usable helper/ utility method</p>
 * @ Author -Santosh Prahan
 * @ Version -2.0
 * @See External Referances
 * 
 * 
 */

public class CommonUtils 
{
	public Properties configData;
	public WebDriver driver;
	/*
	 * <p> This method read the config and parses the same into key value pairs </p>
	 */
	public void readConfig()
	{
		
		try {

			FileInputStream fis = new FileInputStream(new File ("./src/test/resources/config.properties"));
			
			configData =new Properties();
			
			configData.load(fis);
			
			System.out.println(configData.getProperty("browser.name"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
			System.out.println("Unable to Read Config"+e.getMessage());
		}
	}
	
	/*
	 * <p> This method is use to lunch the browser</p>
	 */
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
	/*
	 * <p> This method is use to quit the browser</p>
	 */
	public void closeBrowser()
	{
		driver.quit();
	}
	public static void main(String[] args) {
		CommonUtils comm =new CommonUtils();
		comm.readConfig();
		comm.lunchBrowser();
		comm.closeBrowser();
	}
}
