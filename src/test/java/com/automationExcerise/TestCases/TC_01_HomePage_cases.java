package com.automationExcerise.TestCases;

import com.automationExcerise.PageClases.LaunchingPage;
import com.automationExcerise.Utilities.Base;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.*;

//@Listeners(CustomerListener.class)
public class TC_01_HomePage_cases extends Base {
    @Test(priority = 0)
    public void openHomePage(){
        log = commonUtils.initilizeLog(commonUtils.getMethodName());
        log.info("Verifying launch page title");
        test.assignCategory("Sanity");
       test.log(Status.INFO,"Verifying the title of the home page");
       launchPage = new LaunchingPage(driver);
        Assert.assertTrue(commonUtils.verifyPageTitle(fileReader.readDataFromPropertyFile("expected_signup_launch_page_title"), launchPage.getPageTitleElement()),"TC_01_HomePage_cases page title is not mismatching...");
    }
    @Test(priority = 1)
    public void openLoginPage(){
        log = commonUtils.initilizeLog(commonUtils.getMethodName());
        launchPage = new LaunchingPage(driver);
        loginPage = launchPage.clickOnSignBtn(driver);
        commonUtils.initilizeLog(commonUtils.getMethodName());
        test.assignCategory("Sanity");
        test.log(Status.INFO,"Verifying the title of the login page");
        log.info("Verifying the login page title");
        Assert.assertTrue(commonUtils.verifyPageTitle(fileReader.readDataFromPropertyFile("expected_login_title"),loginPage.getPageTitleElement()),"Login page title is not matching");
    }
    @Test(priority = 2)
    public void invalid_phoneNo(){
        log = commonUtils.initilizeLog(commonUtils.getMethodName());
        launchPage = new LaunchingPage(driver);
        loginPage = launchPage.clickOnSignBtn(driver);
        commonUtils.initilizeLog(commonUtils.getMethodName());
        test.assignCategory("Smoke");
        test.log(Status.INFO,"Verifying the warning message of phone number");
        log.info("Verifying the warning message of phone number");
        loginPage.enterPhoneNumber(fileReader.readDataFromPropertyFile("Invalid_phoneNo"));
        loginPage.click_on_conntinueBtn();
        System.out.println(loginPage.get_PhNo_warning_msg()+"=============================");
        Assert.assertEquals(loginPage.get_PhNo_warning_msg(),fileReader.readDataFromPropertyFile("PhoneNo_warning_Msg"),"Warning message is not correct");
    }
    @Test(priority = 3)
    public void invalid_password(){
        log = commonUtils.initilizeLog(commonUtils.getMethodName());
        launchPage = new LaunchingPage(driver);
        loginPage = launchPage.clickOnSignBtn(driver);
        commonUtils.initilizeLog(commonUtils.getMethodName());
        test.assignCategory("Smoke");
        test.log(Status.INFO,"Verifying the warning message of password");
        log.info("Verifying the warning message of password");
        loginPage.login(fileReader.readDataFromPropertyFile("SignInPhoneNumber"),fileReader.readDataFromPropertyFile("Invalid_pwd"));
        Assert.assertEquals(loginPage.get_pwd_warning_msg(),fileReader.readDataFromPropertyFile("Password_warning_Msg"));
    }
}
