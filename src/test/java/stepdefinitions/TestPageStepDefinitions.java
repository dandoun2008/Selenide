package stepdefinitions;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TestPage;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestPageStepDefinitions {

    TestPage testPage = new TestPage();

    @Given("I enter username")
    public void i_enter_username() {
        testPage.username.setValue("techproed");
    }

    @Given("I enter password")
    public void i_enter_password() {
        testPage.password.setValue("SuperSecretPassword");
    }

    @Given("I click submit button")
    public void i_click_submit_button() {
        testPage.submitButton.click();
    }

    @And("I click on logout link")
    public void iClickOnLogoutLink() {
        testPage.logOutLink.click();
    }

//    CHECKBOX_RADIOBUTTON
    @Given("I click on {string} if not already selected")
    public void i_click_on_if_not_already_selected(String string) {

        if(string.equals("Checkbox 1") && !testPage.checkbox1.isSelected()){
            testPage.checkbox1.shouldNot(checked);
            testPage.checkbox1.click();
            testPage.checkbox1.shouldBe(checked);
        } else if (string.equals("Checkbox 2") && !testPage.checkbox2.isSelected()) {
            testPage.checkbox2.shouldNot(checked);
            testPage.checkbox2.click();
            testPage.checkbox2.shouldBe(checked);
        } else if (string.equals("Red") && !testPage.red.isSelected()) {
            testPage.red.shouldNot(checked);
            testPage.red.click();
            testPage.red.shouldBe(checked);
        } else if (string.equals("Yellow") && !testPage.yellow.isSelected()) {
            testPage.yellow.shouldNot(checked);
            testPage.yellow.click();
            testPage.yellow.shouldBe(checked);
        } else if (string.equals("Football") && !testPage.football.isSelected()) {
            testPage.football.shouldNot(checked);
            testPage.football.click();
            testPage.football.shouldBe(checked);
        }
    }

//     DROPDOWN
    @Given("I select the year as {int}")
    public void i_select_the_year_as(Integer int1) {
        testPage.year.selectOption(String.valueOf(int1)); //selecting by value
    }
    @Given("I select the month as {string}")
    public void i_select_the_month_as(String string) {
        testPage.month.selectOption(string); //selecting by visible text
    }
    @Given("I select the day as {int}")
    public void i_select_the_day_as(Integer int1) {
        testPage.day.selectOption(int1-1); //selecting by index
    }

    @And("I get the list of US states and click on {string}")
    public void iGetTheListOfUSStatesAndClickOn(String string) {
        for (SelenideElement myState : testPage.allStates) { //string is California
            System.out.println(myState.getText());
            if (myState.getText().equals(string)){
                myState.click();
                break;
            }
        }
    }

//     ALERTS
    @Given("I click on alert prompt")
    public void i_click_on_alert_prompt() {
      testPage.jsPromptButton.click();
    }
    @Given("I enter {string} and click OK")
    public void i_enter_and_click_ok(String string) {
        WebDriverRunner.getWebDriver().switchTo().alert().sendKeys(string);
        WebDriverRunner.getWebDriver().switchTo().alert().accept(); //Clicking OK
    }
    @Then("I verify the result contains {string}")
    public void i_verify_the_result_contains(String string) throws InterruptedException {
        testPage.result.shouldHave(text(string));
    }

//   IFRAMES

    @Given("I verify the page header contains {string}")
    public void i_verify_the_page_header_contains(String string) { //This element is OUTSIDE the iframe
       testPage.pageHeader.shouldHave(text(string));
    }
    @Given("I switch to frame {int}")
    public void i_switch_to_frame(Integer int1) {
        WebDriverRunner.getWebDriver().switchTo().frame(int1-1); //1-1 = 0 (index of iframe)
    }
    @Given("I click on Back to TechProEducation.com")
    public void i_click_on_back_to_tech_pro_education_com() {//This element is INSIDE the iframe
        testPage.backToTechpro.click();
    }

//  SWITCHING TO NEW WINDOW
    @When("I switch to window {int}")
    public void i_switch_to_window(Integer int1) {
        switchTo().window(int1-1);
    }
    @Then("I get the URL of the page and verify it contains {string}")
    public void i_get_the_url_of_the_page_and_verify_it_contains(String string) {
        System.out.println(WebDriverRunner.url());
        Assert.assertTrue(WebDriverRunner.url().contains(string));
    }

//  ACTIONS
    @When("I drag the source in the target")
    public void iDragTheSourceInTheTarget() {
//        actions()
//                .dragAndDrop(testPage.source, testPage.target)
//                .build()
//                .perform(); //REQUIRED te execute the command

//      OR
//          actions().clickAndHold(testPage.source)
//                .moveToElement(testPage.target)
//                .build()
//                .perform();

//      OR we can drag the source and drop it at specific coordinates (exact location in the target)
        actions()
                .dragAndDropBy(testPage.source, 305, 167)
                .build()
                .perform();
    }

    @And("I scroll the page down")
    public void iScrollThePageDown() {
//        actions()
//                .sendKeys(Keys.PAGE_DOWN)
//                .build()
//                .perform();

//      OR we can move the page just a little bit down by ARROW_DOWN
        actions()
                .sendKeys(Keys.ARROW_DOWN)
                .build()
                .perform();
    }
//  EXPLICIT WAIT
    @And("I click on start button")
    public void iClickOnStartButton() {
        testPage.startButton.click();
    }

    @Then("I verify the Hello World! text is displayed")
    public void iVerifyTheHelloWorldTextIsDisplayed() {
    //  Assert.assertEquals("Hello World!", testPage.helloWorld.getText());
    //  The above step fails because there is not enough time for "Hello World!" text to be visible.
    //  To fix the issue, the best option is to add explicit wait for dynamic coding

    //  1. Handle with WebDriverWait Class
    //  WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), Duration.ofSeconds(20));
    //  wait.until(ExpectedConditions.visibilityOf(testPage.helloWorld));

    //  2. Selenide wait
    testPage.helloWorld.should(Condition.visible, Duration.ofSeconds(20));

    //Assertion 1 (junit assertion)
    //Assert.assertEquals("Hello World!", testPage.helloWorld.getText());

    //Assertion 2 (Selenide assertion)
    testPage.helloWorld.should(Condition.text("fake test")); //FAIL
    //The above step was created to show that with Selenide assertions, 'build folder' is created and a report with screenshot
        // taken for the failed test. With junit assertions, we don't get a screenshot!
        //By Default, Selenide takes the screenshot ==>
        //      Configuration.screenshots = true;
        // However, we can DISABLE this feature ==>
        //      Configuration.screenshots = false;
    }

//  FILE UPLOAD
    @And("I upload the file existing on this path {string}")
    public void iUploadTheFileExistingOnThisPath(String arg0) {
        //1. Get the file path
        File fullPath = new File(arg0);
        //2. Upload the file
        $(By.id("file-upload")).uploadFile(fullPath);
        //3. Click upload button
        $(By.id("file-submit")).click();
    }

    @Then("I verify the file is uploaded")
    public void iVerifyTheFileIsUploaded() {
        $(By.xpath("//h3")).shouldHave(Condition.text("File Uploaded!"));
    }

//  JS EXECUTOR
    @And("I scroll down to footer section")
    public void iScrollDownToFooterSection() {
        SelenideElement footer = $(By.xpath("//table[@class='navFooter']"));
        executeJavaScript("arguments[0].scrollIntoView(true)", footer);
    }

    @And("I click on {string} by JS on Amazon table")
    public void iClickOnByJSOnAmazonTable(String arg0) {
        SelenideElement element = $(By.xpath("//table[@class='navFooter']//*contains(text(),'"+arg0+"')]"));
        executeJavaScript("arguments[0].click();", element);

//      ALTERNATIVELY LOCATING THE ELEMENT WITH JAVASCRIPT
//      executeJavaScript("document.getElementById('nav-logo-sprites').click();");

    }
}
