package com.individualcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.Trigger.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.programwrappers.KeywordWrappers;
import com.programwrappers.WebBase;

public class ReportBase {
	
	
	public static ExtentTest test;//log.info
	public static ExtentReports report;
	
	
	
	@BeforeTest
	public static void startTest()
	{
		//htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		report =ExtentManager.createInstance(System.getProperty("user.dir")+"\\ExtentReportResults.html");
		
		
		
		}
	
	@AfterTest 
	public void tearDown() {
		 
		 report.flush();
		 }
	
	
	
	static KeywordWrappers kw=new KeywordWrappers();
	@AfterMethod
	public static void endTest(ITestResult result) throws IOException
	{
	//report.endTest(test);
		 if(result.getStatus() == ITestResult.FAILURE)
	        {
			
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));
	            test.fail(result.getThrowable());
	            String path="C:\\Users\\535114\\eclipse-workspacenew\\KeywordInternal\\screenshots\\";
	            //test.log(Status.FAIL,(Markup) MediaEntityBuilder.createScreenCaptureFromPath(path,KeywordWrappers.screenshotName+".png").build());
	            
	            ReportBase.test.addScreenCaptureFromPath(KeywordWrappers.screenshot()); 
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS)
	        {
	            test.log(Status.PASS,  MarkupHelper.createLabel(result.getName()+" Test case Passed", ExtentColor.GREEN));
	               }
	        else
	        {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }

	}
	
	
	  
	  

}
