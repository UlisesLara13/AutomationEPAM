# Selenium WebDriver Test Automation Framework - SauceDemo

This project implements an automated testing framework for the [SauceDemo](https://www.saucedemo.com/) web application using Selenium WebDriver, BDD approach with Cucumber, and parallel execution across multiple browsers.

### Requirements

UC-1 Test Login form with empty credentials:
Type any credentials into "Username" and "Password" fields.
Clear the inputs.
Hit the "Login" button.
Check the error messages: "Username is required".

UC-2 Test Login form with credentials by passing Username:
Type any credentials in username.
Enter password.
Clear the "Password" input.
Hit the "Login" button.
Check the error messages: "Password is required".

UC-3 Test Login form with credentials by passing Username & Password:
Type credentials in username which are under Accepted username are sections.
Enter password as secret sauce.
Click on Login and validate the title “Swag Labs” in the dashboard.

Provide parallel execution, add logging for tests and use Data Provider to parametrize tests. Make sure that all tasks are supported by these 3 conditions: UC-1; UC-2; UC-3.

Please, add task description as README.md into your solution!

To perform the task use the various of additional options:
Test Automation tool: Selenium WebDriver;
Project Builder: Maven;
Browsers: 1) Edge; 2) Chrome;
Locators: XPath;
Test Runner: JUnit;
[Optional] Patterns: 1) Abstract Factory; 2) Adapter; 3) Decorator;
[Optional] Test automation approach: BDD;
Assertions: Hamcrest;
[Optional] Loggers: Log4j.

## 🏗️ Project Architecture

### Directory Structure
```
FinalTask/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── driver/
│   │   │   │   └── DriverSingleton.java          # Singleton + ThreadLocal pattern
│   │   │   ├── model/
│   │   │   │   └── User.java                     # User model
│   │   │   ├── page/
│   │   │   │   ├── AbstractPage.java             # Abstract Factory pattern
│   │   │   │   ├── LoginPage.java                # Page Object - Login page
│   │   │   │   └── MainPage.java                 # Page Object - Main dashboard
│   │   │   └── service/
│   │   │       └── TestDataReader.java           # Properties reader
│   │   └── resources/
│   │       └── url.properties                   # Urls data configuration
│   └── test/
│       ├── java/
│       │   ├── runners/
│       │   │   └── CucumberTestRunner.java       # JUnit Platform Suite runner
│       │   ├── steps/
│       │   │   └── LoginSteps.java               # Cucumber Step Definitions
│       │   └── test/
│       │       └── Hooks.java                    # Before/After hooks
│       └── resources/
│           ├── features/
│           │   └── login.feature                 # BDD scenarios (Gherkin)
│           ├── cucumber.properties               # Cucumber configuration
│           ├── junit-platform.properties         # Junit configuration
│           └── log4j2.xml                        # Logger configuration
├── pom.xml                                        # Maven configuration
└── README.md                                      # This file
```

# EJECUCIÓN:

## Chrome (browser por defecto)
mvn clean test

## Chrome
mvn clean test -Dbrowser=chrome

## Edge
mvn clean test -Dbrowser=edge

# 👨‍💻 Author

**Student:** Ulises Lara  
**Program:** EPAM Automation Training  
**Project:** Final Task - Selenium WebDriver Automation  
**Date:** November 202

