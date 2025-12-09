package BaseTest;

import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericUtitliy.JavaUtitlity;
import genericUtitliy.PropertiesUtility;
import genericUtitliy.WebDriverUtility;
import listeners.ListenerImplementation;
import objectRepository.HomePage;
import objectRepository.NinzaCrmLogin;
import objectRepository.ProductPage;

@Listeners
public class BaseClass {
	// Global object for every testscript

	public WebDriver driver;

	// Home page Pom class
	public HomePage home;

	// java utitlity
	public JavaUtitlity java = new JavaUtitlity();

	// Webdriver utility
	public WebDriverUtility driverUtility;

	// Common data
	public PropertiesUtility prop = new PropertiesUtility(
			"C:\\Users\\Mohit\\Desktop\\AdvanceSelenium\\AdvanceSelenium\\src\\test\\resources\\CommonDataNinzaCrm.properties");

	@BeforeTest
	public void beforeTest() {
		Reporter.log("pre conditions", true);

	}

	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("DB connectivity open", true);
	}

	@AfterSuite
	public void afterSuite() {
		Reporter.log("DB connectivity close", true);
	}

	@AfterTest
	public void afterTest() {
		Reporter.log("post conditions", true);
	}

	@BeforeClass
	public void beforeClass() throws IOException {
		String browser = prop.getKey("browser");
//		String browser = System.getProperty("Browser");
		// Launching browser

		switch (browser) {
		case "chrome":

			ChromeOptions settings = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			this.driver = new ChromeDriver(settings);
			this.home = new HomePage(this.driver);
			this.driverUtility = new WebDriverUtility(this.driver);
			ListenerImplementation.setDriver(this.driver);
			break;

		case "firefox":
			FirefoxProfile profile = new FirefoxProfile();
			// Set preference (example: disabling password manager leak detection)
			profile.setPreference("signon.management.page.hidePasswords", true);
			profile.setPreference("signon.rememberSignons", false);
			// Attach profile to FirefoxOptions
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(profile);
			this.driver = new FirefoxDriver(options);
			this.home = new HomePage(this.driver);
			this.driverUtility = new WebDriverUtility(this.driver);
			ListenerImplementation.setDriver(this.driver);
			break;

		default:
			// Validation that the driver is not null
			Assert.assertNotNull(driver, "Invalid browser Name");
			break;
		}

		Reporter.log("Launching", true);

	}

	@BeforeMethod
	public void login() throws IOException {
		// common data
		String url = prop.getKey("url");
		String username = prop.getKey("username");
		String password = prop.getKey("password");

		// Maximizing the browser window
		this.driverUtility.maximizeWindow();

		// 3rd line of code
		this.driverUtility.waitForPageToLoad();

		// navigating
		this.driver.get(url);
		System.out.println("Login");

		// Login
		NinzaCrmLogin login = new NinzaCrmLogin(driver);
		// Entering the username
		login.getUsernamElement().sendKeys(username);
		// Entering the password
		login.getPasswordElement().sendKeys(password);
		// Click on login
		login.getLoginButtonElement().click();
	}

	@AfterMethod
	public void logout() throws InterruptedException {
		// logout
		this.driverUtility.moveTheMouseToTheElement(home.getLogoutIcon());
		Thread.sleep(1000);
		this.driverUtility.mouseHoverOnElement(home.getLogoutElement()).click().perform();
		Reporter.log("logout", true);
	}

	@AfterClass
	public void quit() {
		driver.quit();
		Reporter.log("close the browser", true);

	}

}
