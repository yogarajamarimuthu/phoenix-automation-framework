## phoenix-automation-framework

### Framework Name: Phoenix Automation Framework
Core Principles:
Modularity: Separate concerns for better maintainability.
Readability: Use clear and concise coding styles.
Reusability: Design components for repeated use.
Maintainability: Easy to update and extend.
Scalability: Adaptable to growing test suites and application complexity.

### Technology Stack and Purpose:
Java 17: Programming language for the framework logic.
Maven 3.8.4: Build automation tool for dependency management, building, and running tests.
TestNG: Test framework for structuring and executing tests, providing annotations, reporting, and parallel execution capabilities.
Extent Reports: Rich and customizable HTML reporting for test execution results.
Log4j: Logging framework for recording application and test execution information.
Cucumber: Behavior-Driven Development (BDD) framework for writing executable specifications in plain language (Gherkin).
Serenity BDD: Extends Cucumber and Selenium, providing enhanced reporting, step libraries, and Screenplay pattern support (we'll leverage some of its features for better reporting and step organization).
Data-Driven BDD: Approach to run the same test scenario with different sets of data, typically managed in external files.
Selenium WebDriver: Library for interacting with web browsers.
WebDriverManager: Tool to automatically manage browser driver executables.
Page Object Model (POM): Design pattern to represent web pages as classes, encapsulating UI elements and interactions.
Page Factory: Selenium feature to initialize Page Object elements using annotations.


Framework Structure (Maven Project):
phoenix-automation-framework/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── phoenix/
│   │               ├── api/
│   │               │   ├── actions/
│   │               │   │   └── ... (API interaction classes)
│   │               │   ├── models/
│   │               │   │   └── ... (API request/response models)
│   │               │   └── utils/
│   │               │       └── ... (API specific utilities)
│   │               ├── base/
│   │               │   ├── BaseAPI.java
│   │               │   └── BaseWeb.java
│   │               ├── config/
│   │               │   ├── ConfigurationManager.java
│   │               │   └── FrameworkConfig.properties
│   │               ├── pages/
│   │               │   └── ... (Page Object classes)
│   │               ├── utils/
│   │               │   ├── DataReader.java
│   │               │   ├── ExcelReader.java
│   │               │   ├── JsonReader.java
│   │               │   ├── LoggerUtil.java
│   │               │   └── TestUtils.java
│   │               └── webdriver/
│   │                   ├── DriverManager.java
│   │                   └── WebDriverFactory.java
│   └── test/
│       ├── java/
│       │   └── com/
│       │       └── phoenix/
│       │           ├── api/
│   │           │   └── stepdefinitions/
│   │           │       └── ... (API Cucumber Step Definitions)
│   │           │   └── tests/
│   │           │       └── ... (API TestNG Runner classes - optional with Cucumber)
│   │           └── web/
│   │               ├── stepdefinitions/
│   │               │   └── ... (Web Cucumber Step Definitions)
│   │               └── runners/
│   │                   └── WebTestRunner.java (Cucumber Test Runner)
│   │               └── tests/
│   │                   └── ... (Web TestNG Runner classes - optional with Cucumber)
│       └── resources/
│           ├── features/
│           │   ├── api/
│   │           │   └── ... (.feature files for API tests)
│   │           └── web/
│   │               └── ... (.feature files for web tests)
│           ├── log4j2.xml
│           └── testdata/
│               ├── api/
│               │   └── ... (Data files for API tests - JSON, CSV, etc.)
│               └── web/
│                   └── ... (Data files for web tests - Excel, CSV, etc.)
└── README.md


    Configuration Management - FrameworkConfig.properties, ConfigurationManager.java:
    DataReader.java - This class can act as a facade to get data from different sources.
    TestUtils.java - This class can hold common utility methods.

## API Testing (com.phoenix.api):
    com.phoenix.api.actions: Classes to interact with API endpoints using REST Assured.
    com.phoenix.api.models: POJOs (Plain Old Java Objects) to represent request and response data structures.
    com.phoenix.api.utils: Utility methods specific to API testing (e.g., authentication helpers, response parsing).



## TestNG (Optional - for Web and API):
    You can use TestNG directly for more traditional test classes, especially for API testing or supplementing Cucumber.
    Create TestNG classes in src/test/java/com/phoenix/api/tests or src/test/java/com/phoenix/web/tests.
    Example TestNG class:

## Extent Reports:
    While Serenity provides excellent reporting, you can integrate Extent Reports for more customization or if you're using TestNG directly.
    Add listeners or utilize Extent's API to generate reports. Serenity will handle this for Cucumber.

## Data-Driven Testing:
    Use the com.phoenix.utils.DataReader class to read test data from Excel, JSON, or other sources.
    For Cucumber, use Scenario Outlines and Examples in your feature files.
    For TestNG, use Data Providers.

## Serenity BDD:
    Serenity enhances reporting and provides a structured approach.
    It works well with Cucumber.
    You can use Serenity's Screenplay pattern for more advanced test design (optional, but recommended for larger projects).
    Serenity automatically generates reports, so you don't need to do much manual setup.

## Key Improvements and Considerations:
    Centralized Driver Management: The DriverManager class ensures that WebDriver instances are managed consistently, preventing common issues with driver setup and teardown.
    Configuration Management: The ConfigurationManager provides a centralized way to manage framework configurations, making it easy to change settings without modifying code.
    Logging: Log4j is integrated for comprehensive logging, which is essential for debugging and monitoring test execution.
    Modular Design: The framework is divided into logical packages, promoting reusability and maintainability.
    Data-Driven Testing: The DataReader utility simplifies data-driven testing, allowing you to easily read test data from external files.
    Page Object Model: The POM design pattern is used for web testing, making the code more organized and easier to maintain.
    Hybrid Approach: The framework supports both Cucumber (BDD) and TestNG, giving you flexibility in how you write and execute your tests.
    Reporting: Serenity and Extent Reports provide detailed and informative test reports.
    API and Web Testing: The framework is designed to handle both web and API testing.
    Scalability: The framework is designed to be scalable, so it can handle a growing number of tests and increasing complexity.

## How to Get Started:
    Set up your development environment: Install Java 17, Maven 3.8.4, and an IDE (e.g., IntelliJ IDEA, Eclipse).
    Create a new Maven project: Use the pom.xml provided above.
    Create the directory structure: Create the packages and classes as shown in the framework structure.
    Implement the core components: Start with the ConfigurationManager, LoggerUtil, and DriverManager.
    Implement Page Objects: Create Page Object classes for the web application you are testing.
    Write your tests: Create Cucumber feature files and step definitions, or write TestNG test classes.
    Run your tests: Use Maven to build and run your tests (e.g., mvn clean test or mvn clean verify).
    Review the reports: Check the Extent Reports or Serenity reports for the test results.
