package com.automationExcerise.Utilities;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CustomerListener extends Base implements ITestListener {
    private String testMedthodName;

    public void onStart(ITestContext context){
        initilizeReport();
    }

    public void onTestStart(ITestResult result){
        testMedthodName = result.getName();
       test = extentreport.createTest(testMedthodName);
    }
    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, MarkupHelper.createLabel(result.getName().toUpperCase()+": PASS",ExtentColor.GREEN));
    }
   public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP,result.getTestName()+" - test is skipped");
        test.log(Status.WARNING,result.getThrowable().getMessage());
    }
    @Override
    public void onFinish(ITestContext context) {
        extentreport.flush();
        try {
            Desktop.getDesktop().browse(new File("D:\\Intelije\\Selenium-Framework\\SeleniumFramework\\Reports\\extentReport.html").toURI());
        } catch (IOException e) {
            log.info("Report path not found to open in browser");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL,MarkupHelper.createLabel(result.getName().toUpperCase()+": FAIL",ExtentColor.RED));
        test.log(Status.INFO,result.getThrowable().getMessage());
        test.addScreenCaptureFromPath(commonUtils.captureScreenShot(driver,testMedthodName));
    }
}
