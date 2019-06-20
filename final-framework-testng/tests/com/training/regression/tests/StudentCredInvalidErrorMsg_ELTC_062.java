package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM_ELTC_001;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class StudentCredInvalidErrorMsg_ELTC_062 {
 
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_ELTC_001 loginPOM1;
	private ApachePOIExcelRead readexcel;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
	driver = DriverFactory.getDriver(DriverNames.FIREFOX);
	loginPOM1 = new LoginPOM_ELTC_001(driver); 
	baseUrl = properties.getProperty("baseURL");
	screenShot = new ScreenShot(driver); 
	// open the browser 
	driver.get(baseUrl);
	loginPOM1.sendUserName("admin");				 
	loginPOM1.sendPassword("admin@123");
	loginPOM1.clickLoginBtn(); 
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
	// Application allows user to get registered as Student
		
	@Test(dataProvider = "excel-inputs5", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest4(String firstname, String lastname, String email, String phonenum, String username, String pasword) {
	
		loginPOM1.addUser2();
		loginPOM1.sendFirstName(firstname);
		loginPOM1.sendLastName(lastname);
		loginPOM1.sendemail(email);
		loginPOM1.sendphone(phonenum);
		loginPOM1.sendusername(username);
		loginPOM1.sendPassword1(pasword);
		loginPOM1.sendLanguage();
		loginPOM1.submit();
		screenShot.captureScreenShot("ELTD_062");
		} 
}
