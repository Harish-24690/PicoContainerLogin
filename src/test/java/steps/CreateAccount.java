package steps;

import io.cucumber.java.en.And;

import test.PageObjects.HomePage;
import test.PageObjects.LoginPage;
import test.PageObjects.RegisterPage;
import test.utilities.TestContextSetup;

public class CreateAccount extends BaseSteps{
	
public TestContextSetup testContextSetup;
	
public CreateAccount(TestContextSetup testContextSetup){
		
		this.testContextSetup = testContextSetup;
	}
	
	
	@And("User clicks on Looking to create a new account link")
	public void user_clicks_on_looking_to_create_a_new_account_link() {
		
		RegisterPage register= testContextSetup.page.createNewAccountTab();
		testContextSetup.register= register;
	    
	}

	@And("User enter the EmailId has {string}")
	public void user_enter_the_email_id_has(String email) {
		
		testContextSetup.register.emailTab(email);
	    
	}

	@And("user enter Firstname as {string}")
	public void user_enter_firstname_as(String firstname) {
		
		testContextSetup.register.firstName(firstname);
	    
	}

	@And("user enter Lastname as {string}")
	public void user_enter_lastname_as(String lastname) {
		
		testContextSetup.register.lastName(lastname);
	    
	}

	@And("User enter the password as {string}")
	public void user_enter_the_password_as(String Rpassword) {
	
		testContextSetup.register.password(Rpassword);
	}

	@And("user enter the confirm password as {string}")
	public void user_enter_the_confirm_password_as(String confirm) {
		testContextSetup.register.confirmPassword(confirm);
	    
	}

	@And("User clicks on Register button")
	public void user_clicks_on_register_button() {
		
		testContextSetup.register.registerTab();
	    
	}


}
