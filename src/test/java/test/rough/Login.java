package test.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	
	public static WebDriver driver;
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.printerpix.com/");
		driver.findElement(By.xpath("(//a[normalize-space()='Account'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("harish.r@syncoms.com");
		driver.findElement(By.xpath("//input[@id='login_password']")).sendKeys("syncoms");
		driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
		
		
	}

}
