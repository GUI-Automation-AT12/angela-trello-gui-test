@Card
Feature: Create a card
  Background: Sets authentication
    Given I log in to Trello with Editable user credentials

  @CreateBoard @CreateList @DeleteABoard @Functional
  Scenario: Create a card
    When I navigate to specific board page
    And I create a card with the following form data
      | name | card_name_UNIQUE_ID |
    Then the card should be created on list

  @CreateBoard @CreateList @CreateCard @DeleteABoard @Functional
  Scenario: Drag and drop a card between lists
    When I navigate to specific board page
    And I drag and drop a card between Doing lists
    Then the card should be displayed on Doing list
    And the card shouldn't be displayed on origin list