package stepdefinition;

import java.io.IOException;

import org.testng.Assert;

import PageManger.LoginPageObject;
import generics.TestContextSetup;
import io.cucumber.java.en.*;

public class LoginPage {
	TestContextSetup testcontextsetup;
	LoginPageObject loginpage;
	
	public LoginPage(TestContextSetup testcontextsetup) throws IOException {
		this.testcontextsetup = testcontextsetup;
		this.loginpage = testcontextsetup.pagemanager.LoginPage(); 
	}

	@Given("user is on landing page")
	public void user_is_on_landing_page() {
		loginpage.GetLoginAssertion();
	}

	@When("^user enters (.+) and (.+)$")
	public void user_enters_and(String username ,String password) {
		loginpage.send_USERNAME_PASSWORD(username,password);
	}

	@And("user hits on login button")
	public void user_hits_on_login_button() {
		loginpage.click_on_LOGIN();
	}

	@Then("user is redirected to dashboard")
	public void user_is_redirected_to_dashboard() {
		Assert.assertEquals(loginpage.Validate_Login(), "Log in to Facebook");
	}
	
	@When("user hits on registration button")
	public void user_hits_on_registration_button() {
	    System.out.println("inside Registration");
	}


}
