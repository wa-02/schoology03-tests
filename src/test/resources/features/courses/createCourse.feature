Feature: Courses

  @deleteCourseFromMyList @softAssert
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

  @deleteCourseFromMyList @softAssert
  Scenario: Join a my own Course
    Given I log in as "Instructor01" user
    When I create a course with:
      | name    | My name    |
      | section | My Section |
      | area    | Science    |
      | level   | Graduate   |
    And I should see the Access Code
    When I join a Course
    Then I should see the "You cannot enroll in a course you are already a member of." message

  @deleteCourseFromMyList @softAssert
  Scenario: Add Folder
    Given I log in as "Instructor01" user
    When I create a course with:
      | name    | My name    |
      | section | My Section |
      | area    | Science    |
      | level   | Graduate   |
    And I should see "My name: My Section" in the page title
    When I add a folder with:
      | title        | My Folder      |
      | color        | red            |
      | Availability | Unpublished    |
    Then I should see the folder "My Folder"
