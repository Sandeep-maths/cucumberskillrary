package stepDefinitions;

import genericUtilities.TextContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import objectRepo.HomePage;

public class HomePageSteps {

	TextContextSetUp testContextSetUp;
	HomePage home;

	public HomePageSteps(TextContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}

	@When("I click on users")
	public void i_click_on_users() {
		home = testContextSetUp.pageobject.getHomePage();
		home.clickUsersTab();
	}

	@When("I click on courses tab and choose course list")
	public void i_click_on_courses_tab_and_choose_course_list() {
		home = testContextSetUp.pageobject.getHomePage();
		home.clickCoursesTab();
	}

	@When("I click on courses tab and choose category")
	public void i_click_on_courses_tab_and_choose_category() {
		home = testContextSetUp.pageobject.getHomePage();
		home.clickCategoryLink();
	}

	@And("I logout of skillrary")
	public void i_logout_of_skillrary() {
		home.signOutOfApp();

	}
}
