# QA-103 — GET /users/9999 returns empty body on 404

| Field | Value |
|-------|-------|
| **Type** | Bug |
| **Priority** | Low |
| **Status** | Open |
| **Component** | ReqRes API |
| **Test case** | TC-API-004 |
| **Found in** | API automation |

## Summary

404 response for unknown user has no JSON error message body (status only).

## Steps

`GET https://reqres.in/api/users/9999`

## Expected

Document whether API should return structured error JSON (product decision).

## Actual

HTTP 404 with minimal or empty body depending on client.

## Notes

Test asserts status code only. Enhancement: agree with API owner on error schema — track here until closed.

## Labels

`reqres`, `api`, `documentation`
