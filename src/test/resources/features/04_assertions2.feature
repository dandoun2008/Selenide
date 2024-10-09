@assertions2
  Feature: assertions2
    Scenario: TC01_search for tesla
      Given I navigate to "https://www.google.com"
      When I search for "Tesla"
      Then verify page source contains "Tesla"
#     Then verify the result should contain "About" keyword (step fails because result does NOT contain "About")
      Then the first result in the result page should contain "Tesla"