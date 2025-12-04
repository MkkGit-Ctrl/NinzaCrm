package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "campaignName")
	private WebElement campaignNameElement;

	@FindBy(name = "targetSize")
	private WebElement targetSizeElement;

	@FindBy(xpath  = "//button[text()= 'Create Campaign']")
	private WebElement createCampaignButton;

	public WebElement getCreateCampaignButton() {
		return createCampaignButton;
	}

	public WebElement getCampaignNameElement() {
		return campaignNameElement;
	}

	public WebElement getTargetSizeElement() {
		return targetSizeElement;
	}
}
