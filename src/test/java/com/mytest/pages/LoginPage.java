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
	public By postLoginTextContent = By.xpath("//a[text()='New Customer']");
	
	public void loginIntoApp(String userId,String password,String url)
	{
		super.navigate(url);
		super.waitForElementToBeClickable(userIdTextBox);
		super.type(userIdTextBox,userId);
		super.waitForElementToBeVisible(passwordTextBox);
		super.type(passwordTextBox, password);
		super.waitForElementToBeClickable(loginButton);
		super.clickElement(loginButton);
		super.validateForEquality(super.getElementTextContent(postLoginTextContent),"New Customer");
	}
}
