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

public class TeacherReviewStudAassignment_ELTC_035 {
	private WebDriver driver;
	private String baseUrl;
	//private TeacherCourse_POM_ELTC_031 TeacherReviewStudentAssignment;
	private TeacherCourse_POM_ELTC_031 TeacherReviewStudentAssignment;
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
	//TeacherReviewStudentAssignment = new TeacherCourse_POM_ELTC_031(driver); 
	
	TeacherReviewStudentAssignment = new TeacherCourse_POM_ELTC_031(driver);
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
		TeacherReviewStudentAssignment.sendUserName("teacher");
		TeacherReviewStudentAssignment.sendPassword("teacher123");
		TeacherReviewStudentAssignment.clickLoginBtn(); 
		TeacherReviewStudentAssignment.myCoursesTab();
		TeacherReviewStudentAssignment.courseBtn();
		TeacherReviewStudentAssignment.assignmentsBtn();
		TeacherReviewStudentAssignment.selectAssignment();  //for selecting assignment.
		TeacherReviewStudentAssignment.correctRateBtn();
		TeacherReviewStudentAssignment.scorevalue("40");
		TeacherReviewStudentAssignment.sendMssgBtn(); 
		TeacherReviewStudentAssignment.selectAssignmentNamelink();    //status changed with revised & rated score.
	 	screenShot.captureScreenShot("ELTC_35");				
		} 
  
}

