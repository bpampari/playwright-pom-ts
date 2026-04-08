package com.ailearning.seleniumpom.config;

public final class TestConfig {
    public static final String DEFAULT_BASE_URL = "https://the-internet.herokuapp.com";
    public static final String DEFAULT_BROWSER = "chrome";
    public static final boolean DEFAULT_HEADLESS = true;
    public static final long DEFAULT_TIMEOUT_SECONDS = 10;

    private TestConfig() {
    }

    public static String getBaseUrl() {
        return System.getProperty("baseUrl", DEFAULT_BASE_URL);
    }

    public static String getBrowser() {
        return System.getProperty("browser", DEFAULT_BROWSER).toLowerCase();
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(System.getProperty("headless", String.valueOf(DEFAULT_HEADLESS)));
    }
}
