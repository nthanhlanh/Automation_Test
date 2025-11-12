@ui @login
Feature: Login feature
  Scenario: User logs in successfully
    Given user opens the login page
    When user enters valid credentials
    Then user should see the dashboard
