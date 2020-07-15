Feature: Delete Course

  Background: Create Course
    Given I log in as "Instructor01" user
    And I create a course with:
      | name    | My name    |
      | section | My Section |
      | area    | Science    |
      | level   | Graduate   |
    And I should see "My name: My Section" in the page title

  Scenario: Delete Course
    When I delete the course "My name"
    Then I should see the "Section My Section has been deleted." message
