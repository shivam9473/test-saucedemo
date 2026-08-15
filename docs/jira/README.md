# Jira — defect tracking for this portfolio

Use **Jira Cloud** (free tier) as the system of record for bugs found during manual and automated runs. Markdown files here are backups for reviewers who do not have board access.

## Quick setup (free Jira Cloud)

1. Go to [https://www.atlassian.com/software/jira/free](https://www.atlassian.com/software/jira/free) and create a site (e.g. `yourname.atlassian.net`).
2. Create a **Software** project with key **QA** (name: "QA Portfolio" or similar).
3. Use the default **Bug** issue type.
4. Recommended fields to fill on every bug:
   - **Summary** — one line, user-visible problem
   - **Description** — steps, expected, actual
   - **Environment** — browser/OS or "API / reqres.in"
   - **Priority** — Blocker / High / Medium / Low
   - **Labels** — `saucedemo`, `reqres`, `automation`, `regression`
   - **Fix version** — optional sprint name

## Workflow

```text
Open → In Progress → Ready for QA → Done
              ↘ Won't Fix / Duplicate
```

1. Log defect during exploratory or failed test run.
2. Link to test case ID (e.g. TC-CHECKOUT-002) in description.
3. After fix (or if demo-site limitation), move to **Done** or **Won't Fix** with reason.

## Linking tests to Jira

| Activity | Jira artefact |
|----------|----------------|
| Manual run | Test execution comment on story, or sub-task |
| Automation failure | Paste CI build URL + screenshot path in bug |
| Traceability | Mention `REQ-UI-xx` from `docs/traceability-matrix.md` |

Optional: install **Xray** or **Zephyr** trial if you want formal test management inside Jira. For portfolio purposes, Bugs + markdown test cases are enough.

## Sample defects in this repo

| Key | File | Status |
|-----|------|--------|
| QA-101 | `sample-defects/QA-101-checkout-validation.md` | Won't Fix (demo site) |
| QA-102 | `sample-defects/QA-102-cart-badge-delay.md` | Done |
| QA-103 | `sample-defects/QA-103-reqres-404-body.md` | Open |

Replace keys with your real Jira keys after you create the board.

## Bug report template

Copy into Jira **Description**:

```text
Steps to reproduce:
1.
2.

Expected:
Actual:

Environment:
Browser / OS or API endpoint:

Test case ID:
Screenshots / logs:
```

## CI integration note

This repo does not push to Jira automatically. After a failed GitHub Actions run, create a Jira bug manually and attach the workflow run link. That mirrors how many teams start before wiring Jira REST API or Xray importers.
