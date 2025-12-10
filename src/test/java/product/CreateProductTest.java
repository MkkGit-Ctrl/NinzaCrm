package product;

import java.beans.Transient;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseTest.BaseClass;
import genericUtitliy.ExcelUtitlity;
import genericUtitliy.JavaUtitlity;
import net.bytebuddy.asm.Advice.This;
import objectRepository.CreateProductPage;
import objectRepository.ProductPage;

@Listeners(listeners.ListenerImplementation.class)
public class CreateProductTest extends BaseClass {
	// Utilities
	// Excel data
	ExcelUtitlity util = new ExcelUtitlity(
			"C:\\Users\\Mohit\\Desktop\\AdvanceSelenium\\AdvanceSelenium\\src\\test\\resources\\productData.xlsx");

	@Test
	public void createProduct_test() throws EncryptedDocumentException, IOException, InterruptedException {
		// Pom classes
		ProductPage productpage = new ProductPage(super.driver);
		CreateProductPage product = new CreateProductPage(super.driver);
		// random String
		String randomString = super.java.getRandomString();
		// TestScript data
		String productName = util.getDatafromExcelFile("Sheet1", 1, 0) + randomString;
		String category = util.getDatafromExcelFile("Sheet1", 1, 1);
		String quantity = util.getDatafromExcelFile("Sheet1", 1, 2);
		String price = util.getDatafromExcelFile("Sheet1", 1, 3);
		String vendor = util.getDatafromExcelFile("Sheet1", 1, 4);

		/*
		 * Testscript starts here
		 */
		// Click on product in navigation bar
		home.getProductLink().click();
		// click on create product
		productpage.getAddProductButton().click();
		// Enter Product name
		product.getProductName().sendKeys(productName);
		// Select category
		driverUtility.selectTheOption(product.getCategory(), category);
		// Enter quanntity
		product.getQuantityElement().sendKeys(quantity);
		// Enter price
		product.getUnitElement().clear();
		product.getUnitElement().sendKeys(price);
		// Select vendor
		driverUtility.selectTheOption(product.getVendorElement(), vendor);
		// Click on add product
		product.getAddProduct().click();
		// Wait for toastmesg to be visible
		driverUtility.waitForElementToBeVisible(home.getToastElement());
		// Capturing class
		String toastElementClass = home.getToastElement().getDomAttribute("class");
		System.out.println(toastElementClass);
		Thread.sleep(3000);

		// Verification
//		SoftAssert assert1 = new SoftAssert();
//		assert1.assertFalse(toastElementClass.contains("Toastify__toast Toastify__toast--error"), "Product not Created");
//		// closing the toast message
//		home.getCloseToastElement().click();
//		assert1.assertAll();

//		or

		// closing the toast message
		home.getCloseToastElement().click();
		Thread.sleep(3000);

		// Verification
		Assert.assertFalse(toastElementClass.contains("Toastify__toast Toastify__toast--error"), "Product not Created");

		Reporter.log("Product got created", true);
		System.out.println(System.getProperty("Username"));
		//Printing
		System.out.println("***************");
		
		//2nd commit
		System.out.println(" ");
	}

}
