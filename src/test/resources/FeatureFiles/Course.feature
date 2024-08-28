Feature: Course

  Scenario: Add Course
    Given I enter skillrary login page
    And I login to the skillrary
    When I click on courses tab and choose course list
    And I create a new course
      | Cucumber                                                                    |
      | Automation                                                                  |
      |                                                                        1500 |
      | C:\\Users\\hp\\OneDrive\\Pictures\\Screenshots 1\\Screenshot (2) - Copy.png |
      | Automation Testing Tool                                                     |
    Then New course should be added to the course list
    When I delete the newly added course
    Then Newly added course should be removed from the list
    And I logout of skillrary
