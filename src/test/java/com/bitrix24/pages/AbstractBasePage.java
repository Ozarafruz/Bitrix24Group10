package com.bitrix24.pages;

import com.bitrix24.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractBasePage {


protected WebDriver driver = Driver.getDriver();
protected WebDriverWait wait = new WebDriverWait(driver,20);


    @FindBy(id = "user-name")
    protected WebElement currentUserEmail;

public AbstractBasePage(){
    PageFactory.initElements(Driver.getDriver(), this);
}

    /**
     * this method help us to move into other modules like Drive, Mail and Tasks
     * @param componentName
     */
    public void navigateTo(String componentName){
        // all component name starts with capital letter like Drive, Mail
        componentName = String.valueOf(componentName.charAt(0)).toUpperCase()
                .concat(componentName.substring(1).toLowerCase());
        String locator = "//span[contains(text(),'"+componentName+"')]";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator))).click();
    }

    /**
     * this method helps us to search any people or document in the search engine
     * @param anything
     */
    public void search(String anything){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("search-textbox-input"))).sendKeys(anything, Keys.ENTER);

    }

    /**
     * this method give us the email of current user as a string
     * @return currentUserEmail
     */
    public String getCurrentUserEmail(){

        wait.until(ExpectedConditions.visibilityOf(currentUserEmail));
        return currentUserEmail.getText().trim();
    }



}
