Feature: Create an organization
  In order to create a new organization in Trello

  Background: Sets authentication
    Given I log in to Trello with Editable user credentials

  @DeleteTeam @Functional
  Scenario: Create a new team without members
    When I select create team button
    And I create a team with the following information
      | name        | Team Test UNIQUE_ID |
      | type        | Education           |
      | description | Team description    |
    Then I should see team name in Teams page