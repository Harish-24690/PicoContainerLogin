package test.rough;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginwithFacebook {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.printerpix.com/");
		driver.findElement(By.xpath("(//a[normalize-space()='Account'])[1]")).click();
		driver.findElement(By.xpath("(//button[normalize-space()='Sign in with Facebook'])[1]")).click();
		String parent =driver.getWindowHandle();
		System.out.println("The Parent window is" +parent);
		
		Set<String> s =driver.getWindowHandles();
		Iterator<String> I1= s.iterator();
		while(I1.hasNext()){
        String child_window=I1.next();
        
       if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		System.out.println(driver.switchTo().window(child_window).getTitle());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("harish_kiccha@yahoo.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("incorrect");
        driver.findElement(By.xpath("(//input[@name='login'])[1]")).click();
        
		}
		}
		
	}

}
