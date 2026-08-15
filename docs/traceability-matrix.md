# Traceability matrix

Links requirements → manual test case → automation.

## Sauce Demo (UI)

| Req ID | Requirement | Test case | Automation class#method |
|--------|-------------|-----------|-------------------------|
| REQ-UI-01 | User can sign in with valid credentials | TC-LOGIN-001 | LoginTest#validLoginOpensInventory |
| REQ-UI-02 | Invalid login shows clear error | TC-LOGIN-002 | LoginTest#invalidLoginShowsError |
| REQ-UI-03 | User can sign out | TC-LOGIN-003 | LoginTest#logoutReturnsToLogin |
| REQ-UI-04 | User can add product to cart | TC-CART-001 | CheckoutTest#addItemUpdatesBadge |
| REQ-UI-05 | User can complete purchase | TC-CHECKOUT-001 | CheckoutTest#completeCheckout |

## ReqRes (API)

| Req ID | Requirement | Test case | Automation class#method |
|--------|-------------|-----------|-------------------------|
| REQ-API-01 | List users with pagination | TC-API-001 | UsersApiTest#listUsersPageOne |
| REQ-API-02 | Fetch single user | TC-API-002 | UsersApiTest#getUserById |
| REQ-API-03 | Create user resource | TC-API-003 | UsersApiTest#createUser |
| REQ-API-04 | Missing user returns 404 | TC-API-004 | UsersApiTest#unknownUserNotFound |

## Jira links

When defects are filed, add the Jira key in the **Automation** column comment or link the test execution in your test cycle.

Example: `QA-102` blocked TC-CHECKOUT-002 until validation copy was confirmed.
