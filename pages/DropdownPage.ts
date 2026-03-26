import { Page, Locator } from '@playwright/test';
import { BasePage } from './BasePage';

/**
 * DropdownPage — Page Object for /dropdown
 * Covers TC-003 (dropdown selection).
 */
export class DropdownPage extends BasePage {
  readonly dropdown: Locator;

  constructor(page: Page) {
    super(page);
    this.dropdown = page.locator('#dropdown');
  }

  async goto(): Promise<void> {
    await this.navigate('/dropdown');
  }

  async selectOption(optionText: string): Promise<void> {
    await this.dropdown.selectOption({ label: optionText });
  }

  async getSelectedOption(): Promise<string> {
    return this.dropdown.evaluate((el: HTMLSelectElement) => {
      return el.options[el.selectedIndex]?.text ?? '';
    });
  }

  async getAllOptions(): Promise<string[]> {
    return this.dropdown.evaluate((el: HTMLSelectElement) => {
      return Array.from(el.options).map((o) => o.text);
    });
  }
}
