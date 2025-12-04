package listeners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.collections4.map.StaticBucketMap;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseTest.BaseClass;
import genericUtitliy.JavaUtitlity;

public class ListenerImplementation implements ISuiteListener, ITestListener {
	// Java Utitlity
	JavaUtitlity java = new JavaUtitlity();
	// Static variable to store the incoming driver ref from the base class
	static WebDriver driver;
	// Global object for all the methods
	ExtentSparkReporter spark;
	ExtentReports report;
	ExtentTest test;

	/**
	 * to send the driver variable from base class
	 * 
	 * @param driver
	 */
	public static void setDriver(WebDriver driver) {
		ListenerImplementation.driver = driver;
	}

	@Override
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		spark = new ExtentSparkReporter(
				"C:\\Users\\Mohit\\Desktop\\AdvanceSelenium\\AdvanceSelenium\\AdvancedReport\\Extent_Report_"
						+ java.getCurrentDate() + ".html");

		spark.config().setDocumentTitle("Ninza Crm Test Suit Result");
		spark.config().setReportName("Crm Report");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", "Chrome");
		Reporter.log("Rpoert config", true);
	}

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "------" + result.getMethod().getMethodName() + "Execution Started -----");
		Reporter.log("------" + result.getMethod().getMethodName() + "Execution Started -----", true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("------" + result.getMethod().getMethodName() + "Execution is Successful -----", true);
		test.log(Status.INFO, "<table style=\"border: solid\">\r\n" + "      <tr name = FirstRow align=\"center\" >\r\n"
				+ "        <th>Position</th>\r\n" + "        <th>Movie</th>\r\n" + "        <th>IMDB Rating</th>\r\n"
				+ "      </tr>\r\n" + "      <tr  name = SecondRow align=\"center\">\r\n" + "        <td>1</td>\r\n"
				+ "        <td>Kantara</td>\r\n" + "        <td>8</td>\r\n" + "      </tr>\r\n"
				+ "      <tr  name = ThirdRow align=\"center\">\r\n" + "        <td>2</td>\r\n"
				+ "        <td>Bahubali</td>\r\n" + "        <td>7</td>\r\n" + "      </tr>\r\n" + "\r\n"
				+ "      <tr  name = ForthRow align=\"center\">\r\n" + "        <td>3</td>\r\n"
				+ "        <td>3 idiots</td>\r\n" + "        <td>1</td>\r\n" + "      </tr>\r\n" + "    </table>\r\n"
				+ "\r\n" + "    <br />\r\n" + "    <br />\r\n" + "\r\n" + "    <br />\r\n" + "\r\n" + "    <div>\r\n"
				+ "      <div><input type=\"checkbox\" /><label for=\"\">First </label></div>\r\n" + "\r\n"
				+ "      <div><input type=\"checkbox\" /><label for=\"\"> Second</label></div>\r\n" + "\r\n"
				+ "      <div><input type=\"checkbox\" /><label for=\"\">Third</label></div>\r\n" + "    </div>\r\n"
				+ "");
		test.log(Status.PASS, "------" + result.getMethod().getMethodName() + "Execution Success -----");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		// TODO Auto-generated method stub

		// Capture the curruent data
		String currentdata = java.getCurrentDate();
		// Take the scrren shot of web page
		TakesScreenshot ts = (TakesScreenshot) driver;
		String ss = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss, methodName + currentdata);
		test.log(Status.FAIL, "------" + result.getMethod().getMethodName() + "not Executed-----");
		Reporter.log("------" + result.getMethod().getMethodName() + "not Executed -----", true);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		Reporter.log("------" + result.getMethod().getMethodName() + "Execution is Skipped -----", true);
	}

	@Override
	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		report.flush();
		Reporter.log("Reporter backup", true);
	}

}
