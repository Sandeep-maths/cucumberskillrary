package stepDefinitions;


import org.openqa.selenium.WebDriver;

import genericUtilities.Iconstantpath;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesUtility;
import genericUtilities.WebDriverUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepo.AddNewCategoryPage;
import objectRepo.CategoryPage;
import objectRepo.HomePage;
import objectRepo.LoginPage;
import objectRepo.PageObjectManager;

public class AddCategorySteps {
	
	WebDriver driver;
	JavaUtility jutil;
	PropertiesUtility property;
	WebDriverUtility web;
	
	PageObjectManager pageobject;
	
	HomePage home;
	LoginPage login;
	CategoryPage category;
	AddNewCategoryPage addCategory;
	
	String categoryName;
	
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

	
	@When("I click on courses tab and choose category")
	public void i_click_on_courses_tab_and_choose_category() {
	    category=pageobject.getCategoryPage();
	    home.clickCategoryLink();
	}
	
	@And("^I create a new category with (.*)$")
	public void i_create_a_new_category(String name) {
	    addCategory = pageobject.getAddNewCategoryPage();
	    
	    categoryName = name;
	    addCategory.setName(categoryName);
	    addCategory.clickSave();
	    
	}

	@Then("New category should be added to the category list")
	public void new_category_should_be_added_to_the_category_list() {
	    System.out.println(category.getSuccessAlertMessage());
	}

	@When("I delete the newly added category")
	public void i_delete_the_newly_added_category() {
	  category.deleteCategory(web, categoryName);
	}

	@Then("Newly added category should be removed from the list")
	public void newly_added_category_should_be_removed_from_the_list() {
	    System.out.println(category.getSuccessAlertMessage());
	}
	

	@And("I logout of skillrary")
	public void i_logout_of_skillrary() {
		home.signOutOfApp();
		web.quitAllWindows();
	}





}
