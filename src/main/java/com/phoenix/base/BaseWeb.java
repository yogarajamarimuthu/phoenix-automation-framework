package com.phoenix.base;

import com.phoenix.config.ConfigurationManager;
import com.phoenix.webdriver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseWeb {

    protected WebDriver driver;
    protected String baseUrl;
    protected long implicitWait;
    protected long explicitWait;

    @BeforeSuite
    public void beforeSuite() {
        //  Perform any global setup here, before all tests
    }

    @BeforeMethod
    @Parameters("browser") // You can keep this, but the driver is now managed centrally
    public void setup(String browser) {
        // No longer takes browser as a parameter, reads from config
        baseUrl = ConfigurationManager.getInstance().getBaseUrl();
        implicitWait = ConfigurationManager.getInstance().getImplicitWait();
        explicitWait = ConfigurationManager.getInstance().getExplicitWait();

        driver = DriverManager.getDriver(); // Get driver from DriverManager
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver(); // Use the DriverManager to quit
    }
}
