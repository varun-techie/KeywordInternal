package com.individualcases;

import java.io.IOException;
import org.testng.annotations.Test;
import com.Trigger.MainTrigger;
import com.aventstack.extentreports.Status;
import com.programfuntions.Programrelated;





public class LoginPage extends ReportBase{
	

	@Test(priority=1)
	public void Loginpage() throws IOException{
	String testName ="Login Page";
	String name = new Object(){}.getClass().getEnclosingMethod().getName();
	System.out.println(name);
	test=report.createTest(name);
	test.log(Status.INFO, "started the test");
	MainTrigger mt=new MainTrigger();
		mt.runthis(testName);
	Programrelated pg=new Programrelated();
	//pg.

	}
	
	
	@Test(priority=2,enabled=false)
	public void Logoutpage() throws IOException{
	String testName ="Logout Page";
	String name = new Object(){}.getClass().getEnclosingMethod().getName();
	System.out.println(name);
	test=report.createTest(name);
	test.log(Status.INFO, "started the second test");
	MainTrigger mt=new MainTrigger();
		mt.runthis(testName);
			
	}
	
	
	
}
