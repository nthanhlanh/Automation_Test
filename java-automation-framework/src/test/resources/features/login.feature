@ui @login
Feature: Login to Jira feature

  Scenario: User logs in successfully
    Given the user is on the login page
    When user enters username "lanh.nguyen@evizi.com"
    And the user clicks Continue
    And the user enters password "ABC@1991"
    And the user clicks Login
    Then the "For you" title is displayed on the dashboard

