package campaign;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.beust.jcommander.Parameter;

import genericUtitliy.WebDriverUtility;
import objectRepository.HomePage;

public class CreateCampaign1 {
	@Test
	public void CreateCampaignwithDescription() {
		System.out.println("Create campaign with Description");
		
	}
	
	@Test
	@Parameters("browser")
	public void CreateCampaignwithMandatory(String browser) throws IOException {
		WebDriver driver= null;
		System.out.println(browser);
		switch (browser) {
		case "chrome":
	    	 driver = new ChromeDriver();
			break;

		case "firefox":
			driver = new FirefoxDriver();
			break;

		default:
			//Validation that the driver is not null
		}
		
	}
	
	

}
