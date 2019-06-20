package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ApachePOIExcelReadRegStdDetailToDB;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "db-inputsreg")
	public Object [][] getDBDatareg() {

		List<LoginBean> list = new ELearningDAO().setRegistration(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[6]; 
			obj[0] = temp.getFirstName(); 
			obj[1] = temp.getLastName(); 
			obj[2] = temp.getEmail(); 
			obj[3] = temp.getRegUserName(); 
			obj[4] = temp.getRegPassword(); 
			obj[5] = temp.getPhone(); 

			result[count ++] = obj; 
		}
		
		
		return result;
	}

	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData(){
		String fileName ="C:\\inputdata\\TestData1.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName);
	
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData1(){
		String fileName ="C:\\inputdata\\TestData1.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName);
	
	}
	
	@DataProvider(name = "excel-inputs5")
	public Object[][] getExcelData5(){
		String fileName ="C:\\inputdata\\TestData2.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName);
	
	}
	
	@DataProvider(name = "excel-inputs63")
	public Object[][] getExcelData63(){
		String fileName ="C:\\inputdata\\TestData63.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName);
	}
	@DataProvider(name = "excel-inputs65")
	public Object[][] getExcelData65(){
		String fileName ="C:\\inputdata\\TestData65.xlsx"; 
		return new ApachePOIExcelRead().getExcelContent(fileName);
	}
	
	
/*	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		//return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
		return new ReadExcel().getExcelData("C:\\inputdata\\TestData1.xls", "Sheet1");
	} */
}
