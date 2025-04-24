package com.phoenix.web.stepdefinitions;

import com.phoenix.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import com.phoenix.webdriver.DriverManager;
import org.testng.Assert;
import com.phoenix.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

public class LoginSteps {
    private static final Logger log = LoggerUtil.getLogger(LoginSteps.class);
    private WebDriver driver;
    private HomePage homePage;

    public LoginSteps() {
        this.driver = DriverManager.getDriver();
        this.homePage = new HomePage(driver);
    }

    @Given("I am on the home page")
    public void iAmOnTheHomePage() {
        log.info("Navigating to the home page");
        driver.get("https://www.saucedemo.com/"); // Or read from config
    }

    @When("I enter valid username {string} and password {string}")
    public void iEnterValidUsernameAndPassword(String username, String password) {
        log.info("Entering username and password");
        homePage.enterUsername(username);
        homePage.enterPassword(password);
    }

    @When("I enter valid username {string} and invalid password {string}")
    public void iEnterValidUsernameAndInvalidPassword(String username, String password) {
        log.info("Entering username and password");
        homePage.enterUsername(username);
        homePage.enterPassword(password);
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        log.info("Verifying successful login");
        //  Add assertion to check for successful login (e.g., check for a welcome message)
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"), "Login failed");
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeErrorMessage(String errorMessage) {
        log.info("Verifying error message: " + errorMessage);
        // Add assertion to check for the error message
    }
}