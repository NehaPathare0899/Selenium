package com.ShoppersStack_GenericUtility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.shoppersstack_POM.HomePage;
import com.shoppersstack_POM.LoginPage;
import com.shoppersstack_POM.Welcome_Page;

public class Base_Test {
	public WebDriver driver;
	public static WebDriver sDriver;
	public ExtentSparkReporter spark;
	public ExtentReports reports;
	public ExtentTest test;
	public File_Utility fileUtility = new File_Utility();
	public Welcome_Page welcomePage;
	public LoginPage loginPage;
	public HomePage homepage;
	public WebDriverWait wait;
	public java_Utility javaUtility = new java_Utility();
	public WebDriver_Utility webdriverUtiity = new WebDriver_Utility();

	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("BeforeSuite");

	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("BeforeTest");
		spark = new ExtentSparkReporter(
				FrameworkConstants.extentreportsPath + javaUtility.getLocalDateAndTime() + ".html");
		reports = new ExtentReports();
		reports.attachReporter(spark);
		test = reports.createTest("Demo");

	}

	@BeforeClass
	public void beforeClass() throws IOException {
		System.out.println("BeforeClass");
		String browserName = fileUtility.readDataFromPropertyFile("browsername");
		String url = fileUtility.readDataFromPropertyFile("url");
		if (browserName.contains("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.contains("edge")) {
			driver = new EdgeDriver();
		}
		sDriver = driver;
		homepage = new HomePage(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(url);

	}

	@BeforeMethod
	public void beforeMethod() throws IOException {
		System.out.println("BeforeMethod");
		welcomePage = new Welcome_Page(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(welcomePage.getLoginBtn()));
		welcomePage.getLoginBtn().click();
		loginPage = new LoginPage(driver);
		loginPage.getEmailTextField().sendKeys(fileUtility.readDataFromPropertyFile("username"));
		loginPage.getPasswordTextField().sendKeys(fileUtility.readDataFromPropertyFile("password"));
		loginPage.getLoginBtn().click();

	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("AfterMethod");
		homepage.getAccountSettingsBtn().click();
		homepage.getLogOutBtn().click();

	}

	@AfterClass
	public void afterClass() {
		System.out.println("AfterClass");
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("AfterTest");

	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("AfterSuite");

	}

}
