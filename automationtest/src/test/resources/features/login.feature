@ui @login
Feature: Login feature
  Scenario: User logs in successfully
    Given user opens the login page
    When user logs in with user standard_user/secret_sauce
    Then user should see the dashboard
