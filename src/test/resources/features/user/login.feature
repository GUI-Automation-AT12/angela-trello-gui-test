Feature: Login in Trello
  In order to login in Trello

  @Functional
  Scenario: Log in with Editable user credentials
    Given I'm in Login page
    When I log in to Trello with Editable user credentials
    Then the Home Page should be displayed

  Scenario: Log in with empty credentials
    Given I'm in Login page
    #When  I set user and password with empty fields
    #Then  the Login Page should be displayed