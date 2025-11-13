@ui @login
Feature: Login to Jira feature

  Scenario: User logs in successfully
    Given The user is on the login page
    When The user enters username "lanh.nguyen@evizi.com"
    And The user clicks Continue
    And The user enters password "ABC@1991"
    And The user clicks Login
    Then "For you" title is displayed

