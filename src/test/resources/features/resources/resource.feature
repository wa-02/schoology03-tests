Feature: Resources

  @deleteResource @softAssert
  Scenario: Create Question Bank Resource with questions
    Given I log in as "Instructor01" user
    When I navigate to "Resources"
      And I create a "Question Bank" resource with:
        | Name                     | Test Question Bank   |
        | Description              | Resource Description |
        | Enable Question Tracking | Yes                  |
      And I open the "Test Question Bank" question bank resource
      And I add a "True/False" question with:
      | Title          | Test Question 1 |
      | Correct Answer | False           |
      And I add a "Multiple Choice" question with:
        | Title           | Select Primary Colors |
        | Choices         | Red, Blue, Orange     |
        | Correct Answers | Red, Blue             |
    Then I should see the "Test Question Bank" "Question Bank" resource with questions:
      | Title                 | Question Type   |
      | Test Question 1       | True/False      |
      | Select Primary Colors | Multiple Choice |

  @deleteResource @softAssert
  Scenario: Add questions from question bank to Test/Quiz resource
    Given I log in as "Instructor01" user
      And I navigate to "Resources"
      And I create a "Question Bank" resource with:
        | Name                     | Networking Questions |
        | Description              | Resource Description |
      And I open the "Networking Questions" question bank resource
      And I add a "Short-Answer/Essay Question" question with:
        | Title           | What is a subnet mask? |
        | Character Limit | 300                    |
      And I add a "Ordering" question with:
        | Title | Order the layers of the OSI Model                                           |
        | Items | Physical, Data Link, Network, Transport, Session, Presentation, Application |
    When I navigate to "Resources"
    And I create a "Test/Quiz" resource with:
      | Name       | Networking Exam |
      | Max points | 70              |
    And I add the questions from "Networking Questions" question bank
      | Order the layers of the OSI Model |
      | What is a subnet mask?            |
    Then I should see the "Networking Exam" "Test/Quiz" resource with questions:
      | Title                             | Question Type               |
      | What is a subnet mask?            | Short-Answer/Essay Question |
      | Order the layers of the OSI Model | Ordering                    |

  @deleteCourse @deleteResource @softAssert
  Scenario: Import resource to course from resources
    Given I log in as "Instructor01" user
      And I navigate to "Resources"
      And I create a "Assignment" resource with:
        | Name        | Math Homework          |
        | Description | Assignment Description |
      And I create a course with:
        | name    | Example Course |
        | section | New Section    |
        | area    | Mathematics    |
        | level   | Undergraduate  |
    When I import "Math Homework" from resources
    Then I should see the "Math Homework" - "Assignment Description" resource in "Example Course: New Section" course
