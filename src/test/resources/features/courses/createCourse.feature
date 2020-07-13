Feature: Courses

  Scenario: Create Course
    Given I log in as "Instructor01" user
    When I create a course with:
      | name    | My name    |
      | section | My Section |
      | area    | Science    |
      | level   | Graduate   |
    And I should see "My name: My Section" in the page title
    Then I should see "My name" in the submenu
    And I should see "My name" in My Courses tab



