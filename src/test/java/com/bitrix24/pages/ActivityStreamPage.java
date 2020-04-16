package com.bitrix24.pages;

import com.bitrix24.utilities.BrowserUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ActivityStreamPage extends AbstractBasePage{

    //############################################################################################################
    // WebElements and Methods for story 1.1

    @FindBy(id = "feed-add-post-form-link-text")
    private WebElement more;

    @FindBy(xpath = "//span[@class='menu-popup-item-text' and text()='File']")
    private WebElement file;

    @FindBy(xpath = "(//input[@type='file'])[1]")
    private WebElement localDiskUpload;

    @FindBy(id = "blog-submit-button-save")
    private WebElement send;

    @FindBy(xpath = "//a[text()='My Drive / Uploaded files']")
    private WebElement uploadDone;

    @FindBy(xpath = "(//span[text()='Select document from Bitrix24'])[1]")
    private WebElement bitrixUpload;

    @FindBy(xpath = "(//span[text()='Download from external drive'])[1]")
    private WebElement externalDrive;

    @FindBy(xpath = "(//span[@class='wd-fa-add-file-light-title-text'])[3]")
    private WebElement createUsing;

    public WebElement getBitrixUpload() {
        return bitrixUpload;
    }

    public WebElement getExternalDrive() {
        return externalDrive;
    }

    public WebElement getCreateUsing() {
        return createUsing;
    }

    public void uploadFromLocalDisk(String filePath){
        BrowserUtilities.waitForPageToLoad(10);
        localDiskUpload.sendKeys(filePath);
        wait.until(ExpectedConditions.visibilityOf(uploadDone));
        send.click();
    }

    public void clickFile(){
        BrowserUtilities.waitForPageToLoad(10);
        more.click();
        wait.until(ExpectedConditions.visibilityOf(file)).click();
        BrowserUtilities.waitForPageToLoad(10);
    }
    // WebElements and Methods for story 1.1
    //##################################################################################################################


    // WebElements and Methods for story 1.8
    @FindBy(id = "feed-add-post-form-tab-message")
    private WebElement message;

    @FindBy(id = "microoPostFormLHE_blogPostForm_inner")
    private WebElement sendMessage;

    @FindBy(id ="lhe_button_title_blogPostForm")
    private WebElement topicIcon ;

    @FindBy (id = "POST_TITLE")
    private WebElement topicMessage;



    public void clickMessage(){
        BrowserUtilities.waitForPageToLoad(10);
        message.click();
    }

    public WebElement getTopicIcon(){
        BrowserUtilities.waitForPageToLoad(10);

        return topicIcon;
    }
    public WebElement getTopicMessage(){
        BrowserUtilities.waitForPageToLoad(10);

        return topicMessage;
    }
//##################################################################################################################



}
