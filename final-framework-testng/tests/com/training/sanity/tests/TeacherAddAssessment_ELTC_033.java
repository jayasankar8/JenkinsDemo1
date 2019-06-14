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
import com.training.pom.TeacherCourse_POM_ELTC_031;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TeacherAddAssessment_ELTC_033 {
  
	private WebDriver driver;
	private String baseUrl;
	private TeacherCourse_POM_ELTC_031 TeacherCoserDescrpPOM1;
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
	TeacherCoserDescrpPOM1 = new TeacherCourse_POM_ELTC_031(driver); 
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
	
	// application allows the teacher to add assessment as online activity & Attach certificate.
	@Test
	public void validLoginTest() throws InterruptedException {
		TeacherCoserDescrpPOM1.sendUserName("teacher");
		TeacherCoserDescrpPOM1.sendPassword("teacher123");
		TeacherCoserDescrpPOM1.clickLoginBtn(); 
		TeacherCoserDescrpPOM1.seleniumCourseBtn();
		TeacherCoserDescrpPOM1.selectAssesmentBtn();
		TeacherCoserDescrpPOM1.selectAddonlineActivityBtn();
		TeacherCoserDescrpPOM1.ActivityTests();
		TeacherCoserDescrpPOM1.ActivityOnlinequiz();
		TeacherCoserDescrpPOM1.textWeight("1");
		TeacherCoserDescrpPOM1.AddActivityAssessmentBtn();
		TeacherCoserDescrpPOM1.EditActivity();
		TeacherCoserDescrpPOM1.checkGenerateCert();
		TeacherCoserDescrpPOM1.EditCategoryBtn();
		TeacherCoserDescrpPOM1.attchCertbtn();
		screenShot.captureScreenShot("ELTC_33");
	} 
}


