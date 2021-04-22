package com.individualcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Trigger.MainTrigger;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class LoginPageone extends ReportBase{
	
	
	
	
	
	
	@Test(priority=1)
	public void Loginpage() throws IOException{
	String testName ="Login Page";
	
	MainTrigger mt=new MainTrigger();
		//mt.runthis(testName);
	test=report.createTest("Login functionality check");	
	}
	
	
	@Test(priority=2)
	public void Logoutpage() throws IOException{
	String testName ="Logout Page";
	
	MainTrigger mt=new MainTrigger();
		//mt.runthis(testName);
		test=report.createTest("Logout case check");	
	}
	
	/*
	 * @AfterMethod public static void endTest(ITestResult result) {
	 * //report.endTest(test); if(result.getStatus() == ITestResult.FAILURE) {
	 * 
	 * test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()
	 * +" Test case FAILED due to below issues:", ExtentColor.RED));
	 * test.fail(result.getThrowable()); } else if(result.getStatus() ==
	 * ITestResult.SUCCESS) { test.log(Status.PASS,
	 * MarkupHelper.createLabel(result.getName()+" Test case Passed",
	 * ExtentColor.GREEN)); } else { test.log(Status.SKIP,
	 * MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED",
	 * ExtentColor.ORANGE)); test.skip(result.getThrowable()); }
	 * 
	 * }
	 * 
	 * 
	 * @AfterTest public void tearDown() {
	 * 
	 * report.flush(); }
	 */
}
