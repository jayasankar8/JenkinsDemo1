package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM_ELTC_002;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTest_ELTC_002 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_ELTC_002 loginPOM;
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
	loginPOM = new LoginPOM_ELTC_002(driver); 
	baseUrl = properties.getProperty("baseURL");
	screenShot = new ScreenShot(driver); 
	// open the browser 
	driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		//driver.quit();
	}
	
	// application allows the student to get logged in by entering valid credentials
	
	@Test
	public void validLoginTest() {
		loginPOM.sendUserName("Jayasankar");
		loginPOM.sendPassword("sankar123");
		loginPOM.clickLoginBtn(); 
		//screenShot.captureScreenShot("ELTC_00");
		// need to remove the below code after completion
		
		
		
		
		
		
	}
}
