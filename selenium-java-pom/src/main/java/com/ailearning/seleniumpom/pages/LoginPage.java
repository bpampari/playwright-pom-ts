package com.ailearning.seleniumpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT = By.id("username");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector("button[type='submit']");
    private static final By FLASH_MESSAGE = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void gotoPage() {
        navigate("/login");
    }

    public void login(String username, String password) {
        waitForVisible(USERNAME_INPUT).sendKeys(username);
        waitForVisible(PASSWORD_INPUT).sendKeys(password);
        waitForVisible(LOGIN_BUTTON).click();
    }

    public String getFlashMessage() {
        return getNormalizedText(FLASH_MESSAGE);
    }
}
