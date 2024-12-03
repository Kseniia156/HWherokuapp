package com.herokuapp.pages.alertsFrameWindows;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[text()='Click for JS Alert']")
    WebElement jsAlertButton;

    public AlertsPage alertWithTimer() {
        click(jsAlertButton);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent()).accept();
        return this;
    }

    @FindBy(xpath = "//button[text()='Click for JS Confirm']")
    WebElement jsConfirmButton;

    public AlertsPage selectResult(String result) {
        click(jsConfirmButton);

        if(result != null && result.equals("Ok")) {
            driver.switchTo().alert().accept();
        } else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }
    @FindBy(id = "result")
    WebElement result;

    public AlertsPage verifyResult(String text) {
        Assert.assertTrue(result.getText().contains(text));
        return this;
    }
    @FindBy(xpath = "//button[text()='Click for JS Prompt']")
    WebElement jsPromptButton;

    public AlertsPage sendMessageToAlert(String message) {
        click(jsPromptButton);

        if (message !=null) {
            driver.switchTo().alert().sendKeys(message);
            driver.switchTo().alert().accept();
        }
        return this;
    }
    @FindBy(xpath = "//p[@id='result' and text()='You entered: The third test']")
    WebElement resultPrompt;

    public AlertsPage verifyMessage(String text) {
        Assert.assertTrue(resultPrompt.getText().contains(text));
        return this;
    }
}
