package com.programwrappers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebBase {
	
	
	protected static WebDriver driver=null;
	public static WebDriver launchbrowser(String browser ) {
		// TODO Auto-generated method stub

		//String browser="chrome";
		
		if(browser.equals("chrome")) {
			
			 driver=new ChromeDriver();
		
			System.out.println(driver.getTitle());
		}else if (browser.equals("firefox")) {
			
			driver=new FirefoxDriver();
		
		}else if(browser.equals("IE")) {
			
			driver=new InternetExplorerDriver();
		
		}
		return driver;
		
		
	}


	
	

}
