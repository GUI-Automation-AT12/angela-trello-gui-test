@List
Feature: Create a list

  @DeleteList
  Scenario: Create a list
    Given I log in to Trello with valid credentials
    When I navigate to Board page
    And I create a list with the following form data
      | title | title of list UNIQUE_ID|
    Then the list should be created