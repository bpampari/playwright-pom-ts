package com.ailearning.seleniumpom.tests;

import com.ailearning.seleniumpom.base.BaseTest;
import com.ailearning.seleniumpom.data.TestData;
import com.ailearning.seleniumpom.pages.LoginPage;
import com.ailearning.seleniumpom.pages.SecureAreaPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest {
    @Test
    void tc001_validCredentialsShouldRedirectToSecureArea() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.gotoPage();
        loginPage.login(TestData.VALID_USER.username(), TestData.VALID_USER.password());

        SecureAreaPage secureAreaPage = new SecureAreaPage(driver);

        Assertions.assertTrue(driver.getCurrentUrl().contains("/secure"));
        Assertions.assertTrue(secureAreaPage.isLoaded());
        Assertions.assertTrue(secureAreaPage.getFlashMessage().contains(TestData.LOGIN_SUCCESS_MESSAGE));
    }

    @Test
    void tc002_invalidCredentialsShouldShowErrorAndStayOnLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.gotoPage();
        loginPage.login(TestData.INVALID_USER.username(), TestData.INVALID_USER.password());

        Assertions.assertTrue(driver.getCurrentUrl().contains("/login"));
        Assertions.assertTrue(loginPage.getFlashMessage().contains(TestData.LOGIN_FAILURE_MESSAGE));
    }
}
