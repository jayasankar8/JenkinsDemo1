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
import com.training.pom.ChangePSWD_POM_ELTC_003;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangePSWD_ELTC_003 {
 
	private WebDriver driver;
	private String baseUrl;
	private ChangePSWD_POM_ELTC_003 loginPOM;
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
	loginPOM = new ChangePSWD_POM_ELTC_003(driver); 
	baseUrl = properties.getProperty("baseURL");
	screenShot = new ScreenShot(driver); 
	// open the browser 
	driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	
	// Application allows the user to change the password in Edit Profile page
	
	@Test
	public void validLoginTest() {
		loginPOM.sendUserName("Jayasankar");
		loginPOM.sendPassword("123sankar");
		loginPOM.clickLoginBtn(); 
		loginPOM.clickEditProfile();
		loginPOM.sendExistingPassword("123sankar");
		loginPOM.sendNewPassword("sankar123");
		loginPOM.sendConfirmPassword("sankar123");
		loginPOM.clickSaveBtn();
		screenShot.captureScreenShot("ELTC_003");
	}
	
}
