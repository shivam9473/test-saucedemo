# QA-102 — Cart badge slow to update after rapid clicks

| Field | Value |
|-------|-------|
| **Type** | Bug |
| **Priority** | Low |
| **Status** | Done |
| **Component** | Sauce Demo — Cart |
| **Test case** | TC-CART-001 |
| **Found in** | UI automation, headless Chrome |

## Summary

Double-clicking "Add to cart" quickly sometimes left badge at 1 instead of 2 before fix.

## Steps

1. Login and double-click Add to cart on same product rapidly.

## Expected

Badge reflects number of items added (or button toggles to Remove).

## Actual

Intermittent stale badge count in one run.

## Fix

Use explicit wait on badge text in `InventoryPage`; avoid fixed sleeps. Re-ran suite 10x — green.

## Labels

`saucedemo`, `automation`, `flaky`
