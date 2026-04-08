package com.ailearning.seleniumpom.factory;

import com.ailearning.seleniumpom.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public final class WebDriverFactory {
    private WebDriverFactory() {
    }

    public static WebDriver createDriver() {
        return switch (TestConfig.getBrowser()) {
            case "firefox" -> createFirefoxDriver();
            case "chrome" -> createChromeDriver();
            default -> throw new IllegalArgumentException("Unsupported browser: " + TestConfig.getBrowser());
        };
    }

    private static WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        if (TestConfig.isHeadless()) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1280,720");
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if (TestConfig.isHeadless()) {
            options.addArguments("--headless");
        }
        return new FirefoxDriver(options);
    }
}
