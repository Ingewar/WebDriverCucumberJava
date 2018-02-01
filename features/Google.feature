Feature: Test feature to check working setup

  Scenario: User should be able to open Google start page
    When I open Google start page
    Then I should see "Google" page title
      And Google logo should be displayed