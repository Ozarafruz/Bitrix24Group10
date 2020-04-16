package com.bitrix24.tests;


import com.bitrix24.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Story_2_1 extends AbstractBaseTest {

    protected By taskModule = By.xpath("//span[@id='feed-add-post-form-tab-tasks']/span[text()='Task']");
    protected By highPriority = By.xpath("//input[@id='tasks-task-priority-cb']");
    protected By taskName = By.xpath("//input[@name='ACTION[0][ARGUMENTS][data][TITLE]']");
    protected By sendButton = By.xpath("//button[@id='blog-submit-button-save']");

    /**
     * User should be able to click on "High Priority" checkbox to set
     * the current task to a top priority task
     */
    @Test(description = "verify High Priority task can be sent ", priority = 1)
    public void TS_01() {
        LoginPage login = new LoginPage();
        login.login();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //navigate to Task Module:
        driver.findElement(taskModule).click();
        driver.findElement(taskName).sendKeys("Task 2.1 April 15th, 2020: Tuesday");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List <WebElement> frameInput = driver.findElements(By.className("bx-editor-iframe"));
        driver.switchTo().frame(frameInput.get(1));
        driver.findElement(By.xpath("html/body")).sendKeys("User should be able to click on \"High Priority\" checkbox to set " +
                "the current task to a top priority task");
        driver.switchTo().defaultContent();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (driver.findElement(highPriority).isEnabled()) {
            driver.findElement(highPriority).click();
        } else {
            System.out.println("Checkbox is not clickable");
        }
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(sendButton).click();


    }
}
