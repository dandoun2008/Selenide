package stepdefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Selenide.*;

public class GoogleStepDefinitions {

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
        //Selenide automatically closes the browser so we have to add this step to hold the browser open if we need it.
        Configuration.holdBrowserOpen = true;
    }


}
