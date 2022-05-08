package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully() {
            loginPage.enterUserName("Admin");
            loginPage.enterPassword("admin123");
            loginPage.clickOnLoginButton();
            String expectedWelcomeText = "Welcome";
            String actualWelcomeText = homePage.getVerifyWelcomeText();
            Assert.assertEquals(expectedWelcomeText,actualWelcomeText.substring(0,7));
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();

    }

    @Test(groups = {"regression"})
    public void  verifyUserShouldLogOutSuccessFully() {
        loginPage.enterUserName("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickOnLoginButton();
        homePage.clickOnLogOutButton();
        String expectedLoginPanelText = "Login Panel";
        String actualLoginPanelText = loginPage.getVerifyLoginPanelText();
        Assert.assertEquals(actualLoginPanelText,expectedLoginPanelText);
    }


}
