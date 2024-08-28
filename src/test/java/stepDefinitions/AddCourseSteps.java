package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;

import genericUtilities.Iconstantpath;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesUtility;
import genericUtilities.WebDriverUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepo.AddNewCoursePage;
import objectRepo.CourseListPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.PageObjectManager;

public class AddCourseSteps {
	
	WebDriver driver;
	JavaUtility jutil;
	PropertiesUtility property;
	WebDriverUtility web;
	
	PageObjectManager pageobject;
	
	HomePage home;
	LoginPage login;
	CourseListPage course;
	AddNewCoursePage addCourse;
	
	String courseName;

	@Given("I enter skillrary login page")
	public void i_enter_skillrary_login_page() {
		property = new PropertiesUtility();
		web = new WebDriverUtility();
		jutil = new JavaUtility();

		property.propertiesInit(Iconstantpath.PROPERTIES_FILE_PATH);

		driver = web.launchBrowser(property.readdata("browser"));
		web.maximizeBrowser();

		long time = (Long) jutil.ConvertStringToAnyDataType(property.readdata("timeouts"), "long");
		web.waitTillElementFound(time);
		web.navigateToWebApp(property.readdata("url"));
		
		pageobject = new PageObjectManager(driver);

	}

	@And("I login to the skillrary")
	public void i_login_to_the_skillrary() {
		login = pageobject.getLoginPage();
		login.loginToApp(property.readdata("username"), property.readdata("password"));
	}

	
	@When("I click on courses tab and choose course list")
	public void i_click_on_courses_tab_and_choose_course_list() {
	    course=pageobject.getCourseListPage();
	    home.clickCoursesTab();
	}

	@And("I create a new course")
	public void i_create_a_new_course(List<Object> list) {
	    addCourse = pageobject.getAddCoursePage();
	    
	    course.clickNewButton();
	    
	    courseName =(String) list.get(0);
	    addCourse.setName(courseName);
	    addCourse.selectCategory(web, (String)list.get(1));
	    addCourse.setPrice((String) list.get(2));
	    addCourse.uploadPhoto((String)list.get(3));
	    addCourse.addDescription(web, (String) list.get(4));
	    addCourse.clickSave();
	    
	}

	@Then("New course should be added to the course list")
	public void new_course_should_be_added_to_the_course_list() {
	    System.out.println(course.getSuccessAlertMessage());
	}

	@When("I delete the newly added course")
	public void i_delete_the_newly_added_course() {
	  course.deleteCourse(web, courseName);
	}

	@Then("Newly added course should be removed from the list")
	public void newly_added_course_should_be_removed_from_the_list() {
	    System.out.println(course.getSuccessAlertMessage());
	}
	

	@And("I logout of skillrary")
	public void i_logout_of_skillrary() {
		home.signOutOfApp();
		web.quitAllWindows();
	}


}
