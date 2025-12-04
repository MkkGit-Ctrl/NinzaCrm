package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FacebookLoginPage {
	public FacebookLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

@FindAll({@FindBy(id="email"), @FindBy(xpath="//input[@data-testid='royal-email']") , @FindBy(name="email")})
private	WebElement username;
public WebElement getUsername() {
	return this.username;
}


@FindBy(id="pass")
private	WebElement pass;
public WebElement getPass() {
	return pass;
}

@FindBy(name="login")
private	WebElement button;	
	
public WebElement getButton() {
	return button;
}
}
