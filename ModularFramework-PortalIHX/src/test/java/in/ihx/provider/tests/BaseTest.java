package in.ihx.provider.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementations.CommonDriver;
import commonLibs.implementations.ScreenshotControl;
import commonLibs.utils.ConfigFileUtils;
import commonLibs.utils.DateUtils;
import in.ihx.provider.pages.LoginPage;

public class BaseTest {

	CommonDriver cmnDriver;
	String browserType1;
	String baseUrl;
	LoginPage loginPage;
	private WebDriver driver;
	static String configFileName;
	static Properties configProperties;
	static String currentWorkingDirectory;
	static String executionStartDate;

	int pageloadtimeout;
	int elementDetectionTimeout;

	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	ExtentTest extentTest;

	String reportFilename;

	String screenshotFilename;
	ScreenshotControl screenshotControl;

	static {
		try {
			currentWorkingDirectory = System.getProperty("user.dir");
			configFileName = String.format("%s/config/config.properties", currentWorkingDirectory);
			executionStartDate = DateUtils.getCurrentDateAndTime();
			configProperties = ConfigFileUtils.readProperties(configFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void preSetup() {

		initializeReports();
	}

	@BeforeClass
	public void setup() throws Exception {

		invokeBrowser();
		getDriverInstance();
		initializeApplicationPages();
		initializeScreenshotVariable();

	}

	private void initializeScreenshotVariable() {
		screenshotControl = new ScreenshotControl(driver);

	}

	private void initializeApplicationPages() {
		extentTest.log(Status.INFO, "Initializing pages");
		loginPage = new LoginPage(driver);

	}

	private void getDriverInstance() {
		driver = cmnDriver.getDriver();

	}

	@AfterClass
	public void closeBrowser() throws Exception {

		closeAllBrowserinstances();
	}

	@AfterSuite
	public void postCleanUp() {
		extent.flush();
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws Exception {
		String testcaseName = result.getName();
		String screenshotFilename = String.format("%s/screenshot/%s-%s.jpeg", currentWorkingDirectory, testcaseName,
				executionStartDate);
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test Case pass -" + testcaseName);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, "Test Case fail" + testcaseName);
			screenshotControl.captureAndSaveScreenshot(screenshotFilename);
			extentTest.addScreenCaptureFromPath(screenshotFilename);
		} else {
			extentTest.log(Status.SKIP, "Test Case pass -" + testcaseName);
		}

	}

	private void initializeReports() {
		reportFilename = String.format("%s/reports/IHXPortalTestReport-%s.html", currentWorkingDirectory,
				executionStartDate);
		htmlReporter = new ExtentHtmlReporter(reportFilename);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	private void invokeBrowser() throws Exception {
		extentTest = extent.createTest("Setup- Set up the pre - requisit to run automated test cases");

		extentTest.log(Status.INFO, "Browser Invoked is " + browserType1);
		browserType1 = configProperties.getProperty("browsertype");
		cmnDriver = new CommonDriver(browserType1);
		pageloadtimeout = Integer.parseInt(configProperties.getProperty("pageloadTimeout"));
		elementDetectionTimeout = Integer.parseInt(configProperties.getProperty("elementDetectionTimeout"));

		cmnDriver.setPageloadTimeout(pageloadtimeout);
		cmnDriver.setElementdetectionTimeout(elementDetectionTimeout);
		baseUrl = configProperties.getProperty("baseUrl");
		cmnDriver.navigateToUrl(baseUrl);
		extentTest.log(Status.INFO, "Base url is where browser navigate to - " + baseUrl);
	}

	private void closeAllBrowserinstances() throws Exception {
		cmnDriver.setElementdetectionTimeout(60);
		cmnDriver.closeAllBrowser();
		extentTest = extent.createTest("Clean up- Clean up process");
		extentTest.log(Status.INFO, "closing all browser instances");
	}

}
