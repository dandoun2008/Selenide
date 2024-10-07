package stepdefinitions;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.GooglePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class GoogleStepDefinitions {

    GooglePage googlePage = new GooglePage();

    @Given("I navigate to {string}")
    public void i_navigate_to(String string) {

//      open("https://www.google.com");

        open(string); //dynamic
        sleep(5000); //5 seconds
    }

    @Given("I wait for {int} seconds")
    public void i_wait_for_seconds(Integer int1) {
        sleep(int1*1000);
    }

    @Given("I navigate back")
    public void i_navigate_back() {
        back();
    }

    @Given("I navigate forward")
    public void i_navigate_forward() {
        forward();
    }

    @Given("I refresh the page")
    public void i_refresh_the_page() {
        refresh();
    }

    @Then("I hold the browser open")
    public void i_hold_the_browser_open() {
        //Selenide automatically closes the browser, so we have to add this step to hold the browser open if we need it.
        Configuration.holdBrowserOpen = true;
    }

    @When("I search for {string}")
    public void i_search_for(String string) {
        googlePage.googleSearchBox.setValue(string).pressEnter();
    }

    @Then("verify page source contains {string}")
    public void verify_page_source_contains(String string) {
        WebDriverRunner.url(); //RETURNS THE URL OF THE PAGE
        String pageSource = WebDriverRunner.source(); //RETURNS THE PAGE SOURCE
        System.out.println(pageSource);
        Assert.assertTrue(pageSource.contains(string));
    }

/*    @Then("verify the result should contain {string} keyword")
    public void verify_the_result_should_contain_keyword(String string) {
        googlePage.resultSection.shouldBe(visible); //Checks if resultSection element is visible on the page
        googlePage.resultSection.shouldHave(text(string)); //This step in Selenide is similar to:
        //googlePage.resultSection.toString().contains(string); //in Selenium. Either one can be used
        googlePage.resultSection.shouldNotHave(text("MERCEDES TRUCK")); //This is a negative test case
    }  //I commented out this step because the resultSection currently is different from the time the session was held!
*/


    @Then("the first result in the result page should contain {string}")
    public void theFirstResultInTheResultPageShouldContain(String string) {
        googlePage.getAllSections.get(0).shouldHave(text(string));
    }
}
