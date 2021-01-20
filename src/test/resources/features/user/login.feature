@Login
Feature: Login in Trello
  In order to login in Trello

  @Functional
  Scenario: Log in with Editable user credentials
    Given I'm in Login page
    When I log in to Trello with Editable user credentials
    Then the Home Page should be displayed
