package com.ailearning.seleniumpom.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    private static final By DROPDOWN = By.id("dropdown");
    private static final By OPTIONS = By.cssSelector("#dropdown option");

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void gotoPage() {
        navigate("/dropdown");
    }

    public void selectOption(String optionText) {
        Select select = new Select(waitForVisible(DROPDOWN));
        select.selectByVisibleText(optionText);
    }

    public String getSelectedOption() {
        Select select = new Select(waitForVisible(DROPDOWN));
        return select.getFirstSelectedOption().getText().trim();
    }

    public List<String> getAllOptions() {
        return waitForAll(OPTIONS).stream()
                .map(WebElement::getText)
                .map(String::trim)
                .toList();
    }
}
