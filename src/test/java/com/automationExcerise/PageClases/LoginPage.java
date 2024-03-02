package com.automationExcerise.PageClases;

import com.automationExcerise.Utilities.Base;
import com.automationExcerise.Utilities.CommonUtilities;
import com.automationExcerise.Utilities.ElementUtils;
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

    @FindBy(xpath = "//div[@id='auth-error-message-box']/descendant::span")
    private WebElement phNowarningMsg;

    @FindBy(xpath = "//div[@id='auth-error-message-box']/descendant::li")
    private WebElement pwdWarningMsg;
    public String get_PhNo_warning_msg(){
        return phNowarningMsg.getText();
    }
    public String get_pwd_warning_msg(){
        return pwdWarningMsg.getText();
    }
    public void click_on_conntinueBtn(){
        elementUtils.wait_and_click_on_element(continue_btn);
    }
    public void enterPhoneNumber(String phoneNumber){
        elementUtils.wait_and_enter_text(emailOrPhoneTxtFiled,phoneNumber);
    }

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
        commonUtils = new CommonUtilities();
    }
}
