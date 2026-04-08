package com.ailearning.seleniumpom.data;

public final class TestData {
    public static final Credentials VALID_USER = new Credentials("tomsmith", "SuperSecretPassword!");
    public static final Credentials INVALID_USER = new Credentials("wronguser", "wrongpassword");

    public static final String DROPDOWN_PLACEHOLDER = "Please select an option";
    public static final String DROPDOWN_OPTION_1 = "Option 1";
    public static final String DROPDOWN_OPTION_2 = "Option 2";

    public static final String LOGIN_SUCCESS_MESSAGE = "You logged into a secure area!";
    public static final String LOGIN_FAILURE_MESSAGE = "Your username is invalid!";
    public static final String LOGOUT_SUCCESS_MESSAGE = "You logged out of the secure area!";

    private TestData() {
    }

    public record Credentials(String username, String password) {
    }
}
