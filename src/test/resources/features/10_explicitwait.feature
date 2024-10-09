@explicit_wait
Feature: explicit wait
  Scenario: TC01_explicit wait
    Given I navigate to "https://the-internet.herokuapp.com/dynamic_loading/1"
    And I set Configuration.screenshots to false
    And I click on start button
  # And I wait for 10 seconds (this step solves the problem but it is hard coding)
    Then I verify the Hello World! text is displayed

