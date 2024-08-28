package stepDefinitions;

import java.util.Map;

import genericUtilities.Iconstantpath;
import genericUtilities.TextContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectRepo.AddNewUserPage;
import objectRepo.UsersPage;

public class UsersPageSteps {

	TextContextSetUp testContextSetUp;
	public UsersPageSteps(TextContextSetUp testContextSetUp) {
		this.testContextSetUp=testContextSetUp;
	}
	
	@And("I create new user")
	public void i_create_new_user() {
		UsersPage user = testContextSetUp. pageobject.getUsersPage();
		AddNewUserPage addUser = testContextSetUp.pageobject.getAddNewUserPage();
		
		user.clickNewButton();
		
		testContextSetUp.excel.excelInit(Iconstantpath.EXCEL_FILE_PATH);
		
		Map<String, String> map = testContextSetUp.excel.readFromExcel("Sheet1", "Add User");
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
}
