@iframe
Feature: iframe
  Scenario: TC01_frame
    Given I navigate to "https://testcenter.techproeducation.com/index.php?page=iframe"
    And I verify the page header contains "iframe"
    And I switch to frame 1
    And I click on Back to TechProEducation.com
    And I hold the browser open
    When I switch to window 2
    And I wait for 5 seconds
    Then I get the URL of the page and verify it contains "techproeducation"
    When I switch to window 1
    And I wait for 5 seconds



