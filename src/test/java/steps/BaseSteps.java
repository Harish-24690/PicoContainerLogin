package steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;

import com.aventstack.extentreports.gherkin.model.Scenario;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.Listeners.CustomListeners;
import test.utilities.DriverFactory;
import test.utilities.DriverManager;

public class BaseSteps {

	private WebDriver driver;
	private Properties config = new Properties();
	private FileInputStream fis;
	private Boolean grid = false;
	private String DefaultUsername;
	private String DefaultPassword;
	public static final String USERNAME = "harish_g3JBs1";
	public static final String AUTOMATE_KEY = "sr76wkzNqdxP6vHtzEuu";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public String getDefaultUsername() {
		return DefaultUsername;
	}

	public void setDefaultUsername(String defaultUsername) {
		DefaultUsername = defaultUsername;
	}

	public String getDefaultPassword() {
		return DefaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		DefaultPassword = defaultPassword;
	}

	public void setUpFrameWork() {

		DriverFactory.setGridPath(URL);
		DriverFactory.setConfigPropertyFile(
				System.getProperty("user.dir") + "//src//test//resources//properties//Config.properties");

		if (System.getProperty("os.name").contains("mac")) {

			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables.chromedriver");
			DriverFactory.setGeckoDriverExepath(
					System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver");
		} else {
			DriverFactory.setChromeDriverExePath(
					System.getProperty("user.dir") + "//src//test//resources//executables.chromedriver.exe");
			DriverFactory.setGeckoDriverExepath(
					System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver.exe");
		}
		try {
			fis = new FileInputStream(DriverFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			// log.info("Configuration file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void openBrowser(String browser ,String os ,String os_version ,String browser_version) {
		
		if(System.getenv("ExceutionType")!=null && System.getenv("ExceutionType").equals("Grid")){
		
		grid=true;
	}
	
	DriverFactory.setRemote(grid);
	
	if(DriverFactory.isRemote()){
		
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setCapability("os", os);
		cap.setCapability("os_version", os_version);
		cap.setCapability("browser_version", browser_version);
		cap.setCapability("name", HomePageSteps.scenarioName);
		
		if(browser.equals("Chrome")){
			
			WebDriverManager.chromedriver().setup();
			cap.setCapability("browser", browser);
		}else if(browser.equals("Firefox")){
			
			WebDriverManager.firefoxdriver().setup();
			cap.setCapability("browser", browser);
		}else if(browser.equals("Safari")){
			cap.setCapability("browser", browser);
		}
		try {
			driver = new RemoteWebDriver(new URL(URL), cap);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
			
		
	} else {

			if (browser.equals("Chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (browser.equals("Firefox")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}

		}
		DriverManager.setWebDriver(driver);
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		setDefaultUsername(config.getProperty("DefaultUsername"));
		setDefaultPassword(config.getProperty("DefaultPassword"));

	}

	public void logInfo(String message) {

		CustomListeners.testReport.get().info(message);
	}

	public void tearDown() {

		DriverManager.getDriver().quit();
	}

}
