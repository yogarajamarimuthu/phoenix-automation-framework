package com.phoenix.api.actions;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;
import com.phoenix.utils.LoggerUtil;
import org.apache.logging.log4j.Logger;
import static io.restassured.RestAssured.given;

public class UserAPI {
    private static final Logger log = LoggerUtil.getLogger(UserAPI.class);

    private static final String USERS_ENDPOINT = "/users";

    public Response getUsers() {
        log.info("Getting all users from " + USERS_ENDPOINT);
        return given()
                .when()
                .get(USERS_ENDPOINT);
    }

    public Response getUser(int userId) {
        log.info("Getting user with ID: " + userId + " from " + USERS_ENDPOINT + "/" + userId);
        return given()
                .when()
                .get(USERS_ENDPOINT + "/" + userId);
    }

    public Response createUser(String requestBody) {
        log.info("Creating user with request body: " + requestBody);
        return given()
                .contentType("application/json")
                .body(requestBody)
                .post(USERS_ENDPOINT);
    }
    //Add more API methods
}
