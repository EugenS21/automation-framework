Feature: Home page validation

  Background:
    Given I am on home page

  Scenario: Validate navigation to home page
    When I check header panel content
    And I check left side menu bar
    Then I should see the following items:
      | Solutions  |
      | About Us   |
      | Services   |
      | Products   |
      | Locations  |
      | Admin Page |
