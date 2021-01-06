@Board
Feature: Create a board
  
  Background: Sets authentication
    Given I log in to Trello with Editable user credentials

  @Functional @CreateOrganization @DeleteOrganization @DeleteBoard
  Scenario: Create a private board
    When I navigate to Home page
    And I create a board with the following form data
      | name    | boardName    |
      | team    | teamTestName |
      | privacy | private      |
    Then the board name should be displayed on board page
    And the board name should be displayed on board menu

  @Functional @CreateOrganization @DeleteOrganization @DeleteBoard
  Scenario: Create a public board
    When I navigate to Home page
    And I create a board with the following form data
      | name    | boardName    |
      | team    | teamTestName |
      | privacy | public       |
    Then the board name should be displayed on board page
    And the board name should be displayed on board menu

  @Functional @CreateBoard
  Scenario: Delete a board
    When I navigate to specific board page
    And I delete the board
    Then a message should be displayed