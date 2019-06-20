package com.training.pom;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class TeacherCourse_POM_ELTC_031 {
 
private WebDriver driver; 
	
	public TeacherCourse_POM_ELTC_031(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	@FindBy(id="form-login_submitAuth") 
	private WebElement loginBtn; 
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	@FindBy(xpath="//*[@id=\"coursesCollapse\"]/div/ul/li[1]/a")
	private WebElement clickOn;
	public void clickOn() {
		this.clickOn.click();
	}
	
	public void sendCourseName(String selenium) {
		driver.findElement(By.id("title")).sendKeys("selenium");
	}
	
	public void advancedBtnClick() {
		driver.findElement(By.id("advanced_params")).click();
	}
	
	
	@FindBy(xpath="//*[@data-id='add_course_category_code']")
	private WebElement catagorybtn;
	@FindBy(xpath="//*[contains(text(),'Java (2)')]")
	private WebElement catagory;
	
	public void sendCatogery() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionlang = new Actions(this.driver);
		actionlang.moveToElement(catagorybtn).click().build().perform();
		actionlang.sendKeys("Java (2)").build().perform();
		actionlang.moveToElement(catagory).click().build().perform(); 
	}
	
	@FindBy(name="wanted_code")
	private WebElement coursecode;
	public void courseCode(String sel) {
		this.coursecode.clear();
		this.coursecode.sendKeys(sel);
	}
	
	@FindBy(xpath="//*[@id=\"advanced_params_options\"]/div[3]/div[1]/div/button")
	private WebElement languageid;
	
	@FindBy(xpath="//*[@id=\"advanced_params_options\"]/div[3]/div[1]/div/div/ul/li[6]/a/span[1]")
	private WebElement language;
	public void sendLanguage(String languagename) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[contains(text(),'Language')]")).click();
		Actions actionlang = new Actions(this.driver);
		actionlang.moveToElement(languageid).click().build().perform();
		actionlang.sendKeys(languagename).build().perform();
		actionlang.moveToElement(language).click().build().perform();
	}
	
	public void creatCourseBtn() {
		driver.findElement(By.id("add_course_submit")).click();
	}
	
	@FindBy(xpath="//*[@id=\"course_tools\"]/div[1]/div/div[1]/a/em")
	private WebElement addIntrocutionbtn;
	public void addIntroductionBtn() {
		this.addIntrocutionbtn.click();
	}
	
	@FindBy(xpath="//*[@id=\"cke_1_contents\"]/iframe")
	private WebElement entertext;
	public void enterText(String str1) {
		driver.switchTo().frame(entertext);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(str1);
		driver.switchTo().defaultContent();
	}
	
	public void saveIntroTextClick() {
		driver.findElement(By.id("introduction_text_intro_cmdUpdate")).click();
	}
	
	public void courseDescriptionClick() {
		driver.findElement(By.linkText("Course description")).click();
	}

	public void description() {
			driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/32/info.png']")).click();
	}
	
	@FindBy(id="course_description_title")
	private WebElement descriptiontitle;
	public void descriptionTitle(String dtitle) {
		this.descriptiontitle.clear();
		this.descriptiontitle.sendKeys(dtitle);
	}

  @FindBy(xpath="//*[@id='cke_1_contents']/iframe")
	private WebElement inserttext;
 	public void insertdescriptionText(String inserttext) {
		driver.switchTo().frame(entertext);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(inserttext);
		driver.switchTo().defaultContent();
	}
 	
 	public void savetextBtn() {
 		driver.findElement(By.id("course_description_submit")).click();
 	}
 
 	public void objectivesBtn() {
		driver.findElement(By.xpath("//div//div/a[2]")).click();
	}
 	
 	@FindBy(id="course_description_title")
 	private WebElement objectivestitile;
 	public void objectivesTitle(String tittle) {
 		this.objectivestitile.clear();
 		this.objectivestitile.sendKeys(tittle);
 	}
 	
 	@FindBy(xpath="//*[@id='cke_1_contents']/iframe")
	private WebElement inserttext1;
 	public void insertTextInObjectiveTextBox(String inserttext1) {
		driver.switchTo().frame(inserttext1);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(inserttext1);
		driver.switchTo().defaultContent();
	}
 	
 	public void topicsBtn() {
		driver.findElement(By.xpath("//div//div/a[3]")).click();
	}
 	
 	//---------------32 testcase-----------------------------------------
 	public void coursesBtn() {
		driver.findElement(By.xpath("//*[@id=\'page']/div/div[2]/div/div/div[2]/h4/a")).click();
		
	}
 	
 	public void selecttestsBtn() {
		driver.findElement(By.xpath("//div/a[@id='istooldesc_7800']")).click();
	}
 	
 	
 	public void myCoursesBtn() {
		driver.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[2]/a")).click();
	}
 	
 	
 	public void seleniumCourseBtn1() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/48/blackboard.png']")).click();
	}
 	
 	public void testsBtn() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/64/quiz.png']")).click();
	}
 	
 	public void createNewTestBtn() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/32/new_exercice.png']")).click();  
	}
 	
 	@FindBy(id="exercise_title")
 	private WebElement testname;
 	public void testName(String testname) {
 		this.testname.clear();
 		this.testname.sendKeys(testname);
 	}
 	
 	public void advancedsettingsBtn() {
		driver.findElement(By.xpath("//*[@id='advanced_params']")).click();
	}
 	
 	@FindBy(id="exerciseType_0")
 	private WebElement feedbackrdbtn;
 	public void feedBack() {
 		//driver.findElement(By.id("feedbackrdbtn")).click();
 		this.feedbackrdbtn.click();
 	}
 	
  	public void enableStartTime(String day) {
 		
 		driver.findElement(By.xpath("//label[contains(text(),'Enable start time')]")).click();
 		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/16/attendance.png']")).click();    //to open date picker
 		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td/a[contains(text(),'"+day+"')]")).click();     //selecting target date.
 	}
 
 	@FindBy(id="pass_percentage")
 	private WebElement passtextpercentage;
 	public void passpercentage(String percentage) {
 		this.passtextpercentage.clear();
 		this.passtextpercentage.sendKeys(percentage);
 	}
 	
 	public void preeceedToQuestionBtn() {
		driver.findElement(By.id("exercise_admin_submitExercise")).click();
	}
 	//@FindBy(xpath="//*[@id='cm-content']/div/div[4]/div/ul/li[1]/div/a/img")
 	//private WebElement multiplechoice;
 	public void multipleChoiceBtn() {
 		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/64/mcua.png']")).click();
 	
 	}
 	
 	@FindBy(id="question_admin_form_questionName")
 	private WebElement questiontextbox;
 	public void textBoxName(String testname) {
 		this.questiontextbox.clear();
 		this.questiontextbox.sendKeys(testname);
 	}
 	
 	@FindBy(xpath="//*[@id='cke_2_contents']/iframe")
	private WebElement inserttext2;
 	public void insertTextInObjectiveTextBox2(String inserttext1) {
		driver.switchTo().frame(inserttext2);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(inserttext1);
		driver.switchTo().defaultContent();
	}
 	@FindBy(xpath="//*[@id='cke_3_contents']/iframe")
	private WebElement insertbesidetext3;
 	public void insertTextInObjectivebesideTextBox3(String insertbesidetext1) {
		driver.switchTo().frame(insertbesidetext3);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(insertbesidetext1);
		driver.switchTo().defaultContent();
	}
 	
 	@FindBy(xpath="//*[@id='cke_4_contents']/iframe")
	private WebElement inserttext4;
 	public void insertTextInObjectiveTextBox4(String inserttext1) {
		driver.switchTo().frame(inserttext4);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(inserttext1);
		driver.switchTo().defaultContent();
	}
 	@FindBy(xpath="//*[@id='cke_5_contents']/iframe")
	private WebElement insertbesidetext5;
 	public void insertTextInObjectivebesideTextBox5(String insertbesidetext1) {
		driver.switchTo().frame(insertbesidetext5);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(insertbesidetext1);
		driver.switchTo().defaultContent();
	}
 	@FindBy(xpath="//*[@id='cke_6_contents']/iframe")
	private WebElement inserttext6;
 	public void insertTextInObjectiveTextBox6(String inserttext1) {
		driver.switchTo().frame(inserttext6);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(inserttext1);
		driver.switchTo().defaultContent();
	}
 	@FindBy(xpath="//*[@id='cke_7_contents']/iframe")
	private WebElement insertbesidetext7;
 	public void insertTextInObjectivebesideTextBox7(String insertbesidetext1) {
		driver.switchTo().frame(insertbesidetext7);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(insertbesidetext1);
		driver.switchTo().defaultContent();
	}
 	@FindBy(xpath="//*[@id='cke_8_contents']/iframe")
	private WebElement inserttext8;
 	public void insertTextInObjectiveTextBox8(String inserttext1) {
		driver.switchTo().frame(inserttext8);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(inserttext1);
		driver.switchTo().defaultContent();
	}
 	@FindBy(xpath="//*[@id='cke_9_contents']/iframe")
	private WebElement insertbesidetext9;
 	public void insertTextInObjectivebesideTextBox9(String insertbesidetext1) {
		driver.switchTo().frame(insertbesidetext9);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(insertbesidetext1);
		driver.switchTo().defaultContent();
	}
 	public void answersRDBtn(int indexradiobtn) {
 			List<WebElement> rbtlist=driver.findElements(By.name("correct"));
 			rbtlist.get(indexradiobtn).click();
 	}
 	
 	public void questionTestBtn() {
		driver.findElement(By.xpath("//*[@id=\'submit-question']")).click();
	}
 	
 	
 	public void previewBtn() {
 		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/32/preview_view.png']")).click();
 	
 	}
 	
 	@FindBy(xpath="//*[@id='cm-content']/div/div[2]/div[2]/div/a")
	private WebElement startTestBtn; 
	public void clickStartTestBtn() {
		this.startTestBtn.click(); 
	}
 	
	
	public void answersoptionRDBtn(int index) {
		List<WebElement> rbtlist=driver.findElements(By.xpath("//input[@type='radio']"));
		rbtlist.get(index).click();
	
		}
	
	public void clickNextQuesBtn() {
		driver.findElement(By.xpath("//button[contains(text(),'Next question')]")).click();
		
	}
	public void clickEndTestBtn() {
		driver.findElement(By.xpath("//button[contains(text(),'End test')]")).click();
		
	}
	
	
