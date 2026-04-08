# Selenium Java POM Conversion

This Maven project mirrors the existing Playwright TypeScript suite using:

- Selenium WebDriver
- Java 17
- JUnit 5
- Page Object Model
- WebDriverManager

## Structure

```text
selenium-java-pom/
|-- pom.xml
`-- src
    |-- main
    |   `-- java/com/ailearning/seleniumpom
    |       |-- config/TestConfig.java
    |       |-- factory/WebDriverFactory.java
    |       `-- pages/
    |           |-- BasePage.java
    |           |-- DropdownPage.java
    |           |-- LoginPage.java
    |           `-- SecureAreaPage.java
    `-- test
        `-- java/com/ailearning/seleniumpom
            |-- base/BaseTest.java
            |-- data/TestData.java
            `-- tests/
                |-- DropdownTests.java
                `-- LoginTests.java
```

## Run

```bash
mvn test
mvn test -Dbrowser=firefox
mvn test -DbaseUrl=https://the-internet.herokuapp.com
mvn test -Dheadless=false
```

## Conversion Notes

- Playwright `baseURL` moved into `TestConfig`.
- Playwright auto-wait behavior is replaced with explicit waits in `BasePage`.
- Playwright dropdown helpers are replaced with Selenium's `Select`.
- The project defaults to headless browser execution for CI parity, but `-Dheadless=false` is supported.
