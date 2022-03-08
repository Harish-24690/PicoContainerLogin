package runner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features = {"src/test/resources/features"},  //@login or @createAccount
		glue= {"steps"},
		tags = "@signin  " ,
				
		monochrome=true ,
		plugin={"pretty","html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml",
				//"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" ,"timeline:test-output-thread/","rerun:target/failedrun.txt"
				}
				
		
		
		)

public class RunCukeWithTestNG extends AbstractTestNGCucumberTests {
	
	
	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	

}
