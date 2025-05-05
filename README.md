# Description

Project using Java 1.8, Cucumber, and Selenium to test a checkout flow in the Swag Labs page.

## Dependencies

- The project uses Java 1.8, so it's necessary to have the JRE environment configured.
- The project runs with Apache Maven, so it's necessary to have Apache Maven configured. 
- The project needs a ChromeDriver compatible with your browser's version; the ChromeDriver in this project is 135.0.7049.114.

## Code

This project is built in the Page Object Pattern using a cucumber-archetype.
- CucumberSelenium
- -  RunCucumberTest.Java
- Pages
- - CheckoutPage
  - LoginPage
  - ProductsPage
- Steps
- - StepsDefinitions
- Resources
- - SwagLabs.feature

## Run tests

```bash
mvn test
```

## Reports

A cucumber-reports.html will be generated at target/
