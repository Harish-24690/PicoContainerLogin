package test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
	
	
	@FindBy(how=How.XPATH,using="//input[@id='login_email']")
	public WebElement emailID;
	
	@FindBy(how=How.XPATH,using="//input[@id='login_password']")
	public WebElement password;
	
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Sign In']")
    public WebElement signInButton;
	
	@FindBy(how=How.XPATH,using="//a[normalize-space()='Looking to create a new account?']")
	public WebElement CreateNewAccount;

	
	
	public LoginPage emailIdBox(String email){
		
		//emailID.sendKeys(email);
		type(emailID,email,"Emailid");
		return this;
	}
	
	public LoginPage passwordTextBox(String pass){
		
		//password.sendKeys(pass);
		type(password ,pass,"Password");
		return this;
	}
	
	public LoginPage loginInButton(){
		
		//signInButton.click();
		click(signInButton , "SignInbutton");
		//return (HomePage) openPage(HomePage.class);
		return this;
	}
	
	public RegisterPage createNewAccountTab(){
		
		click(CreateNewAccount,"CreateAccount");
		return (RegisterPage) openPage(RegisterPage.class);
	}
	
	
	
	@Override
	protected ExpectedCondition getPageLoadCondition() {
		
		return ExpectedConditions.visibilityOf(emailID);
	}
}
