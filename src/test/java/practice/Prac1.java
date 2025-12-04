package practice;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtitliy.WebDriverUtility;
import objectRepository.DemoWebShopPage;

public class Prac1 {
	
	@Test
	public void test() throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		WebDriverUtility control = new WebDriverUtility(driver);
		DemoWebShopPage demo = new DemoWebShopPage(driver);
		
		control.maximizeWindow();
		control.waitForPageToLoad();
		driver.get("https://demowebshop.tricentis.com/");
		demo.getFaceBookLink().click();
	
	
		control.switchToTabByTitle("NopCommerce | Facebook");
		
		System.out.println(driver.getTitle());
		
		control.sendInputInElementByMouseCoordinates(650, 350, "Qspiders");
	

		
		
	}
	
	
	


}
