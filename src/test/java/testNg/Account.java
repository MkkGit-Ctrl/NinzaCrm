package testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Account {

	@Test(priority = 1)
	public void creatAcc() {	
		//It will print on report
			Reporter.log("Acc got created",true);
	}

	@Test(priority = 2 , dependsOnMethods = "creatAcc" )
	public void editAcc() {
		Reporter.log("Acc got edited", true);
//		WebDriver driver = new ChromeDriver();	
	}

	@Test(priority = 3, dependsOnMethods = "creatAcc")
	public void deleteAcc() {
		System.out.println("Acc got deleted");
	}

}
