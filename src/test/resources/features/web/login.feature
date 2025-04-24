Feature: User Login
  As a user, I want to be able to log in to the website
  Scenario: Successful login
    Given I am on the home page
    When I enter valid username "standard_user" and password "secret_sauce"
    Then I should be logged in
  Scenario: Failed login with invalid password
    Given I am on the home page
    When I enter valid username "standard_user" and invalid password "wrong_password"
    Then I should see an error message "Epic sadface: Username and password do not match any user in this service"
