package com.Trigger;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Collection;

import org.testng.annotations.DataProvider;

import com.individualcases.ExcelUtils;
import com.programwrappers.KeywordWrappers;



public class RunTestcase {
	KeywordWrappers kw=new KeywordWrappers();
	public void runcasesNOW(String keyword,String locatorname,String locator,String data) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException, InterruptedException, IOException {
		// TODO Auto-generated method stub

		
		
		
		if(keyword.equals("launch")) {
			kw.launch(data);
		}
		else if(keyword.equals("getURL")) {
			 kw.getURL(data);
		  }else if(keyword.equals("click")) {
		  kw.click(locatorname,locator, data);
		  }else if(keyword.equals("enterText")) {
			  kw.enterText(locatorname,locator, data);
			  }
		  else if(keyword.equals("close")) {
			  kw.close();
			  }
		  
	
			 
			 
		 
		
	}
	
	
	
	

}
