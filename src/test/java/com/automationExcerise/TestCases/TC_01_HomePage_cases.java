package com.automationExcerise.TestCases;

import com.automationExcerise.PageClases.LaunchingPage;
import com.automationExcerise.PageClases.LoginPage;
import com.automationExcerise.Utilities.Base;
import com.automationExcerise.Utilities.CommonUtilities;
import com.automationExcerise.Utilities.CustomerListener;
import com.aventstack.extentreports.Status;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.*;

//@Listeners(CustomerListener.class)
public class TC_01_HomePage_cases extends Base {
    @Test()
    public void openHomePage(){
        log = commonUtils.initilizeLog(commonUtils.getMethodName());
        log.info("Verifying launch page title");
        test.assignCategory("Sanity");
       test.log(Status.INFO,"Verifying the title of the home page");
       launchPage = new LaunchingPage(driver);
        Assert.assertTrue(commonUtils.verifyPageTitle(fileReader.readDataFromPropertyFile("expected_signup_launch_page_title"), launchPage.getPageTitleElement()),"TC_01_HomePage_cases page title is not mismatching...");
    }
    @Test
    public void openLoginPage(){
        launchPage = new LaunchingPage(driver);
        loginPage = launchPage.clickOnSignBtn(driver);
        commonUtils.initilizeLog(commonUtils.getMethodName());
        test.assignCategory("Sanity");
        test.log(Status.INFO,"Verifying the title of the login page");
        log.info("Verifying the login page title");
        Assert.assertTrue(commonUtils.verifyPageTitle(fileReader.readDataFromPropertyFile("expected_login_title"),loginPage.getPageTitleElement()),"Login page title is not matching");
    }
}
