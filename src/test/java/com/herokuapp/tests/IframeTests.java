package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.alertsFrameWindows.FramePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframeTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getFrames();
    }

    @Test
    public void iframeTest() {
        new FramePage(driver).selectIFrames();
        new FramePage(driver).returnListOfFrames()
                .switchToIframeByIndex(0)
                .verifyIframeByText("Your content goes here.");
    }

}
