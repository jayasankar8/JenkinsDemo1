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

public class TeacherCreateTest_ELTC_032 {
  
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
	@Test
	public void validLoginTest() throws InterruptedException {
		TeacherCoserDescrpPOM1.sendUserName("teacher");
		TeacherCoserDescrpPOM1.sendPassword("teacher123");
		TeacherCoserDescrpPOM1.clickLoginBtn(); 
		TeacherCoserDescrpPOM1.myCoursesBtn();
		TeacherCoserDescrpPOM1.seleniumCourseBtn1();
		//TeacherCoserDescrpPOM1.coursesBtn();				//selecting course name
		TeacherCoserDescrpPOM1.testsBtn();
		//TeacherCoserDescrpPOM1.selecttestsBtn();		    // to selecting check box and date
		TeacherCoserDescrpPOM1.createNewTestBtn();
		TeacherCoserDescrpPOM1.testName("online quiz"); 	//enter name of the test
		TeacherCoserDescrpPOM1.advancedsettingsBtn();
		TeacherCoserDescrpPOM1.insertdescriptionText("quiz");
		TeacherCoserDescrpPOM1.feedBack();
		TeacherCoserDescrpPOM1.enableStartTime("9");				
		TeacherCoserDescrpPOM1.passpercentage("50");
		TeacherCoserDescrpPOM1.preeceedToQuestionBtn();
		TeacherCoserDescrpPOM1.multipleChoiceBtn();
		TeacherCoserDescrpPOM1.textBoxName("Which course you are learning");
		TeacherCoserDescrpPOM1.insertTextInObjectiveTextBox2("selenium");
		TeacherCoserDescrpPOM1.insertTextInObjectiveTextBox4("java");
		TeacherCoserDescrpPOM1.insertTextInObjectiveTextBox6("c");	
		TeacherCoserDescrpPOM1.insertTextInObjectiveTextBox8("c#");
		TeacherCoserDescrpPOM1.answersRDBtn(0);
		TeacherCoserDescrpPOM1.questionTestBtn();
		TeacherCoserDescrpPOM1.multipleChoiceBtn();
		TeacherCoserDescrpPOM1.textBoxName("which language are you using in selenium");
		TeacherCoserDescrpPOM1.insertTextInObjectiveTextBox2("python");
		TeacherCoserDescrpPOM1.insertTextInObjectiveTextBox4("java");
		TeacherCoserDescrpPOM1.insertTextInObjectiveTextBox6("c");	
		TeacherCoserDescrpPOM1.insertTextInObjectiveTextBox8("c#");
		TeacherCoserDescrpPOM1.answersRDBtn(1);
		TeacherCoserDescrpPOM1.questionTestBtn();
		TeacherCoserDescrpPOM1.previewBtn();
		TeacherCoserDescrpPOM1.clickStartTestBtn();
		TeacherCoserDescrpPOM1.answersoptionRDBtn(0);  //First question answer radio button click
		TeacherCoserDescrpPOM1.clickNextQuesBtn();
		TeacherCoserDescrpPOM1.answersoptionRDBtn(1);  //second question answer radio button click
		TeacherCoserDescrpPOM1.clickEndTestBtn();
		screenShot.captureScreenShot("ELTC_32"); 
	} 
}
