package com.phoenix.pages;

import com.phoenix.base.BaseWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.phoenix.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;

public class HomePage extends BaseWeb {
    private static final Logger log = LoggerUtil.getLogger(HomePage.class);

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "username")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginButton() {
        log.info("Clicking on login button");
        loginButton.click();
    }

    public void enterUsername(String username) {
        log.info("Entering username: " + username);
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        log.info("Entering password: " + password);
        passwordField.sendKeys(password);
    }

    public void clickSubmitButton() {
        log.info("Clicking on submit button");
        submitButton.click();
    }

    public void login(String username, String password) {
        clickLoginButton();
        enterUsername(username);
        enterPassword(password);
        clickSubmitButton();
    }
}