@assertions
  Feature: assrtyions
    Scenario: TC01_verify_title
      Given I navigate to "https://www.techproeducation.com"
      And I get the title of the current page and verify if it contains "TechPro Education"
