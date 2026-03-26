import { Page } from '@playwright/test';

/**
 * BasePage — all Page Objects extend this.
 * Provides shared navigation and utility helpers.
 */
export class BasePage {
  constructor(protected readonly page: Page) {}

  async navigate(path: string = ''): Promise<void> {
    await this.page.goto(path);
  }

  async getTitle(): Promise<string> {
    return this.page.title();
  }

  async getCurrentUrl(): Promise<string> {
    return this.page.url();
  }
}
