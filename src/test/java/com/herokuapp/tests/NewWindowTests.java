package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.alertsFrameWindows.MultipleWindows;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewWindowTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).selectMultipleWindows();
    }

    @Test
    public void newTabTest(){
        new MultipleWindows(driver).switchToNewTab(1)
                .verifyTabTitle("New Window");
    }
}
