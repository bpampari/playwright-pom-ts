import { Page, Locator } from '@playwright/test';
import { BasePage } from './BasePage';

/**
 * SecureAreaPage — Page Object for /secure
 * Reached after a successful login.
 */
export class SecureAreaPage extends BasePage {
  readonly heading: Locator;
  readonly logoutButton: Locator;
  readonly flashMessage: Locator;

  constructor(page: Page) {
    super(page);
    this.heading      = page.getByRole('heading', { name: 'Secure Area' });
    this.logoutButton = page.getByRole('link', { name: 'Logout' });
    this.flashMessage = page.locator('#flash');
  }

  async getFlashMessage(): Promise<string> {
    await this.flashMessage.waitFor({ state: 'visible' });
    return (await this.flashMessage.innerText()).trim();
  }

  async logout(): Promise<void> {
    await this.logoutButton.click();
  }
}
