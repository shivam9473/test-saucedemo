# Test plan — Sauce Demo & ReqRes

**Version:** 1.0  
**Author:** QA portfolio  
**Date:** August 2026

## 1. Scope

### In scope

- Sauce Demo: authentication, inventory, cart, checkout, logout
- ReqRes `/users` endpoints: list, get by id, create, not-found handling
- Chrome (latest) for UI; API tests run without browser

### Out of scope

- Performance / load testing
- Mobile native apps
- Payment gateway (Sauce Demo uses mock checkout)
- ReqRes auth endpoints (not required for demo API)

## 2. Test environments

| Env | UI base URL | API base URL |
|-----|-------------|--------------|
| Demo (public) | https://www.saucedemo.com/ | https://reqres.in/api |

## 3. Test data

| User | Password | Expected |
|------|----------|----------|
| standard_user | secret_sauce | Login success |
| locked_out_user | secret_sauce | Locked message |
| (empty) | secret_sauce | Username required |

## 4. Entry criteria

- Application reachable over HTTPS
- Test data documented in `ui-tests/src/test/resources/config.properties`
- Automation suite passes locally before CI merge

## 5. Exit criteria

- All P1 manual cases executed or automated
- No open P1 defects
- CI green on default branch

## 6. Risks

| Risk | Mitigation |
|------|------------|
| Third-party demo site layout change | Page Object locators centralized; smoke suite catches breaks |
| ReqRes rate limits | Small suite; retry in CI if needed |
| Flaky UI timing | Explicit waits only; screenshots on failure |

## 7. Deliverables

- Test cases (`docs/test-cases/`)
- Traceability matrix (`docs/traceability-matrix.md`)
- Jira defects (`docs/jira/`)
- Automated suites (`ui-tests`, `api-tests`)
