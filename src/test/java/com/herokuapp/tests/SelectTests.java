package com.herokuapp.tests;

import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.widgets.SelectMenuPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).selectDropdown();

    }

    @Test
    public void selectOldStyleTest() {
        new SelectMenuPage(driver).selectOldStyle("Option 2")
                .verifyText();
    }

}
