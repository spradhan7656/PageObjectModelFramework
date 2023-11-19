package com.mytest.tests;

import org.testng.annotations.Test;

import com.mytest.pages.LoginPage;
import com.utils.Hooks;

public class LoginTest extends Hooks
{
	@Test
	public void loginTestWithValidCredentials() throws InterruptedException
	{
		LoginPage page=new LoginPage(driver);
		Thread.sleep(4000);
		page.loginIntoApp("mngr535530", "pEsEraq","https://demo.guru99.com/v2/");
		Thread.sleep(4000);
	}

}
