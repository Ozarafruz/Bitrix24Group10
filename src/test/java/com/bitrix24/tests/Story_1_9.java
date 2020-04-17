package com.bitrix24.tests;

import com.bitrix24.pages.ActivityStreamPage;
import com.bitrix24.pages.LoginPage;
import org.testng.annotations.Test;

public class Story_1_9 extends AbstractBaseTest{
    /*
     9. User should be able to click on "Record Video" tab
     to record a video and attach it with the message
     */
    @Test
    public void recordVideoTest (){
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        ActivityStreamPage activityStreamPage = new ActivityStreamPage();
        activityStreamPage.recordVideo();

    }

}
