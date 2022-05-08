package com.orangehrmlive.demo.pages;

import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @FindBy(xpath = "//div[@id=\"branding\"]/descendant::img[@alt=\"OrangeHRM\"]")
    WebElement orangeHRMLogo;
    @FindBy(xpath = "//b[contains(text(),'Admin')]")
    WebElement admin;
    @FindBy(xpath = "//b[contains(text(),'PIM')]")
    WebElement pim;
    @FindBy(xpath = "//b[contains(text(),'Leave')]")
    WebElement leave;
    @FindBy(xpath = "//b[contains(text(),'Dashboard')]")
    WebElement dashboard;
    @FindBy(xpath = "//a[@id='welcome']")
    WebElement welcomeText;
    @FindBy(xpath = "//div[@id='welcome-menu']")
    WebElement userMenu;
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    WebElement logOutBtn;

    public void clickOnOrangeHRMLogo(){
        clickOnElement(orangeHRMLogo);
    }

    public void clickOnAdminTab(){
        clickOnElement(admin);
    }
    public void clickOnPIMTab(){
        clickOnElement(pim);
    }
    public void clickOnLeaveTab(){
        clickOnElement(leave);
    }
    public void clickOnDasgBoardTab(){
        clickOnElement(dashboard);
    }

    public String getVerifyWelcomeText(){
        return getTextFromElement(welcomeText);
    }

    public void clickOnLogOutButton(){
        clickOnElement(welcomeText);
        mouseHoverToElement(userMenu);
       mouseHoverToElementAndClick(logOutBtn);
    }
}
