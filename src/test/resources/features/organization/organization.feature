Feature: Create an organization
  In order to create a new organization in Trello

  Background: Sets authentication
    Given I log in to Trello with Editable user credentials

  @DeleteTeam @Functional
  Scenario: Create a new team without members
    When I select create team button
    And I define the following information for the team
      | name        | Team Test UNIQUE_ID |
      | type        | Education           |
      | description | Team description    |
    And I create a team without members
    Then I should see team name in Teams page
    And the team name should be displayed on board menu
    When I navigate to Home page
    Then the team name should be displayed on left menu

  @DeleteTeam @Functional
  Scenario: Create a new team with a member
    When I select create team button
    And I define the following information for the team
      | name        | Team Test UNIQUE_ID    |
      | type        | Education              |
      | description | Team description       |
    And I create the a team with the following members
      | trello.proy1234@gmail.com |
    Then I should see team name in Teams page
    And the team name should be displayed on board menu
    When I navigate to Home page
    Then the team name should be displayed on left menu