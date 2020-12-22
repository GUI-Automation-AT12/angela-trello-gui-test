@UserProfile
Feature: Update user's profile

  @ResetUserInformation
  Scenario: Update user's information in Profile and Visibility section
    Given I log in to Trello with Editable User credentials
    When I navigate to Profile and Visibility section
    And I edit my profile with the following information
      | username | new name UNIQUE_ID |
      | body     | new body UNIQUE_ID |
    #Then "Saved" message should be displayed in Profile and Visibility section
    #And My profile information should be updated in Profile and Visibility section
    #And My username should be updated into Top Content
