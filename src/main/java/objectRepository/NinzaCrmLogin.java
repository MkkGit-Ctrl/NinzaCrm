package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NinzaCrmLogin {
	public NinzaCrmLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement usernamElement;

	@FindBy(name = "password")
	private WebElement passwordElement;

	@FindBy(xpath  = "//button[text()= 'Sign In']")
	private WebElement loginButtonElement;

	public WebElement getLoginButtonElement() {
		return loginButtonElement;
	}

	public WebElement getUsernamElement() {
		return usernamElement;
	}

	public WebElement getPasswordElement() {
		return passwordElement;
	}
}
