@ui @createTask
Feature: Task Management in Jira

  Scenario: The User creates a task
    Given The user is on the dashboard
    When The user clicks Create Task
    And The user fills task details
    And The user submits the task
    Then The task is created successfully