//---------------------- TeacherAddAssessment_ELTC_033 code started ------------------------
	
	public void seleniumCourseBtn() {
		
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/48/blackboard.png']")).click();
		
	}
	
	public void selectAssesmentBtn() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/64/gradebook.png']")).click();
	}
	
	public void selectAddonlineActivityBtn() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/32/new_online_evaluation.png']")).click();
	}
	
	@FindBy(xpath="//*[@id='create_link']/fieldset/div/div[1]/div/button")
	private WebElement activity;
	@FindBy(xpath="//*[@id='create_link']/fieldset/div/div[1]/div/div/ul/li[2]")
	private WebElement tests;
	
	public void ActivityTests() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionlang = new Actions(this.driver);
		actionlang.moveToElement(activity).click().build().perform();
		actionlang.sendKeys("Tests").build().perform();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		actionlang.moveToElement(tests).click().build().perform(); 
		
	}
	
	
	@FindBy(xpath="//*[@id='add_link']/fieldset/div[1]/div[1]/div/button")
	private WebElement activityonline;
	
	@FindBy(xpath="//*[@id='add_link']/fieldset/div[1]/div[1]/div/button/span[1]")
	private WebElement onlineactivity;
	
	public void ActivityOnlinequiz() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actionlang = new Actions(this.driver);
		actionlang.moveToElement(activityonline).click().build().perform();
		actionlang.sendKeys("online quiz").build().perform();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		actionlang.moveToElement(onlineactivity).click().build().perform(); 
		
	}
	@FindBy(id="weight_mask")
 	private WebElement weighttextbox;
 	public void textWeight(String weight) {
 		this.weighttextbox.clear();
 		this.weighttextbox.sendKeys(weight);
 	}
 	
	public void AddActivityAssessmentBtn() {
		driver.findElement(By.xpath("//button[contains(text(),'Add this learning activity to the assessment')]")).click();
		
	}
	
	public void EditActivity() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/22/edit.png']")).click();
	}
	
	
	public void checkGenerateCert() {
		
		List<WebElement> check= driver.findElements(By.xpath("//input[@type='checkbox']"));
		check.get(0).click();
		}
		
	public void EditCategoryBtn() {
		driver.findElement(By.xpath("//button[contains(text(),' Edit this category')]")).click();
		
	}
		
	public void attchCertbtn() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/32/certificate.png']")).click();
	}
	
	/*---------------------------------- TeacherAddAssignChangeDefaultSettings_ELTC_034 ----------------------------------*/
	
	public void selectAsignmentBtn() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/64/works.png']")).click();
	}
	
	public void createAsignmentBtn() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/32/new_work.png']")).click();
	}
		
	@FindBy(id="form1_new_dir")
 	private WebElement asigntextbox;
 	public void textAsignment(String textasign) {
 		this.asigntextbox.clear();
 		this.asigntextbox.sendKeys(textasign);
 	}	
		
	@FindBy(xpath="//*[@id='cke_1_contents']/iframe")
	private WebElement description;
 	public void assignmentDescription(String des) {
		driver.switchTo().frame(description);
		WebElement body1 = driver.switchTo().activeElement();
		body1.sendKeys(des);
        driver.switchTo().defaultContent();
	}
 	
 	public void advancedSettingsBtn() {
		driver.findElement(By.xpath("//button[@id='advanced_params']")).click();
		
	}
 	
 	@FindBy(id="form1_qualification")
 	private WebElement maxscore;
 	public void textMaxScore(String textmaxscore) {
 		this.maxscore.clear();
 		this.maxscore.sendKeys(textmaxscore);
 	}
	
 	public void validateBtn() {
		driver.findElement(By.xpath("//button[@id='form1_submit']")).click();
		
	}
 	
 	
 	public void assignmentsCheck() {
 		List<WebElement> check= driver.findElements(By.xpath("//input[@type='checkbox']"));
		check.get(1).click();
	
		//driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		}

 	public void myCoursesTab() {
		driver.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[2]/a")).click();
	}
	
	public void courseBtn() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/48/blackboard.png']")).click();
	}
	
	//selecting assignments by the Teacher
	public void assignmentsBtn() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/64/works.png']")).click();
	}                                            
	
	public void selectAssignment() {
		driver.findElement(By.xpath("//*[@id='56']/td[3]/a")).click();
		
	}
	
	public void correctRateBtn() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/22/rate_work.png']")).click();
	}											 
	
	@FindBy(xpath="//*[@id='qualification']")
 	private WebElement score;
 	public void scorevalue(String scorevalue) {
 		this.score.clear();
 		this.score.sendKeys(scorevalue);
 	}
 	
 	
	
 	@FindBy(xpath="//*[@id='work_comment_button']")
	private WebElement sendmsg; 
	public void sendMssgBtn() {
		this.sendmsg.click(); 
	}
	
	@FindBy(xpath="//*[@id='cm-content']/div/ul/li[3]/a")
	private WebElement assignment; 
	public void selectAssignmentName() {
		this.sendmsg.click(); 
	}
	
	public void selectAssignmentNamelink() {
		driver.get("http://elearningm1.upskills.in/main/work/work_list_all.php?cidReq=SEL&id_session=0&gidReq=0&gradebook=0&origin=&id=56&");
		driver.findElement(By.linkText("selenium100")).click();
		//this.sendmsg.click(); 
	}
	public void clickImageOut() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/32/unknown.png']")).click();
	}											 
	

	@FindBy(xpath="//*[@id='logout_button']")
	private WebElement logOutBtn;
	public void logOutBtn() {
		//driver.get("http://elearningm1.upskills.in/main/work/work_list_all.php?cidReq=SEL&id_session=0&gidReq=0&gradebook=0&origin=&id=56&");
		//driver.findElement(By.linkText("selenium100")).click();
		this.logOutBtn.click();
	} 
	
	@FindBy(id="login")
	private WebElement userName1; 
	public void sendUserName1(String userName) {
		this.userName.clear();
		this.userName1.sendKeys(userName);
	}
	
	@FindBy(id="password")
	private WebElement password1;
	public void sendPassword1(String password) {
		this.password1.clear(); 
		this.password1.sendKeys(password); 
	}
	
	@FindBy(id="form-login_submitAuth")
	private WebElement loginBtn1; 
	public void clickLoginBtn1() {
		this.loginBtn1.click(); 
	}
	
	//selecting course catlog 
	@FindBy(xpath="//*[@id='coursesCollapse']/div/ul/li[3]/a")
	private WebElement courseCatlogBtn;
	public void courseCatlogBtn() {
		this.courseCatlogBtn.click();
	}
