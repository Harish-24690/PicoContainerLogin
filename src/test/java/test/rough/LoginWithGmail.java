package test.rough;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithGmail {
	
	public static WebDriver driver;

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.printerpix.com/");
		driver.findElement(By.xpath("(//a[normalize-space()='Account'])[1]")).click();
		driver.findElement(By.xpath("//div[@id='customBtn']")).click();
		String parent =driver.getWindowHandle();
		System.out.println("The Parent window is" +parent);
		
		Set<String>s=driver.getWindowHandles();
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
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("testautomation0691@gmail.com");
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Test@0691");
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();
		
		
		
		
		}
		}
	}
}
