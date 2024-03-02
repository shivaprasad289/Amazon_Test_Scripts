package com.automationExcerise.PageClases;

import com.automationExcerise.Utilities.Base;
import com.automationExcerise.Utilities.ElementUtils;
import com.aventstack.extentreports.Status;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Base{
    private WebDriver driver;
    @Getter
    @FindBy(xpath = "//title[normalize-space()='Amazon Sign In']")
    private WebElement pageTitleElement;
    @FindBy(xpath = "//input[@name=\"email\"]")
    private WebElement emailOrPhoneTxtFiled;
    @FindBy(xpath = "//input[@id=\"continue\"]")
    private WebElement continue_btn;
    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement passwordField;
    @FindBy(id = "signInSubmit")
    private WebElement signInBtn;

    private Logger log;
    public  HomePage login(String emailOrPhone,String password){
        elementUtils.wait_and_enter_text(emailOrPhoneTxtFiled,emailOrPhone);
        elementUtils.wait_and_click_on_element(continue_btn);
        elementUtils.wait_and_enter_text(passwordField,password);
        elementUtils.wait_and_click_on_element(signInBtn);
        log.info("Entered phonenumber & password clicked on sign in button");
        return new HomePage(driver);
    }
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        log = LogManager.getLogger(this.getClass().getName());
        elementUtils =  new ElementUtils(driver);
    }
}
