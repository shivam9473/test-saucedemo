# Sauce Demo — manual test cases

| ID | Title | Steps | Expected | Priority | Automated |
|----|-------|-------|----------|----------|-------------|
| TC-LOGIN-001 | Valid login | Open site, enter standard_user / secret_sauce, Login | Inventory page, title "Products" | P1 | Yes |
| TC-LOGIN-002 | Invalid login matrix | Empty user, empty pass, locked user | Matching inline error message | P1 | Yes |
| TC-LOGIN-003 | Logout | Login, open menu, Logout | Login page shown | P1 | Yes |
| TC-CART-001 | Add to cart | Login, Add backpack | Cart badge = 1 | P1 | Yes |
| TC-CART-002 | Cart page items | Add item, open cart | One line item, checkout visible | P2 | Partial |
| TC-CHECKOUT-001 | Happy path checkout | Add item, checkout, fill form, finish | "Thank you for your order!" | P1 | Yes |
| TC-CHECKOUT-002 | Missing first name | Checkout with empty first name | Field validation error | P2 | No |
| TC-INV-001 | Product list visible | After login | At least 6 products | P2 | Partial |
| TC-INV-002 | Sort low to high | Select sort option | First price <= last price | P3 | No |

## Notes

- Automated cases map to TestNG `description` attribute for traceability.
- Cases marked "No" are documented for manual exploratory runs or future sprint.
