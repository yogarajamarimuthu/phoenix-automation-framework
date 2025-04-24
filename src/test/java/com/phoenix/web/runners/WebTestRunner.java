package com.phoenix.web.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/web", // Path to your feature files
        glue = "com.phoenix.web.stepdefinitions",    // Package containing step definitions
        plugin = {
                "pretty",
                "html:target/cucumber-reports/web.html",
                "json:target/cucumber-reports/web.json",
                "rerun:target/failed_web_tests.txt"
        }
)
@Test
public class WebTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
