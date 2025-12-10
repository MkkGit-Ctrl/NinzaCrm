package campaign;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import genericUtitliy.ExcelUtitlity;
import objectRepository.CampaignPage;

@Listeners(listeners.ListenerImplementation.class)
public class CreateCampaignTest extends BaseClass {

	@Test
	public void createCampainWithMandatoryFields() throws IOException, InterruptedException {
		String ramdomString = java.getRandomString();
		// Campaign page
		// TestScript data
		ExcelUtitlity data = new ExcelUtitlity(
				"C:\\Users\\Mohit\\Desktop\\AdvanceSelenium\\AdvanceSelenium\\src\\test\\resources\\CampaignModuleData.xlsx");
		String campaignName = data.getDatafromExcelFile("Sheet1", 1, 0) + ramdomString;
		String targetSize = data.getDatafromExcelFile("Sheet1", 1, 1);
		/*
		 * Testscript starts here
		 */
		// Home page
		// Click on create button
		home.getCreateCampaignElement().click();
		// Create Campaign page
		CampaignPage campaign = new CampaignPage(driver);
		// Create campaige
		// Enter campaign name
		campaign.getCampaignNameElement().sendKeys(campaignName);
		// Enter targetSize
		campaign.getTargetSizeElement().sendKeys(targetSize);
		// Create campaign
		campaign.getCreateCampaignButton().click();

		// Verification
//		Assert.assertTrue(home.getToastElement().getText().contains(campaignName));

		Thread.sleep(7000);

	}

}
