# QA-101 — Checkout allows continue with empty first name

| Field | Value |
|-------|-------|
| **Type** | Bug |
| **Priority** | Medium |
| **Status** | Won't Fix |
| **Component** | Sauce Demo — Checkout |
| **Test case** | TC-CHECKOUT-002 |
| **Found in** | Manual exploratory, Chrome 128, Windows 11 |

## Summary

Checkout step one accepts Continue with empty First Name on Sauce Demo (demo behaviour).

## Steps

1. Login as `standard_user`.
2. Add any product to cart and open checkout.
3. Leave First Name blank; fill Last Name and Postal Code.
4. Click Continue.

## Expected

Inline validation prevents continue until First Name is filled.

## Actual

User proceeds to overview step (demo app does not validate empty first name consistently).

## Resolution

Third-party demo limitation — documented as manual-only case. Not automatable without asserting incorrect product behaviour. Logged for portfolio traceability.

## Labels

`saucedemo`, `checkout`, `manual-only`
