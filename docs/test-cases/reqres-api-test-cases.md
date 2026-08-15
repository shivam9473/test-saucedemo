# ReqRes API — manual test cases

| ID | Title | Method | Endpoint | Expected | Priority | Automated |
|----|-------|--------|----------|----------|----------|-------------|
| TC-API-001 | List users page 1 | GET | /users?page=1 | 200, page=1, data not empty | P1 | Yes |
| TC-API-002 | Get user by id | GET | /users/2 | 200, data.id=2 | P1 | Yes |
| TC-API-003 | Create user | POST | /users JSON body | 201, name echoed, id present | P1 | Yes |
| TC-API-004 | Unknown user | GET | /users/9999 | 404 | P2 | Yes |
| TC-API-005 | Invalid JSON body | POST | /users | 400 or 4xx | P3 | No |

Base URL: `https://reqres.in/api`
