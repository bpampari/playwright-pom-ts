import { Page, Locator } from '@playwright/test';
import { BasePage } from './BasePage';

/**
 * LoginPage — Page Object for /login
 * Covers TC-001 (valid login) and TC-002 (invalid login).
 */
export class LoginPage extends BasePage {
  readonly usernameInput: Locator;
  readonly passwordInput: Locator;
  readonly loginButton: Locator;
  readonly flashMessage: Locator;

  constructor(page: Page) {
    super(page);
    this.usernameInput = page.getByRole('textbox', { name: 'Username' });
    this.passwordInput = page.getByRole('textbox', { name: 'Password' });
    this.loginButton   = page.getByRole('button', { name: /Login/i });
    this.flashMessage  = page.locator('#flash');
  }

  async goto(): Promise<void> {
    await this.navigate('/login');
  }

  async login(username: string, password: string): Promise<void> {
    await this.usernameInput.fill(username);
    await this.passwordInput.fill(password);
    await this.loginButton.click();
  }

  async getFlashMessage(): Promise<string> {
    await this.flashMessage.waitFor({ state: 'visible' });
    return (await this.flashMessage.innerText()).trim();
  }
}
