package stepDefinitions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import genericUtilities.ExcelUtility;
import genericUtilities.Iconstantpath;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesUtility;
import genericUtilities.WebDriverUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepo.AddNewUserPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.PageObjectManager;
import objectRepo.UsersPage;

public class AddUserSteps {

	WebDriver driver;
	ExcelUtility excel;
	JavaUtility jutil;
	PropertiesUtility property;
	WebDriverUtility web;
	
	PageObjectManager pageobject;
	
	HomePage home;
	LoginPage login;
	UsersPage user;
	AddNewUserPage addUser;
	

	@Given("I enter skillrary login page")
	public void i_enter_skillrary_login_page() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
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

	@When("I click on users")
	public void i_click_on_users() {
		home = pageobject.getHomePage();
		home.clickUsersTab();
	}

	@And("I create new user")
	public void i_create_new_user() {
		user = pageobject.getUsersPage();
		addUser = pageobject.getAddNewUserPage();
		
		user.clickNewButton();
		
		excel.excelInit(Iconstantpath.EXCEL_FILE_PATH);
		
		Map<String, String> map = excel.readFromExcel("Sheet1", "Add User");
		addUser.setEmail(map.get("Email"));
		addUser.setPwd(map.get("Password"));
		addUser.setFirstName(map.get("Firstname"));
		addUser.setLastName(map.get("Lastname"));
		addUser.setAddress(map.get("Address"));
		addUser.setContact(map.get("Contact Info"));
		addUser.uploadPhoto(map.get("Photo"));
		addUser.clickSave();
	}

	@Then("New user should be added to the user list")
	public void new_user_should_be_added_to_the_user_list() {
		
	}

	@When("I delete newly added user")
	public void i_delete_newly_added_user() {
		
	}

	@Then("User should be deleted from the users list")
	public void user_should_be_deleted_from_the_users_list() {
		
	}

	@And("I logout of skillrary")
	public void i_logout_of_skillrary() {
		
	}

}
