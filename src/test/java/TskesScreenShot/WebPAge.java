package TskesScreenShot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebPAge {

	public static void main(String[] args) throws IOException {

		//downcasting
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		TakesScreenshot ts = (TakesScreenshot) driver;

		//Take the screen shot
		File temp= ts.getScreenshotAs(OutputType.FILE);

		//Create dest file
		File dest = new File("C:\\Users\\Mohit\\Desktop\\AdvanceSelenium\\AdvanceSelenium\\Screen\\webpage.jpg");

		//Copy paste
		FileHandler.copy(temp,dest);

	}

}
