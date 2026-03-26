/**
 * Centralised test data — update credentials / options here
 * without touching individual test files.
 */

export const VALID_USER = {
  username: 'tomsmith',
  password: 'SuperSecretPassword!',
} as const;

export const INVALID_USER = {
  username: 'wronguser',
  password: 'wrongpassword',
} as const;

export const DROPDOWN_OPTIONS = {
  placeholder: 'Please select an option',
  option1: 'Option 1',
  option2: 'Option 2',
} as const;

export const MESSAGES = {
  loginSuccess: 'You logged into a secure area!',
  loginFailure: 'Your username is invalid!',
  logoutSuccess: 'You logged out of the secure area!',
} as const;
