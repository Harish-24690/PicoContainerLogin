package steps;

import io.cucumber.java.en.And;
import test.utilities.TestContextSetup;

public class LoginPageSteps extends BaseSteps{
	
public TestContextSetup testContextSetup;
	
public LoginPageSteps(TestContextSetup testContextSetup){
		
		this.testContextSetup = testContextSetup;
	}
	
	@And("User enters the username has {string}")
	public void user_enters_the_username_has(String username) {
		
		testContextSetup.page.emailIdBox(username);
	    
	}

	@And("User enters the password has {string}")
	public void user_enters_the_password_has(String password) {
		
		testContextSetup.page.passwordTextBox(password);
	    
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testContextSetup.page.loginInButton();
	    
	}

}
