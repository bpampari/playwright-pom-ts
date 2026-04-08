# Playwright TS to Selenium Java Conversion Agent

## Mission

Convert a Playwright + TypeScript test project that uses the Page Object Model into a Selenium WebDriver + Java + Maven project without changing test intent.

## Inputs To Review

- `playwright.config.ts`
- `pages/**/*.ts`
- `tests/**/*.ts`
- `utils/**/*.ts`
- `.github/workflows/*.yml`

## Output Contract

Produce:

1. `pom.xml` with Selenium, JUnit 5, and WebDriverManager dependencies
2. `src/main/java/.../pages` page objects matching the original boundaries
3. `src/test/java/.../tests` test classes matching the original scenarios
4. Shared config for `baseUrl`, browser selection, and waits
5. A short migration summary listing any semantic differences or regressions

## Conversion Rules

- Preserve one page object per original page class.
- Replace Playwright `page.goto(path)` with `driver.get(baseUrl + path)`.
- Replace Playwright locators with stable Selenium `By` locators, preferring ids and simple CSS selectors over accessibility-role heuristics.
- Replace Playwright auto-waiting with explicit waits around visibility or clickability.
- Replace Playwright `expect(...).toHaveURL(...)` with JUnit assertions against `driver.getCurrentUrl()`.
- Replace locator visibility assertions with page methods such as `isLoaded()` where practical.
- Replace `selectOption` with Selenium `Select`.
- Normalize text from flash banners before assertions because Selenium returns rendered text including extra whitespace.
- Keep test data centralized.
- Default to Chrome headless unless the source project requires a different browser matrix.

## Review Checklist

- Verify that every TypeScript test case has an equivalent Java test.
- Check whether the Playwright suite depends on retries, tracing, screenshots, or multiple browsers.
- Flag any Playwright-only behavior that has no Selenium equivalent in the current scaffold.
- Flag accessibility-role locators that will need different selectors in Selenium.
- Flag assertions that rely on Playwright auto-retrying.

## Known Risk Areas

- Playwright `getByRole()` selectors often need manual replacement.
- Playwright assertions auto-retry; plain Selenium assertions do not.
- Multi-browser coverage may regress if the Java suite is only wired for one browser by default.
- Test stability will drop if waits are not added consistently.
