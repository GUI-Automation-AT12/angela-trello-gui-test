Feature: Login in Trello
  In order to login in Trello

  @Functional
  Scenario: Log in with valid credentials
    Given I'm in Login page
    When I set user and password
    Then the Home Page should be displayed

  Scenario: Log in with invalid credentials
    #Given I'm in Login page
    #When  I set user and password with empty fields
    #Then  the Login Page should be displayed