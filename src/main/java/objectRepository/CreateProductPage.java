package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	WebDriver driver;

	public CreateProductPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "productName")
	private WebElement productName;

	@FindBy(name = "productCategory")
	private WebElement category;

	@FindBy(name = "quantity")
	private WebElement quantityElement;

	@FindBy(name = "price")
	private WebElement unitElement;

	@FindBy(name = "vendorId")
	private WebElement vendorElement;
	
	@FindBy(xpath = "//button[text() = 'Add']")
   private WebElement addProduct;
	
	public WebElement getAddProduct() {
		return addProduct;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getCategory() {
		return category;
	}

	public WebElement getQuantityElement() {
		return quantityElement;
	}

	public WebElement getUnitElement() {
		return unitElement;
	}

	public WebElement getVendorElement() {
		return vendorElement;
	}
}
