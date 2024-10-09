Feature: screenshots
  @page_screenshot
  Scenario: TC01 entire page screenshot
    Given I navigate to "https://www.techproeducation.com/"
    And I capture the screenshot of the page

  @element_screenshot
  Scenario: TC02 specific element screenshot
    Given I navigate to "https://www.techproeducation.com/"
    And I capture the screenshot of Dialogue icon at the right bottom corner
