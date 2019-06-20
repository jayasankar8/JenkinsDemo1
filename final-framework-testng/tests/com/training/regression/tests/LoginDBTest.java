package com.training.regression.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LoginPOM_ELTC_001;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginDBTest {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private LoginPOM_ELTC_001 LoginPOM_ELTC_001;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		//driver = DriverFactory.getDriver(DriverNames.CHROME);
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String userName, String password) {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
				
		loginPOM.sendUserName("admin");
		
		String USERNAME=loginPOM.getUserName();                    // to fetch username values from Application
		
		loginPOM.sendPassword("admin@123");
		
		String PASSWORD=loginPOM.getPassword();                    // to fetch password values from Application
		
		loginPOM.clickLoginBtn();
		
		//screenShot.captureScreenShot(userName);

	}
	
	@Test(dataProvider = "db-inputsreg", dataProviderClass = LoginDataProviders.class)
	public void regsterDetails(String firstName, String lastName,String email, String stuserName,String stpassword,String phone) {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
				
	/*	loginPOM.sendUserName("admin");
		
		String USERNAME=loginPOM.getUserName();                    // to fetch username values from Application
		
		loginPOM.sendPassword("admin@123");
		
		String PASSWORD=loginPOM.getPassword();                    // to fetch password values from Application
		
		loginPOM.clickLoginBtn();
		
		
	*/	
		LoginPOM_ELTC_001.sendFirstName("xxx");
		String FIRSTNAME=LoginPOM_ELTC_001.getFirstName();
		
		LoginPOM_ELTC_001.sendLastName("xxx");
		String LASTNAME=LoginPOM_ELTC_001.getLastName();
		
		LoginPOM_ELTC_001.sendemail("xxx@gmail.com");
		String EMAIL=LoginPOM_ELTC_001.getEmail();
		
		LoginPOM_ELTC_001.sendusername("xxxx");
		String STDUSERNAME=LoginPOM_ELTC_001.getRegUserName();
		
		LoginPOM_ELTC_001.sendPassword("xxxxxx");
		String STDPASSWORD=LoginPOM_ELTC_001.getPassword();
		
		LoginPOM_ELTC_001.sendphone("1234455676");
		String PHONENUM=LoginPOM_ELTC_001.getphone();
		
		//screenShot.captureScreenShot(userName);

	}


}