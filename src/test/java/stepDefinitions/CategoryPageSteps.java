package stepDefinitions;

import genericUtilities.TextContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepo.AddNewCategoryPage;
import objectRepo.CategoryPage;

public class CategoryPageSteps {

	CategoryPage category;
	AddNewCategoryPage addCategory;
	String categoryName;

	TextContextSetUp testContextSetUp;

	public CategoryPageSteps(TextContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}

	@And("^I create a new category with (.*)$")
	public void i_create_a_new_category(String name) {

		category = testContextSetUp.pageobject.getCategoryPage();

		addCategory = testContextSetUp.pageobject.getAddNewCategoryPage();

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
		category.deleteCategory(testContextSetUp.web, categoryName);
	}

	@Then("Newly added category should be removed from the list")
	public void newly_added_category_should_be_removed_from_the_list() {
		System.out.println(category.getSuccessAlertMessage());
	}

}