/*	
	@FindBy(xpath="//*[@id='coursesCollapse']/div/ul/li[3]/a")
	private WebElement courseCatlogBtn;
	public void courseCatlogBtn() {
		this.courseCatlogBtn.click();
	}*/
	
	@FindBy(xpath="//*[@id='cm-content']/div/div[1]/div/div/div/div[1]/form/div/input")
 	private WebElement coursename;
 	public void courseName(String text) {
 		this.coursename.clear();
 		this.coursename.sendKeys(text);
 	}
	
 	@FindBy(xpath="//*[@id='cm-content']/div/div[1]/div/div/div/div[1]/form/div/div/button")
	private WebElement courSearchBtn;
	public void courseSearchBtn() {
		this.courSearchBtn.click();
	}
	
	@FindBy(xpath="//*[@id='cm-content']/div/div[2]/div[2]/div/div[2]/div[4]/div/a")
	private WebElement subscribeBtn;
	public void courseSubBtn() {
		this.subscribeBtn.click();
	}
 	
	@FindBy(xpath="//*[@id='navbar']/ul[1]/li[2]/a")
	private WebElement mycoursebtn;
	public void mycourseBtn() {
		this.mycoursebtn.click();
	}
	public void reportingTab() {
		driver.findElement(By.xpath("//*[@id='navbar']/ul[1]/li[4]/a")).click();
	}
	public void selectFollowedbyStudentslink() {
		driver.get("http://elearningm1.upskills.in/main/mySpace/student.php");
		}
	
	@FindBy(xpath="//*[@id='search_user_keyword']")
 	private WebElement keyword;
 	public void keyword(String text) {
 		this.keyword.clear();
 		this.keyword.sendKeys(text);
 	}
 	@FindBy(xpath="//*[@id='search_user_submit']")
	private WebElement studentSearchbtn;
	public void studentSearchbtn() {
		this.studentSearchbtn.click();
	}
 	
 	public void clickStudentDetails() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/22/2rightarrow.png']")).click();
	}
 	
 		public void clickCourseDetails() {
		driver.findElement(By.xpath("//img[@src='http://elearningm1.upskills.in/main/img/icons/22/2rightarrow.png']")).click();
	}
 	 	
}
 	
 	
  	

	
