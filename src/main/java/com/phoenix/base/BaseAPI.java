package com.phoenix.base;

import com.phoenix.config.ConfigurationManager;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;

public class BaseAPI {

    protected String baseUrl;

    @BeforeSuite
    public void apiSetup() {
        baseUrl = ConfigurationManager.getInstance().getApiUrl();
        RestAssured.baseURI = baseUrl;
        //  Add common API configurations here (e.g., headers, authentication)
    }
}
