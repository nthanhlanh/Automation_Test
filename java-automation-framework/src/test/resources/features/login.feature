@ui @login
Feature: Login to Jira feature

  Scenario: The user logs in successfully
    Given The user is on the login page
    When The user enters username
    And The user clicks Continue
    And The user enters password
    And The user clicks Login
    Then The homepage is displayed

