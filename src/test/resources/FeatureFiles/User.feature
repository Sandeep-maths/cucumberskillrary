
Feature: User

 
  Scenario: Add User
    Given I enter skillrary login page
    And I login to the skillrary
    When I click on users
    And I create new user
    Then New user should be added to the user list
    When I delete newly added user
    Then User should be deleted from the users list
    And I logout of skillrary

  