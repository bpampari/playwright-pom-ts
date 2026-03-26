# 🎭 Playwright POM Test Suite — TypeScript

Automated QA test suite for [the-internet.herokuapp.com](https://the-internet.herokuapp.com) using **Playwright** + **TypeScript** with the **Page Object Model (POM)** pattern.

---

## 📁 Project Structure

```
playwright-pom-ts/
├── pages/                  # Page Object classes
│   ├── BasePage.ts         # Shared base for all pages
│   ├── LoginPage.ts        # /login page
│   ├── SecureAreaPage.ts   # /secure page (post-login)
│   └── DropdownPage.ts     # /dropdown page
├── tests/                  # Test specs
│   ├── login.spec.ts       # TC-001, TC-002
│   └── dropdown.spec.ts    # TC-003
├── utils/
│   └── testData.ts         # Centralised test data & constants
├── .github/
│   └── workflows/
│       └── playwright.yml  # GitHub Actions CI pipeline
├── playwright.config.ts
├── tsconfig.json
└── package.json
```

---

## ✅ Test Cases

| ID | Page | Description | Expected |
|---|---|---|---|
| TC-001 | `/login` | Valid credentials login | Redirect to `/secure`, success flash |
| TC-002 | `/login` | Invalid credentials login | Stay on `/login`, error flash shown |
| TC-003 | `/dropdown` | Select Option 1 from dropdown | Option 1 is selected |
| TC-003b | `/dropdown` | Switch between dropdown options | Selected value updates correctly |

---

## 🚀 Getting Started

### Prerequisites
- Node.js 18+
- npm

### Install

```bash
npm install
npx playwright install --with-deps
```

### Run Tests

```bash
# Run all tests (headless)
npm test

# Run with browser visible
npm run test:headed

# Open HTML report
npm run test:report
```

---

## 🔗 GitHub Integration

This repo includes a GitHub Actions workflow that:
- Triggers on **push** and **pull request** to `main`, `master`, `develop`
- Runs tests on **Chromium** and **Firefox**
- Uploads the **HTML report** and **JUnit XML** as artifacts

### Steps to push to GitHub

```bash
git init
git add .
git commit -m "feat: initial Playwright POM test suite"
git remote add origin https://github.com/<your-username>/<your-repo>.git
git push -u origin main
```

The CI pipeline will run automatically on every push. ✅
