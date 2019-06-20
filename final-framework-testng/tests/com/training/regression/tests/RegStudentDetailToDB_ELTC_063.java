package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.connection.GetConnection;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM_ELTC_001;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.utility.LoadDBDetails;

public class RegStudentDetailToDB_ELTC_063 {
  
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM_ELTC_001 loginPOM1;
	private static Properties properties;
	private ScreenShot screenShot;
	private ELearningDAO ELearningDAO1;

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
		//driver.quit();
	}
	
	@Test
	public void loginDBTest10() {

		loginPOM1.sendUserName("admin");				 
		loginPOM1.sendPassword("admin@123");
		loginPOM1.clickLoginBtn(); 
		loginPOM1.addUser2();
		loginPOM1.sendFirstName("manjoor");
		loginPOM1.sendLastName("manjoor");
		loginPOM1.sendemail("manjoor@gmail.com");
		loginPOM1.sendphone("123455");
		loginPOM1.sendusername("manjoor123");
		loginPOM1.sendPassword1("manjoor");
		
		Boolean status=insertintoSQLDB1();
		loginPOM1.submit();

		
		} 
	public Boolean insertintoSQLDB1()
	{
		GetConnection gc  = new GetConnection(); 
		Boolean returnstatus=true;
		try {
			String query1 = "insert into student (firstname, lastname, email, username, password, phonenum)"
			        + " values (?, ?, ?, ?, ?, ?)";
			System.out.println(query1);
			gc.ps2=GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(query1);
			gc.ps2.setString(1, "manjoor");
			gc.ps2.setString(2, "manjoor");
			gc.ps2.setString(3, "manjoor@gmail.com");
			gc.ps2.setString(4, "manjoor");
			gc.ps2.setString(5, "manjoor");
			gc.ps2.setString(6, "1234567890");
			returnstatus=gc.ps2.execute();
			gc.ps2.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}

	return returnstatus;
	}

}
