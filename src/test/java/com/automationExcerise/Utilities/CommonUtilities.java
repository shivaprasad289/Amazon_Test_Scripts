package com.automationExcerise.Utilities;

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

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CommonUtilities {
    public WebDriver driver;

    public boolean status = false;
    public CommonUtilities(){
    }
    public Logger initilizeLog(String methodName){
        return LogManager.getLogger(methodName);
    }

    public WebDriver intitlize_browser(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome"))
            driver = new ChromeDriver();
        if (browserName.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver();
        if (browserName.equalsIgnoreCase("Edge"))
            driver = new EdgeDriver();
        if (browserName.equalsIgnoreCase("InternetExplorer"))
            driver = new InternetExplorerDriver();
        return driver;
    }
    public void launch_application(String url){
        if(driver!=null){
            driver.manage().window().maximize();
            driver.get(url);
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        }
    }
    public String captureScreenShot(WebDriver driver,String testName) {
        String screenshotFilePath = "./Screenshots";
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = ".\\Screenshots\\"+testName+Math.random()+".png";
        try {
            FileUtils.copyFile(src, new File(screenshotPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screenshotPath;
    }
    public boolean verifyPageTitle(String exp_title, WebElement element) {
        if (getText(element).equalsIgnoreCase(exp_title)) {
            status = true;
        }
        return status;
    }
    public String getMethodName(){
        return new Exception().getStackTrace()[0].getMethodName();
    }
    public void hard_refresh(WebDriver driver,String actual_title,String exp_title) {
        boolean status = true;
       while(status){
           if(actual_title.equals(exp_title)){
               status = false;
           }else
               driver.navigate().refresh();
       }
    }
    public String getText(WebElement element) {
        return element.getAttribute("text");
    }
}
