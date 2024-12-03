package com.herokuapp.pages.alertsFrameWindows;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class FramePage extends BasePage {
    public FramePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[text()='iFrame']")
    WebElement iFrame;

    public FramePage selectIFrames() {
        click(iFrame);
        return this;
    }
    @FindBy(tagName = "iframe")
    List<WebElement> iframe;

    public FramePage returnListOfFrames() {
        System.out.println("The total number of iframes are "+iframe.size());
        return this;
    }

    public FramePage switchToIframeByIndex(int index) {
        driver.switchTo().frame(index);
        return this;
    }
    @FindBy(id = "tinymce")
    WebElement tinymce;

    public FramePage verifyIframeByText(String text) {
        Assert.assertTrue(shouldHaveText(tinymce,text,1));
        return this;
    }

}
