@api @user
Feature: User API
  Scenario: Get list of users
    Given the user API is running
    When I send a GET request to "/api/users"
    Then the response status should be 200
    And the response should contain 3 users
    And the first user should have name "Alice"

  Scenario Outline: Get user by ID
    Given the user API is running
    When I send a GET request to "/api/users/<id>"
    Then the response status should be 200
    And the response should contain user with id "<id>"
    And the response should have correct name "<name>" and email "<email>"

    Examples:
      | id | name    | email             |
      | 1  | User 1  | user1@example.com |
      | 2  | User 2  | user2@example.com |
      | 3  | User 3  | user3@example.com |
