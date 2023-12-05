package com.mytest.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.mytest.pages.LoginPage;
import com.utils.CommonUtils;
import com.utils.Hooks;

public class LoginTest extends Hooks
{
	@Test(dataProvider="login_data_provider")
	public void loginTestWithValidCredentials(String url,String username,String password) throws InterruptedException
	{
		LoginPage page=new LoginPage(driver);
		
		page.loginIntoApp(username,password,url);
		Thread.sleep(2000);
		
	}
	@DataProvider(name="login_data_provider")
	
	public Object [][] getTestData()
	{
		return CommonUtils.readExcel();
	}

}
