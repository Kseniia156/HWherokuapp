package com.herokuapp.pages.widgets;

import com.herokuapp.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SelectMenuPage extends BasePage {
    public SelectMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "dropdown")
    WebElement dropdown;

    public SelectMenuPage selectOldStyle(String text) {
        Select select = new Select(dropdown);

        select.selectByVisibleText(text);
        return this;
    }

    public SelectMenuPage verifyText() {
        String firstSelectedOption = new Select(dropdown).getFirstSelectedOption().getText();
        Assert.assertTrue(shouldHaveText(dropdown, firstSelectedOption,5));


        return this;
    }
}
