package com.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import org.testng.Reporter;

public class CommonUtils 
{
	 
	public static WebDriver driver;// web driver object
	
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
	/**
	 * <p>Captures screenshot of the webpage </p?
	 */
	public static void captureScreenshot()
	{
		Date scrDate = new Date();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//this take screenshot
		File screenshotName = new File(Hooks.configData.getProperty("screenshot.directory.path")+
				"/"+scrDate.toString().replace(" ", "_").replace(":", "_")+".png");
		try {
			FileUtils.copyFile(scrFile, screenshotName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Reporter.log("<br><img src='"+screenshotName.getAbsolutePath()+"' height='480' width='640' /><br>");
	}
	/**
	 * <p>Reads Excel file and retruns a 2D Object Array</p>
	 * @return
	 * @throws IOException 
	 */
	
	public static Object[][] readExcel() 
	{
		try
		{
			Object [][] data=null;
			
			FileInputStream fis =new FileInputStream(new File(Hooks.configData.getProperty("test.data.directory")));//file object for filereader
			
			XSSFWorkbook wb=new XSSFWorkbook(fis);//pass the file object in the xssf is class that help to open excel
			
			XSSFSheet sheet=wb.getSheet("login_credentials");//initilization the sheet
			int lastrow=sheet.getLastRowNum();//This return as the last data present row number
			int lastcell=sheet.getRow(0).getLastCellNum();
			String[][] loginData=new String[lastrow][lastcell];
			for(int i=1;i<=lastrow;i++)
			{
				XSSFRow row=sheet.getRow(i);
											//This is return as the last data present 
					for(int j=0;j<lastcell;j++)
				{
					XSSFCell cell=row.getCell(j);
					loginData[i-1][j]=cell.getStringCellValue();
					
				}
			}
			
			
		return loginData;
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return null;
		
	}
	
}
