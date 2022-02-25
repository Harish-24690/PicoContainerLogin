package test.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {

	public static WebDriver driver;
	
public static void main(String[] args) {
	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.printerpix.com/");
	driver.findElement(By.xpath("(//a[normalize-space()='Account'])[1]")).click();
	driver.findElement(By.xpath("//a[normalize-space()='Looking to create a new account?']")).click();
	
	//Register
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testautomation@gmail.com");
	driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("Test");
	driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("Automation");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test@0691");
	driver.findElement(By.xpath("//input[@id='confirm_password']")).sendKeys("Test@0691");
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();

}
}
