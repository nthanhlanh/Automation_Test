@ui @jiraProject @requiresLogin
Feature: Manage Jira projects
  In order to manage Jira projects efficiently
  As a Jira user
  I want to be able to create and delete projects

  Scenario: User creates a new team-managed Scrum project
    Given I am on the Jira projects page
    When I click on Create project button
    And I click on Software development menu item
    And I click on Scrum card
    And I click on Use template button
    And I click on Select a team managed project button
    And I enter into the Name field
    And I enter into the Key field
    And I click on Create project button
    Then I should see the new project created successfully

  Scenario: Move and delete project to trash
    Given Open Jira projects page
    When Click on the Move to Trash menu item
    And Click on Move button
    And Open Jira trash page
    And Click on More Actions button of the deleted project
    And Click on Delete now menu item
    And Click on Delete button
    Then the project should be permanently deleted
