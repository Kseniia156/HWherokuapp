package com.herokuapp.pages;

import com.herokuapp.pages.alertsFrameWindows.FramePage;
import com.herokuapp.pages.alertsFrameWindows.MultipleWindows;
import com.herokuapp.pages.widgets.SelectMenuPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text()='JavaScript Alerts']")
    WebElement javaScriptAlerts;

    public HomePage getJavaScriptAlerts() {
        click(javaScriptAlerts);
        return this;
    }
    @FindBy(xpath = "//a[text()='Frames']")
    WebElement Frames;

    public HomePage getFrames() {
        click(Frames);
        return this;
    }

    @FindBy(xpath = "//a[text()='Multiple Windows']")
    WebElement MultipleWindows;

    public MultipleWindows selectMultipleWindows() {
        click(MultipleWindows);
        return new MultipleWindows(driver);

    }
    @FindBy(xpath = "//a[text()='Dropdown']")
    WebElement DropdownButton;

    public SelectMenuPage selectDropdown() {
        click(DropdownButton);
        return new SelectMenuPage(driver);
    }
}
