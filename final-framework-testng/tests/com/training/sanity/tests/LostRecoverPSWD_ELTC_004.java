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
import com.training.pom.LostRecoverPSWD_pom_ELTC_004;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LostRecoverPSWD_ELTC_004 {
  
	private WebDriver driver;
	private String baseUrl;
	private LostRecoverPSWD_pom_ELTC_004 loginPOM;
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
	loginPOM = new LostRecoverPSWD_pom_ELTC_004(driver); 
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
	//Application allows the student to recover password in I lost my password page
	
	@Test
	public void validLoginTest() {
		
		loginPOM.clickLostPswd();
		loginPOM.sendEmail("sankarktest@gmail.com");
		loginPOM.LastPasswordSubmit();
		screenShot.captureScreenShot("ELTC_004");
	}
	
}
