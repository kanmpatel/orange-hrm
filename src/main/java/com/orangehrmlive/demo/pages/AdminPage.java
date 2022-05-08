package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends Utility {

    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement mouseHoverOnAdmin;
    @FindBy(xpath = "//a[@id='menu_admin_UserManagement']")
    WebElement userManagementJob;
    @FindBy(xpath = "//a[@id='menu_admin_Organization']")
    WebElement organizationTabs;

    public void clickOnUserManagementJobTab(){
        mouseHoverToElement(mouseHoverOnAdmin);
        mouseHoverToElementAndClick(userManagementJob);
    }

    public void clickOnOrganizationTab(){
        mouseHoverToElement(mouseHoverOnAdmin);
        mouseHoverToElementAndClick(organizationTabs);
    }


}
