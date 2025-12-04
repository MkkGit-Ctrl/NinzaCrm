package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()= 'Create Campaign']")
	private WebElement createCampaignElement;

	@FindBy(xpath = "//div[starts-with(@class ,'Toastify__toast To')]")
	private WebElement toastElement;

	@FindBy(xpath = "//div[contains(text(), 'Logout ')]")
	private WebElement logoutElement;

	@FindBy(css = "#navbarNav svg")
	private WebElement logoutIcon;

	@FindBy(css = ".Toastify__close-button")
	private WebElement closeToastElement;

	public WebElement getCloseToastElement() {
		return closeToastElement;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	@FindBy(linkText = "Products")
	private WebElement productLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignLink;

	public WebElement getCampaignLink() {
		return campaignLink;

	}

	public WebElement getLogoutElement() {
		return logoutElement;
	}

	public WebElement getLogoutIcon() {
		return this.logoutIcon;
	}

	public WebElement getToastElement() {
		return toastElement;
	}

	public WebElement getCreateCampaignElement() {
		return createCampaignElement;
	}
}
