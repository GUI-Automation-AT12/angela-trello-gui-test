Feature: Login into Trello

  Scenario: Log in with valid credentials
    Given I'm in Login page
    When I set user and password
    Then the Home Page should be displayed