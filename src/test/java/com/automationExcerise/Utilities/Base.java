package com.automationExcerise.Utilities;
import com.automationExcerise.PageClases.HomePage;
import com.automationExcerise.PageClases.LaunchingPage;
import com.automationExcerise.PageClases.LoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
public abstract class Base {
     public static WebDriver driver;
    protected PropertyFileReader fileReader;
    public Logger log;
    private ExtentSparkReporter sprakreporter;
    public static ExtentReports extentreport;
    public static ExtentTest test;
    public String extentReportFilePath;
    public ElementUtils elementUtils;
    public LaunchingPage launchPage;
    public LoginPage loginPage;
    public HomePage homePage;
    public CommonUtilities commonUtils;
    public SoftAssert softAssert;
    @BeforeMethod
    public void setUp(){
        commonUtils = new CommonUtilities();
        fileReader = new PropertyFileReader();
        softAssert = new SoftAssert();
        driver = commonUtils.intitlize_browser(fileReader.readDataFromPropertyFile("browser"));
        commonUtils.launch_application(fileReader.readDataFromPropertyFile("url"));
      //  commonUtils.hard_refresh(driver,fileReader.readDataFromPropertyFile("expected_signup_launch_page_title"),commonUtils.getPageTitle(launchPage.getPageTitleElement()));
    }
    @AfterMethod
    public void teatDown(){
        driver.close();
    }
    public void initilizeReport(){
        extentReportFilePath = System.getProperty("user.dir")+"/Reports/extentReport.html";
        sprakreporter = new ExtentSparkReporter(extentReportFilePath);
        sprakreporter.config().setDocumentTitle("Execution Report");
        sprakreporter.config().setTheme(Theme.STANDARD);
        sprakreporter.config().setTimeStampFormat("EEEE, MMMM, dd, YYYY, hh:mm a '('zzz')'");
        sprakreporter.config().setReportName("Shivaprasad");
        extentreport = new ExtentReports();
        extentreport.attachReporter(sprakreporter);
    }
}
