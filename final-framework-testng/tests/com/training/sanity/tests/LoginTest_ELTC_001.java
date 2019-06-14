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
import com.training.pom.LoginPOM_ELTC_001;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTest_ELTC_001 {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_ELTC_001 loginPOM1;
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
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	
	// Application allows user to get registered as Student
	@Test
	public void validLoginTest() {
		loginPOM1.sendUserName("admin");				 
		loginPOM1.sendPassword("admin@123");
		loginPOM1.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		loginPOM1.addUser2();
		loginPOM1.sendFirstName("jaya123");
		loginPOM1.sendLastName("sankar123");
		loginPOM1.sendemail("sankarktest22@gmail.com");
		loginPOM1.sendphone("9934560890");
		loginPOM1.sendusername("Jaya88");
		loginPOM1.sendPassword1("sankar8888");
		loginPOM1.sendLanguage();
		loginPOM1.submit();
		screenShot.captureScreenShot("ELTC_001");
		} 
  }

