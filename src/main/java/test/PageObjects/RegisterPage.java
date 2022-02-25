package test.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage{
	
	
	@FindBy(how=How.XPATH,using="//input[@id='email']")
	public WebElement emailId;
	
	@FindBy(how=How.XPATH,using="//input[@id='first_name']")
	public WebElement firstName;
	
	@FindBy(how=How.XPATH,using="//input[@id='last_name']")
	public WebElement lastName;
	
	@FindBy(how=How.XPATH,using="//input[@id='password']")
	public WebElement password;
	
	@FindBy(how=How.XPATH,using="//input[@id='confirm_password']")
	public WebElement confirmpassword;
	
	@FindBy(how=How.XPATH,using="//button[normalize-space()='Register']")
	public WebElement registerButton;
	
	
	
	public void emailTab(String email){
		
		type(emailId,email ,"EmailId");
	}
	public void firstName(String firstname){
		
		type(firstName,firstname,"FirstName");
		
		
		}
	
	public void lastName(String lastname){
		
		type(lastName,lastname,"LastName");
		
		
	}
	
	public void password(String pass){
		
		type(password,pass,"password");
		
		
	}
	public void confirmPassword(String confirmpass){
		
		type(confirmpassword,confirmpass,"ConfirmPassword");
	}
	
	public void registerTab(){
		
		click(registerButton,"RegisterButton");
		
	}
	

	@Override
	protected ExpectedCondition getPageLoadCondition() {
		// TODO Auto-generated method stub
		return ExpectedConditions.visibilityOf(emailId);
	}
	
	
	
	

}
