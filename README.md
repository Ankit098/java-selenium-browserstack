# Java-selenium-browserstack

---

This branch contains TestNG samples with selenium-4.

![BrowserStack Logo](https://d98b8t1nnulk5.cloudfront.net/production/images/layout/logo-header.png?1469004780)

## Using Maven

### Setup

- Clone the repo
- Install dependencies `mvn compile`
- Update `*.conf.json` files inside the `src/test/resources/conf` directory with your [BrowserStack Username and Access Key](https://www.browserstack.com/accounts/settings)

### Running your tests

- To run a single test, run `mvn test -P single`
- To run local tests, run `mvn test -P local`
- To run test with execute script `POST`, run `mvn test -P executescript`
