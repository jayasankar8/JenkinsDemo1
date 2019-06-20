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
import com.training.pom.TeacherCourse_POM_ELTC_031;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class TeacherAuthTestMultiquestions_ELTC_065 {
 
	private WebDriver driver;
	private String baseUrl;
	private TeacherCourse_POM_ELTC_031 TeacherCourserDescrpPOM1;
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
	TeacherCourserDescrpPOM1 = new TeacherCourse_POM_ELTC_031(driver); 
	baseUrl = properties.getProperty("baseURL");
	//screenShot = new ScreenShot(driver); 
	// open the browser 
	driver.get(baseUrl);
	
	
}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		//driver.quit();
	}
	@Test(dataProvider = "excel-inputs65", dataProviderClass = LoginDataProviders.class)
	//public void validLoginTest() throws InterruptedException {
	public void loginDBTest1(String question, String firstoption, String secondoption, String thirdoption, String fourthoption) {
	TeacherCourserDescrpPOM1.sendUserName("teacher");
		TeacherCourserDescrpPOM1.sendPassword("teacher123");
		TeacherCourserDescrpPOM1.clickLoginBtn(); 
		TeacherCourserDescrpPOM1.myCoursesBtn();
		TeacherCourserDescrpPOM1.seleniumCourseBtn1();
		//TeacherCourserDescrpPOM1.coursesBtn();				//selecting course name
		TeacherCourserDescrpPOM1.testsBtn();
		//TeacherCourserDescrpPOM1.selecttestsBtn();		    // to selecting check box and date
		TeacherCourserDescrpPOM1.createNewTestBtn();
		TeacherCourserDescrpPOM1.testName("online quiz"); 		//enter name of the test
		TeacherCourserDescrpPOM1.advancedsettingsBtn();
		TeacherCourserDescrpPOM1.insertdescriptionText("quiz");
		TeacherCourserDescrpPOM1.feedBack();
		TeacherCourserDescrpPOM1.enableStartTime("9");				
		TeacherCourserDescrpPOM1.passpercentage("50");
		TeacherCourserDescrpPOM1.preeceedToQuestionBtn();
		TeacherCourserDescrpPOM1.multipleChoiceBtn();
		
		//fetching test data from xlsx sheet
		
		TeacherCourserDescrpPOM1.textBoxName(question);
		TeacherCourserDescrpPOM1.insertTextInObjectiveTextBox2(firstoption);
		TeacherCourserDescrpPOM1.insertTextInObjectivebesideTextBox3(firstoption);
		TeacherCourserDescrpPOM1.insertTextInObjectiveTextBox4(secondoption);
		TeacherCourserDescrpPOM1.insertTextInObjectivebesideTextBox5(secondoption);
		TeacherCourserDescrpPOM1.insertTextInObjectiveTextBox6(thirdoption);	
		TeacherCourserDescrpPOM1.insertTextInObjectivebesideTextBox7(thirdoption);
		TeacherCourserDescrpPOM1.insertTextInObjectiveTextBox8(fourthoption);
		TeacherCourserDescrpPOM1.insertTextInObjectivebesideTextBox9(fourthoption);
		TeacherCourserDescrpPOM1.answersRDBtn(0);
		TeacherCourserDescrpPOM1.questionTestBtn();
		TeacherCourserDescrpPOM1.multipleChoiceBtn();
		TeacherCourserDescrpPOM1.previewBtn();
	} 
}
