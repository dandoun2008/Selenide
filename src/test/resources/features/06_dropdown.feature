@dropdown
Feature: dropdown
  Scenario: TC01_selecting birth year
    Given I navigate to "https://testcenter.techproeducation.com/index.php?page=dropdown"
    And I select the year as 1980
    And I select the month as "November"
    And I select the day as 28
    And I get the list of US states and click on "Pennsylvania"
    And I hold the browser open

