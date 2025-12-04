package data_Drivern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Properties_File {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		WebDriver driver = null;

		FileInputStream file = new FileInputStream("C:\\Users\\Mohit\\Desktop\\JavaProperties.properties");

		Properties props = new Properties();

		props.load(file);

		String browser = props.getProperty("browser");

		String url = props.getProperty("url");

		System.out.println(browser);

		switch (browser) {
		case "chrome":
			driver = new ChromeDriver();

			break;

		case "firefox":
			driver = new FirefoxDriver();

			break;

		case "Edge":
			driver = new EdgeDriver();

		default:
			break;
		}

		driver.get(url);

		try {

			driver.findElement(By.className("inputxt"));
			
			System.out.println("Element was located");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("It was not located");
			
			System.err.println(e);
			
		}
			
			
		}
		
		
		
	}


