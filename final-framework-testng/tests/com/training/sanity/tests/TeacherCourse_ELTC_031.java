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

public class TeacherCourse_ELTC_031 {
 
	private WebDriver driver;
	private String baseUrl;
	//private TeacherCourse_POM_ELTC_031 TeacherCoserDescrpPOM1;
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
	@Test
	public void validLoginTest() throws InterruptedException {
		TeacherCoserDescrpPOM1.sendUserName("teacher");
		TeacherCoserDescrpPOM1.sendPassword("teacher123");
		TeacherCoserDescrpPOM1.clickLoginBtn(); 
		
		TeacherCoserDescrpPOM1.clickOn();
		TeacherCoserDescrpPOM1.sendCourseName("selenium");
		TeacherCoserDescrpPOM1.advancedBtnClick();
		TeacherCoserDescrpPOM1.sendCatogery();
		TeacherCoserDescrpPOM1.courseCode("sel");
		TeacherCoserDescrpPOM1.sendLanguage("English");
		TeacherCoserDescrpPOM1.creatCourseBtn();
		TeacherCoserDescrpPOM1.addIntroductionBtn();
		TeacherCoserDescrpPOM1.enterText("this is selenium course");
		TeacherCoserDescrpPOM1.saveIntroTextClick();
		
		TeacherCoserDescrpPOM1.courseDescriptionClick();
		TeacherCoserDescrpPOM1.description();
		TeacherCoserDescrpPOM1.descriptionTitle("selenium course for beginners"); 	//Entered text in Title text box under description page.
		TeacherCoserDescrpPOM1.insertdescriptionText("selenium course for beginners");
		TeacherCoserDescrpPOM1.savetextBtn();        								//click on the save text button.
		
		TeacherCoserDescrpPOM1.objectivesBtn();
		TeacherCoserDescrpPOM1.objectivesTitle("selenium course for beginners");
		TeacherCoserDescrpPOM1.insertdescriptionText("selenium course for beginners");  //inserting text in objective text area.
		TeacherCoserDescrpPOM1.savetextBtn();
		
		TeacherCoserDescrpPOM1.topicsBtn();
		TeacherCoserDescrpPOM1.objectivesTitle("selenium course for beginners");
		TeacherCoserDescrpPOM1.insertdescriptionText("selenium course for beginners");  //inserting text in topics content area.
		TeacherCoserDescrpPOM1.savetextBtn();
		
		screenShot.captureScreenShot("ELTC_31");
		} 
}


