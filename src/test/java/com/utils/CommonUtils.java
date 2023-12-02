package com.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
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
	
	public WebDriverWait wait;
	
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
	/*
	 * <P>waits for configured amount of seconds for an element visibility</p>
	 */
	public void waitForElementToBeClickable(By locator)
	{
		try
		{
			wait=new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(Hooks.configData.getProperty("wait.duration"))));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
	}
	/*
	 * <p>return result after validation for equality<p>
	 * @param expected
	 * @param actual 
	 */
	public void validateForEquality(String expected, String actual)
	{
		Assert.assertEquals(expected,actual);
	}
	/*
	 * <p>Extracts Text content of a WebElement 
	 */
	public String getElementTextContent(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	/*
	 * <p>Wait for configured amount of second for an element visibility </p>
	 */
	public void waitForElementToBeVisible(By locator)
	{
		try
		{
			wait=new WebDriverWait(driver,Duration.ofSeconds(Long.parseLong(Hooks.configData.getProperty("wait.duration"))));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void captureScreenshot()
	{
		
	}
	
}
