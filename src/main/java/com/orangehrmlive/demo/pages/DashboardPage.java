package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends Utility {

    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement dashBoardText;

    public String getVerifyDashBoardText(){
        return getTextFromElement(dashBoardText);
    }
}
