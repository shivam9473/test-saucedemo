# SDET Automation Portfolio

Manual test artefacts, UI automation (Selenium + Java), API automation (RestAssured), and GitHub Actions CI for two public demo applications.

## Projects in this repo

| Module | Application | Purpose |
|--------|-------------|---------|
| `ui-tests` | [Sauce Demo](https://www.saucedemo.com/) | Web UI regression — login, cart, checkout |
| `api-tests` | [JSONPlaceholder](https://jsonplaceholder.typicode.com/) | REST API smoke — users GET/POST |

Manual work (test plan, cases, traceability, Jira defects) lives under `docs/`.

## Prerequisites

- JDK 17+
- Maven 3.9+
- Chrome (local runs) or use headless in CI

## Run locally

From the repository root:

```bash
# UI — visible browser
mvn test -pl ui-tests

# UI — headless (same as CI)
mvn test -pl ui-tests -Dheadless=true

# API
mvn test -pl api-tests

# Everything
mvn test
```

Allure report (UI module only):

```bash
cd ui-tests
mvn test -Dheadless=true
mvn allure:serve
```

Failure screenshots: `ui-tests/target/screenshots/`

## CI

GitHub Actions runs on push and pull request:

- **UI job** — headless Chrome, uploads Allure results
- **API job** — Rest Assured suite against jsonplaceholder.typicode.com

```markdown
![CI](https://github.com/shivam9473/test-saucedemo/actions/workflows/ci.yml/badge.svg)
```

## Manual QA and Jira

- Test plan: `docs/test-plan.md`
- Test cases: `docs/test-cases/`
- Traceability: `docs/traceability-matrix.md`
- Jira setup and sample defects: `docs/jira/`

Defects are tracked in Jira with keys like `QA-101`. Markdown copies in `docs/jira/sample-defects/` mirror what is logged in the board for portfolio review.

## Structure

```text
sdet-automation-portfolio/
├── ui-tests/          Selenium 4, TestNG, Page Object Model, Allure
├── api-tests/         Rest Assured, TestNG
├── docs/              Manual QA + Jira references
└── .github/workflows/ CI pipeline
```


