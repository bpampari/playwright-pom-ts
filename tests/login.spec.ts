import { test, expect } from '@playwright/test';
import { LoginPage } from '../pages/LoginPage';
import { SecureAreaPage } from '../pages/SecureAreaPage';
import { VALID_USER, INVALID_USER, MESSAGES } from '../utils/testData';

/**
 * TC-001 — Login with valid credentials
 * TC-002 — Login with invalid credentials
 */
test.describe('Form Authentication — Login', () => {
  let loginPage: LoginPage;

  test.beforeEach(async ({ page }) => {
    loginPage = new LoginPage(page);
    await loginPage.goto();
  });

  // ─────────────────────────────────────────────
  // TC-001: Valid login
  // ─────────────────────────────────────────────
  test('TC-001 | Valid credentials should redirect to Secure Area', async ({ page }) => {
    await loginPage.login(VALID_USER.username, VALID_USER.password);

    const secureAreaPage = new SecureAreaPage(page);

    // Assert URL changed to /secure
    await expect(page).toHaveURL(/\/secure/);

    // Assert secure area heading is visible
    await expect(secureAreaPage.heading).toBeVisible();

    // Assert flash success message
    const flash = await secureAreaPage.getFlashMessage();
    expect(flash).toContain(MESSAGES.loginSuccess);
  });

  // ─────────────────────────────────────────────
  // TC-002: Invalid login
  // ─────────────────────────────────────────────
  test('TC-002 | Invalid credentials should show error and stay on login page', async ({ page }) => {
    await loginPage.login(INVALID_USER.username, INVALID_USER.password);

    // Assert URL stays on /login
    await expect(page).toHaveURL(/\/login/);

    // Assert error flash message is shown
    const flash = await loginPage.getFlashMessage();
    expect(flash).toContain(MESSAGES.loginFailure);
  });
});
