package genericUtitliy;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WebDriverUtility {

	WebDriver driver;
	WebDriverWait wait;
	Actions action;

	public WebDriverUtility(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		action = new Actions(driver);
		
	}

	public void maximizeWindow() {
		// TODO Auto-generated method stub
		driver.manage().window().maximize();
	}

	// Implicit wait methods
	public void waitForPageToLoad() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
	}

	// Explicit wait methods
	public void waitForElementToBeClickable(WebElement webElement) {
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public void waitForElementToBeVisible(WebElement webElement) {
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	// Select class methods
	public void selectTheOption(WebElement selectElement, String optionName) {
		Select select = new Select(selectElement);
		select.selectByVisibleText(optionName);
	}

	public void deselectTheSelectedOption(WebElement selectElement, String optionName) {
		Select select = new Select(selectElement);
		select.deselectByVisibleText(optionName);
	}

	// Actions Class Methods
	public Actions mouseHoverOnElement(WebElement element) {
		action.moveToElement(element).perform();
		return action;
	}

	public Actions moveTheMouseCursor(int x, int y) {
		action.moveByOffset(x, y).perform();
		return action;
	}

	public Actions moveTheMouseToTheElement(WebElement element) {
		action.moveToElement(element).perform();
		return action;

	}

	public void scrollAction(int pixel) {
		action.scrollByAmount(0, pixel).perform();
	}

	public Actions rightClickOnElement(WebElement element) {
		action.contextClick(element).perform();
		return action;
	}

	public void clickOnElementByMouseCoordinates(int x, int y) {
		action.moveByOffset(x, y).click().perform();
	}

	public void sendInputInElementByMouseCoordinates(int x, int y, String input) {
		action.moveByOffset(x, y).click().sendKeys(input).perform();
	}

	// Switch to Alert
	public Alert switchToAlert() {
		return driver.switchTo().alert();
	}

	// Switch To Tab
	public WebDriver switchToTab(String windowHandle) {
		return driver.switchTo().window(windowHandle);
	}

	public void switchToTabByTitle(String targetWebPageTitle) throws InterruptedException {
		Set<String> allHandles = driver.getWindowHandles();
		for (String handle : allHandles) {
			driver.switchTo().window(handle);
			Thread.sleep(1000);
			if (driver.getTitle().equals(targetWebPageTitle)) {
				driver = driver.switchTo().window(handle);
			}
		}
	}

	// switch To frame
	public void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	}

	// Switching back to web page
	public void switchBackToWebPage() {
		driver.switchTo().defaultContent();
	}

	// Takes Screen shot
	public void takeScreenShotOfWebPage(String screenShotNameWithExtension) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Mohit\\Desktop\\AdvanceSelenium\\AdvanceSelenium\\ScreenShot\\"
				+ screenShotNameWithExtension);
		FileHandler.copy(temp, dest);
	}

	// Take the screen shot wit hdate and time
	public void takeScreenShotWithDateTime() throws IOException {

		Date date = new Date();

		System.out.println(date);

		String datenewString = date.toString().replace(" ", "_").replace(":", "_");
		System.out.println(datenewString);

		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Mohit\\Desktop\\AdvanceSelenium\\AdvanceSelenium\\ScreenShot\\screenshot_"
				+ datenewString + ".jpg");
		FileHandler.copy(temp, dest);

//			C:\Users\Mohit\Desktop\AdvanceSelenium\AdvanceSelenium\ScreenShot
	}

	public void takesScreenShotOfElement(WebElement element, String screenShotNameWithExtension) throws IOException {
		File temp = element.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Mohit\\Desktop\\AdvanceSelenium\\AdvanceSelenium\\ScreenShot\\"
				+ screenShotNameWithExtension);
		FileHandler.copy(temp, dest);
	}

	// JavaScriptExecutor
	public void scrollByPixel(int pixel) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixel + ")");
	}

	public void clickOnDisabledElement(WebElement disbaledElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", disbaledElement);
	}

	public void sendInputInHiddenElement(WebElement hiddenElement, String input) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value =" + input, hiddenElement);
	}

}
