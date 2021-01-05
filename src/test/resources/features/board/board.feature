@Board
Feature: Create a board
  
  Background: Sets authentication
    Given I log in to Trello with Editable user credentials

  @Functional @CreateOrganization @DeleteOrganization @DeleteBoard
  Scenario: Create a private board
    When I navigate to Board page
    And I create a board with the following form data
      | name    | boardName |
      | team    | testTeam  |
      | privacy | private   |
    Then the board name should be displayed

  @Functional @CreateOrganization @DeleteOrganization @DeleteBoard
  Scenario: Create a public board
    When I navigate to Board page
    And I create a board with the following form data
      | name    | boardName |
      | team    | testTeam  |
      | privacy | public    |
    Then the board name should be displayed

  @Functional @CreateBoard
  Scenario: Delete a board
    When I navigate to specific board page
    And I delete the board
    Then a message should be displayed