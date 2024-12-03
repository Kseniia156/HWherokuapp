package com.herokuapp.pages.alertsFrameWindows;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class MultipleWindows extends BasePage {
    public MultipleWindows(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='Click Here']")
    WebElement tabButton;

    public MultipleWindows switchToNewTab(int index) {
        click(tabButton);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(index));
        return this;
    }

    @FindBy(xpath = "//h3[text()='New Window']")
    WebElement textNewWindow;

    public MultipleWindows verifyTabTitle(String text) {
        Assert.assertTrue(shouldHaveText(textNewWindow, text,5));
        return this;
    }
}
