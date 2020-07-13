Feature: Courses

#  Background: Log in Schoology
#    When I log in the page as "Instructor" user
#    Then I should be logged as "jorge orellana"

  Scenario: Create Course
    Given I log in as "Instructor01" user
    When I create a course with:
      | name    | My namex    |
      | section | My Section |
      | area    | Science    |
      | level   | Graduate   |
    And I should see "My namex: My Section" in the page title
    Then I should see "My namex" in the submenu
    And I should see "My namex" in My Courses tab



