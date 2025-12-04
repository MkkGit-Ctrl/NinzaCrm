package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoWebShopPage {

	WebDriver driver;

	public DemoWebShopPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Facebook")
	private WebElement faceBookLink;

	public WebElement getFaceBookLink() {
		return faceBookLink;
	}

}
