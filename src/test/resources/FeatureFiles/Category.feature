Feature: Category

  Scenario Outline: Add Category
    Given I enter skillrary login page
    And I login to the skillrary
    When I click on courses tab and choose category
    And I create a new category with <name>
    Then New category should be added to the category list
    When I delete the newly added category
    Then Newly added category should be removed from the list
    And I logout of skillrary

    Examples: 
      | name       |
      | RPA        |
      | MERN Stack |
