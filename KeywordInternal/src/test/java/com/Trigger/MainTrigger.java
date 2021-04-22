package com.Trigger;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;




public class MainTrigger {

	
	static XSSFSheet sheet;	
	static RunTestcase rn=new RunTestcase();
	
	
	//public static void main(String[] args)
	//@Test
	public void runthis(String testcase) throws IOException  {
		// TODO Auto-generated method stub

		 
		String path=System.getProperty("user.dir")+"\\TestDataSheet.xlsx";
	
		FileInputStream file=new FileInputStream(new File(path));
		XSSFWorkbook wrkbook = new XSSFWorkbook(file);
		 sheet = wrkbook.getSheetAt(0);
			int iterationvalue = 0;
		String casename=null;
		
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		HashMap<String, Integer>  runscenario= new HashMap<String, Integer>();
ArrayList<String> runscenarios= new ArrayList<String>();
		for(int i=1;i<rows;i++) {
			XSSFRow row=sheet.getRow(i);
			//System.out.println(sheet.getRow(i).getLastCellNum());
			System.out.println(row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
			System.out.println(row.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
			System.out.println(row.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
			String mode=row.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			if(mode.equalsIgnoreCase("Y")) {
				String key=row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
				int value=(int) row.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
				//runscenarios.add(row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
				// iterationvalue=(int) row.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK).getNumericCellValue();
				runscenario.put(key, value);

			}
		}
			
		
		/*
		 * if(runscenarios.size()>0) { for(String s:runscenarios) {
		 * sheet=wrkbook.getSheet("Test Cases"); CallExecutor(sheet.toString(),s); } }
		 */

		if(runscenario.size()>0) {
			for (Map.Entry<String,Integer> s : runscenario.entrySet()) {
			sheet=wrkbook.getSheet("Test Cases");
			iterationvalue=s.getValue();
			casename=s.getKey();
			if(casename.equals(testcase))
				try {
					CallExecutor(sheet.toString(),casename,iterationvalue);
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		} }
		
		
	}

	private static void CallExecutor(String sheetname,String scenario,int iterationvalue) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException, InterruptedException, IOException {
		// TODO Auto-generated method stub
		int rows=sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		
		for(int it=0;it<iterationvalue;it++) {
		for(int i=1;i<rows;i++) {
			XSSFRow row=sheet.getRow(i);
			String scenariofromexcel=row.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			if(scenariofromexcel.equalsIgnoreCase(scenario)) {
			String keyword=row.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			String locatorname=row.getCell(4, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			String locator=row.getCell(5, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			String data=row.getCell(6, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			String datasheet=	row.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue();
			//System.out.println(row.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue());
			//rn.runcasesNOW(keyword,locatorname,locator,data);
			
			rn.runcasesNOW(keyword,locatorname,locator,getData(datasheet,data,(it+1)));

			}
		
	}
	}
	
	}


	
	public static String getData(String strSheetName, String strColumnIdentifier,int iteration) {
	
		//String strAbsFilePath = getAbsolutePath("testdata" + File.separator + "DataSheet.xls");
		String path=System.getProperty("user.dir")+"\\TestDataSheet.xlsx";
		String strContent = null;
		try {
			FileInputStream fis = new FileInputStream(new File(path));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(strSheetName);

			
			int rows = sheet.getPhysicalNumberOfRows();
			System.out.println(rows);
			int noOfColumns = sheet.getRow(0).getLastCellNum();
			System.out.println(noOfColumns);
			String[] Headers = new String[noOfColumns];
			
			for (int j = 0; j < noOfColumns; j++) {
				Headers[j] = sheet.getRow(0).getCell(j).getStringCellValue();
			}
			outerloop:
			for (int a = 0; a < noOfColumns; a++) {

				String as = Headers[a];
			
				  	
				  if(as.equals(strColumnIdentifier)) {
					  XSSFCell cell = sheet.getRow(iteration).getCell(a);
				  if(cell==null ||cell.getCellType() == CellType.BLANK) { 
					  //System.out.println("null"); 
					  }else  if(cell.getCellType()==CellType.NUMERIC) {
				 
				  int c=(int) cell.getNumericCellValue(); 
				  System.out.println(c); 
				  strContent=String.valueOf(c);
					  } 
					  else if(cell.getCellType()==CellType.STRING) {
				  System.out.println(cell.getStringCellValue()); 
				  strContent=cell.getStringCellValue();
					  }
			break outerloop;
				  }
				  }
				  
			return strContent;
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		
		
	}
	
	
	
	
	
	
}