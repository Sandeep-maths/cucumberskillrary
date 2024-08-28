package stepDefinitions;

import genericUtilities.TextContextSetUp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import objectRepo.LoginPage;

public class LoginPageSteps {

	TextContextSetUp testContextSetUp;

	public LoginPageSteps(TextContextSetUp testContextSetUp) {
		this.testContextSetUp = testContextSetUp;
	}

	@Given("I enter skillrary login page")
	public void i_enter_skillrary_login_page() {

		testContextSetUp.web.navigateToWebApp(testContextSetUp.property.readdata("url"));

	}

	@And("I login to the skillrary")
	public void i_login_to_the_skillrary() {
		LoginPage login = testContextSetUp.pageobject.getLoginPage();
		login.loginToApp(testContextSetUp.property.readdata("username"),
				testContextSetUp.property.readdata("password"));
	}

}
