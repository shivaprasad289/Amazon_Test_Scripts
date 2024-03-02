package com.automationExcerise.TestCases;

import com.automationExcerise.PageClases.LaunchingPage;
import com.automationExcerise.Utilities.Base;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.Test;

//@Listeners(CustomerListener.class)

public class TC_02_LoginPage_cases extends Base {

    @Test
    public void login_with_valid_credentails() throws InterruptedException {
        log = commonUtils.initilizeLog(commonUtils.getMethodName());
        launchPage = new LaunchingPage(driver);
        test.assignCategory("Sanity");
        loginPage = launchPage.clickOnSignBtn(driver);
        homePage = loginPage.login(fileReader.readDataFromPropertyFile("SignInPhoneNumber"),fileReader.readDataFromPropertyFile("Password"));
        test.log(Status.INFO,"Login with valid credentials");
        log.info("Login with valid credentials");
        Assert.assertTrue(commonUtils.verifyPageTitle(fileReader.readDataFromPropertyFile("expected_signup_launch_page_title"), launchPage.getPageTitleElement()),"TC_01_HomePage_cases page title is not mismatching...");
    }
}
