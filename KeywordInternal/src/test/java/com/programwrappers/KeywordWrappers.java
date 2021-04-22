package com.programwrappers;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.individualcases.ReportBase;





public class KeywordWrappers extends WebBase {
	
	 String path="C:\\Users\\535114\\eclipse-workspacenew\\KeywordInternal\\screenshots\\";
	public static String screenshotName;



	public void launch(String value) {
		launchbrowser(value);
		ReportBase.test.log(Status.INFO, "launched browser");	
	}

	  public void getURL(String url) throws InterruptedException, IOException {
	    driver.navigate().to(url);
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
		  System.out.println("testurl");
		  ReportBase.test.addScreenCaptureFromPath(screenshot());  
		  ReportBase.test.log(Status.INFO, "Url redirected properly");
	    }
	  

	  public void click(String locatorType,String locatorname, String value) {
			
			  try {
				By locator = locatorValue(locatorType, locatorname); 
				  screenshot();
				  WebElement element = driver.findElement(locator);
				  element.click();
				  ReportBase.test.log(Status.INFO, "started the test");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("click not worked for locator");
			}
  }
	  
	  public void enterText(String locatorType,String locatorname, String value) {
			
			  By locator = locatorValue(locatorType, locatorname); 
			  WebElement element = driver.findElement(locator);
			  element.sendKeys(value);
			 
          }
	  
	  public void close() {
		  driver.close();
	  }
	  
	  
	  public static String screenshot() throws IOException {

	        TakesScreenshot scrShot =(TakesScreenshot) driver;
	        
	        //Call getScreenshotAs method to create image file
	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	                LocalDateTime d = LocalDateTime.now();
	                screenshotName=d.toString().replace(":", "_").replace(" ", "_");
	             String Dest="D:\\KeywordInternal\\screenshots\\"+screenshotName+".png";
	  	       File DestFile=new File("D:\\KeywordInternal\\screenshots\\"+screenshotName+".png");
	               FileUtils.copyFile(SrcFile, DestFile);
	               
	               return Dest;
	               //ReportBase.test.log(Status.FAIL, (Markup) ReportBase.test.addScreenCaptureFromPath(Dest));  
	  }
	
	  
	  
	  private By locatorValue(String locatorType, String value) {
	        By by;
	        switch (locatorType) {
	            case "id":
	                by = By.id(value);
	                break;
	            case "name":
	                by = By.name(value);
	                break;
	            case "xpath":
	                by = By.xpath(value);
	                break;
	            case "css":
	                by = By.cssSelector(value);
	                break;
	            case "linkText":
	                by = By.linkText(value);
	                break;
	            case "partialLinkText":
	                by = By.partialLinkText(value);
	                break;
	            default:
	                by = null;
	                break;
	        }
	        return by;
	    }
}
