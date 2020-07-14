Feature: User Profile

  @resetNotifications @softAssert
  Scenario: Edit Accounting Settings
    Given I log in as "Instructor01" user
    When I navigate to "Settings" in the Profile Menu
    And I navigate to "Notifications" in the Account Menu
    Then I should see the following notifications:
      | section       | notification           | option |
      | Academic      | Course content created | Off    |
      | Public Groups | Comments on my posts   | Off    |
    And I edit the following notifications:
      | section       | notification           | option |
      | Academic      | Course content created | On     |
      | Public Groups | Comments on my posts   | On     |
    Then I should see the "Your settings have been saved." message
    And I should see the following notifications:
      | section       | notification           | option |
      | Academic      | Course content created | On     |
      | Public Groups | Comments on my posts   | On     |

  @resetUserPrivacySetting @softAssert
  Scenario: Edit Privacy Settings
    Given I log in as "Instructor01" user
    When I navigate to "Settings" in the Profile Menu
    And I navigate to "Privacy" in the Account Menu
    When I edit the following user privacy settings:
      | user privacy setting | setting     |
      | Groups               | connections |
      | Messaging            | no one      |
    Then I should see the "Your changes have been saved." message
    And I should see the following user privacy settings selected:
      | user privacy setting | setting     |
      | Groups               | connections |
      | Messaging            | no one      |

  @softAssert
  Scenario: Edit Account Settings
    Given I log in as "Instructor01" user
    When I navigate to "Settings" in the Profile Menu
    And I edit the following information in the Accounting Settings:
      | title       | Ms.     |
      | middle name | sandra  |
      | username    | sandra1 |
    Then I should see the "Your changes have been saved." message