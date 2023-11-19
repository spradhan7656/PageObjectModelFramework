package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
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
	 
	public WebDriver driver;// web driver object
	
	public CommonUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	/*
	 * <p> This method is use to lunch the browser</p>
	 */
	
	/*
	 * <p> This method is use to quit the browser</p>
	 */
	public void closeBrowser()
	{
		driver.quit();
	}
	public void navigate(String url)
	{
		driver.get(url);
	}
	/*
	 * <p>Click on the element by provider</p>
	 */
	public void clickElement(By locatorType)
	{
		driver.findElement(locatorType).click();
	}
	/*
	 * <p>Sendkeys to provide element
	 */
	public void  type(By locatorType ,String value)
	{
		driver.findElement(locatorType).sendKeys(value);
	}
	
}
