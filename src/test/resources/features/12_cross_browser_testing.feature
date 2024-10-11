Feature: cross browser
#   For cross browser testing, we should assign the browser before opening the browser
#   Otherwise, Selenide will open the browser on Chrome

  @headless
  Scenario: TC01 Running on headless
    Given I open the "headless" browser
    And I navigate to "https://www.techproeducation.com"
    And I capture the screenshot of the page

  @firefox
  Scenario: TC02 Running on firefox
    Given I open the "firefox" browser
    And I navigate to "https://www.amazon.com"
    And I capture the screenshot of the page

  @safari
  Scenario: TC03 Running on safari
    Given I open the "safari" browser
    And I navigate to "https://www.amazon.com"
    And I capture the screenshot of the page

  @edge
  Scenario: TC04 Running on edge
    Given I open the "edge" browser
    And I navigate to "https://www.amazon.com"
    And I capture the screenshot of the page

  @chrome
  Scenario: TC05 Running on chrome
    Given I open the "chrome" browser
    And I navigate to "https://www.apple.com"
    And I capture the screenshot of the page