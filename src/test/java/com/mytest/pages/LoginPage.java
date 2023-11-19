package com.mytest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utils.CommonUtils;

public class LoginPage extends CommonUtils
{
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
	}
	public By userIdTextBox=By.name("uid");
	public By passwordTextBox=By.name("password");
	public By loginButton=By.name("btnLogin");
	
	
	public void loginIntoApp(String userId,String password,String url)
	{
		super.navigate(url);
		super.type(userIdTextBox,userId);
		super.type(passwordTextBox, password);
		super.clickElement(loginButton);
	}
}
