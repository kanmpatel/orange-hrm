package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Created by Jay Vaghani
 */

public class UsersTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ViewSystemUsersPage viewSystemUsersPage;
    DashboardPage dashboardPage;
    AdminPage adminPage;
    AddUserPage addUserPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        viewSystemUsersPage = new ViewSystemUsersPage();
        dashboardPage = new DashboardPage();
        addUserPage = new AddUserPage();
        adminPage = new AdminPage();
    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToApplication("Admin","admin123");
        homePage.clickOnAdminTab();
        String actualSystemUserText = "System Users";
        String expectedSystemUserText = viewSystemUsersPage.getVerifySystemUserText();
        softAssert.assertEquals(expectedSystemUserText,actualSystemUserText,"text is not match");
        viewSystemUsersPage.clickOnAddButton();
        String actualAddUserText = "Add User";
        String expectedAddUserText = addUserPage.getVerifyAddUserText();
        softAssert.assertEquals(expectedAddUserText,actualAddUserText,"text is not match");
        addUserPage.selectRoleFromDropDown("Admin");
        addUserPage.enterEmployee("Ananya Dash");
        addUserPage.enterUserName("xyz");
        addUserPage.selectStatusFromDropDown("Disabled");
        addUserPage.enterpassword("Xyz123@");
        addUserPage.enterConfirmPassword("Xyz123@");
        addUserPage.clickOnSaveButton();
        softAssert.assertAll();
    }

    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToApplication("Admin","admin123");
        homePage.clickOnAdminTab();
        String actualSystemUserText = "System Users";
        String expectedSystemUserText = viewSystemUsersPage.getVerifySystemUserText();
        softAssert.assertEquals(expectedSystemUserText,actualSystemUserText,"text is not match");
        viewSystemUsersPage.enteruserName("Jline");
        viewSystemUsersPage.selectRoleFromDropDown("Admin");
        viewSystemUsersPage.selectStatusFromDropDown("Disabled");
        viewSystemUsersPage.clickOnSearchButton();
        String actualUserName = "Jline";
        String expectedUserName = viewSystemUsersPage.getVerifyUseraNameText();
        softAssert.assertEquals(expectedUserName,actualUserName,"username is not match");
        softAssert.assertAll();
    }

    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToApplication("Admin","admin123");
        homePage.clickOnAdminTab();
        viewSystemUsersPage.enteruserName("adash");
        viewSystemUsersPage.selectRoleFromDropDown("ESS");
        viewSystemUsersPage.selectStatusFromDropDown("Enabled");
        viewSystemUsersPage.clickOnSearchButton();

        String actualUserName = "Jline";
        String expectedUserName = viewSystemUsersPage.getVerifyUseraNameText();
        softAssert.assertEquals(expectedUserName,actualUserName,"username is not match");

        viewSystemUsersPage.clickOnUserRecordCheckBox();
        viewSystemUsersPage.clickOnDeleteButton();
        viewSystemUsersPage.clickOnOkButton();
        softAssert.assertAll();
    }

    @Test(groups = {"regression"})
    public void searchTheDeletedUserAndVerifyTheMessageNoRecordFound() {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToApplication("Admin","admin123");
        homePage.clickOnAdminTab();
        String actualSystemUserText = "System Users";
        String expectedSystemUserText = viewSystemUsersPage.getVerifySystemUserText();
        softAssert.assertEquals(expectedSystemUserText,actualSystemUserText,"text is not match");
        viewSystemUsersPage.enteruserName("aaa");
        viewSystemUsersPage.selectRoleFromDropDown("Admin");
        viewSystemUsersPage.selectStatusFromDropDown("Disabled");
        viewSystemUsersPage.clickOnSearchButton();
        String actualUserNotFoundText = "No Records Found";
        String expectedUserNotFoundText = viewSystemUsersPage.getVerifyUserNotFoundText();
        softAssert.assertEquals(expectedUserNotFoundText,actualUserNotFoundText,"text is not match");

        softAssert.assertAll();
    }
}
