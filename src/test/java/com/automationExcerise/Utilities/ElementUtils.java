package com.automationExcerise.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtils {
    WebDriver driver;
   WebDriverWait wait;
    public ElementUtils(WebDriver driver){
        this.driver = driver;
         wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void wait_and_click_on_element(WebElement element ){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void wait_and_enter_text(WebElement element,String data)  {
        wait.until((ExpectedConditions.visibilityOf(element))).sendKeys(data);
    }
}
