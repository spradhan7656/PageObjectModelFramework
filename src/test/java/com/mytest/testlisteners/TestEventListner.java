package com.mytest.testlisteners;

import java.io.File;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.utils.CommonUtils;
import com.utils.Hooks;

public class TestEventListner implements ITestListener
{

	
	public void onTestStart(ITestResult result) { 
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) 
	{
		CommonUtils.captureScreenshot();
		
	}

	public void onTestSkipped(ITestResult result) {
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	/*
	 *
	 */
	public static void main(String[] args) 
	{
		
		Date date = new Date();
		System.out.println(date.toString().replace(" ", "_").replace(":", "_"));
	}
	
}
