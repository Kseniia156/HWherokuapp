package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.alertsFrameWindows.AlertsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTests extends TestBase{

    @BeforeMethod
    public void precondition() {
        new HomePage(driver).getJavaScriptAlerts();
    }

    @Test
    public void alertWaitTest () {
        new AlertsPage(driver).alertWithTimer();
    }

    @Test
    public void alertWithSelectTest() {
        new AlertsPage(driver).selectResult("Cancel").verifyResult("Cancel");
    }

    @Test
    public void sengMessageToAlertTest() {
        new AlertsPage(driver).sendMessageToAlert("The third test").verifyMessage("The third test");
    }
}
