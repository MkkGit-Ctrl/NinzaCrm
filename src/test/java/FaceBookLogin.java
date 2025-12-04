import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import objectRepository.FacebookLoginPage;

public class FaceBookLogin {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.facebook.com");
		
		FacebookLoginPage log = new FacebookLoginPage(driver);
		
	     // username
		log.getUsername().sendKeys("Qspiders");
		
		driver.navigate().refresh();
		
		//pass
		log.getPass().sendKeys("Qspiders");
		
		//Button click
		log.getButton().click();
	
		

	}

}
