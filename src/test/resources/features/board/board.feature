@Board
Feature: Create a board

  @Functional @CreateOrganization @DeleteOrganization @DeleteBoard
  Scenario: Create a private board
    Given I log in to Trello with Editable user credentials
    When I navigate to Board page
    And I create a board with the following form data
      | name    | boardName |
      | team    | testTeam  |
      | privacy | private   |
    Then the board should be created

  @Functional @CreateOrganization @DeleteOrganization @DeleteBoard
  Scenario: Create a public board
    Given I log in to Trello with Editable user credentials
    When I navigate to Board page
    And I create a board with the following form data
      | name    | boardName |
      | team    | testTeam  |
      | privacy | public    |
    Then the board should be created