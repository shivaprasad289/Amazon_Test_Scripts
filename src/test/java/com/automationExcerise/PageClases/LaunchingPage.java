package com.automationExcerise.PageClases;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchingPage {
    private WebDriver driver;

    @FindBy(xpath ="//title[contains(normalize-space(),'Online Shopping site in India')]")
    @CacheLookup
    private WebElement homePageTitle;

    @Getter
    @FindBy(id = "nav-link-accountList")
    @CacheLookup
    private WebElement singInElement;

    public WebElement getPageTitleElement(){
        return homePageTitle;
    }

    public LoginPage clickOnSignBtn(WebDriver driver){
        singInElement.click();
        return new LoginPage(driver);
    }

    public LaunchingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
}
