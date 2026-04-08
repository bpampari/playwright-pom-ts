package com.ailearning.seleniumpom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {
    private static final By HEADING = By.cssSelector("h2");
    private static final By LOGOUT_BUTTON = By.cssSelector("a.button.secondary.radius");
    private static final By FLASH_MESSAGE = By.id("flash");

    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return waitForVisible(HEADING).getText().trim().equals("Secure Area");
    }

    public String getFlashMessage() {
        return getNormalizedText(FLASH_MESSAGE);
    }

    public void logout() {
        waitForVisible(LOGOUT_BUTTON).click();
    }
}
