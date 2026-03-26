import { test, expect } from '@playwright/test';
import { DropdownPage } from '../pages/DropdownPage';
import { DROPDOWN_OPTIONS } from '../utils/testData';

/**
 * TC-003 — Dropdown selection
 */
test.describe('Dropdown — Option Selection', () => {
  let dropdownPage: DropdownPage;

  test.beforeEach(async ({ page }) => {
    dropdownPage = new DropdownPage(page);
    await dropdownPage.goto();
  });

  // ─────────────────────────────────────────────
  // TC-003: Select Option 1
  // ─────────────────────────────────────────────
  test('TC-003 | Should display all options and allow selecting Option 1', async () => {
    // Verify all options are available
    const allOptions = await dropdownPage.getAllOptions();
    expect(allOptions).toContain(DROPDOWN_OPTIONS.placeholder);
    expect(allOptions).toContain(DROPDOWN_OPTIONS.option1);
    expect(allOptions).toContain(DROPDOWN_OPTIONS.option2);

    // Select Option 1
    await dropdownPage.selectOption(DROPDOWN_OPTIONS.option1);

    // Assert Option 1 is selected
    const selected = await dropdownPage.getSelectedOption();
    expect(selected).toBe(DROPDOWN_OPTIONS.option1);
  });

  test('TC-003b | Should allow switching between options', async () => {
    // Select Option 1
    await dropdownPage.selectOption(DROPDOWN_OPTIONS.option1);
    expect(await dropdownPage.getSelectedOption()).toBe(DROPDOWN_OPTIONS.option1);

    // Switch to Option 2
    await dropdownPage.selectOption(DROPDOWN_OPTIONS.option2);
    expect(await dropdownPage.getSelectedOption()).toBe(DROPDOWN_OPTIONS.option2);
  });
});
