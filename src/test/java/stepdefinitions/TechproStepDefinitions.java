package stepdefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;

import static com.codeborne.selenide.Selenide.*;

public class TechproStepDefinitions {
    @And("I get the title of the current page and verify if it contains {string}")
    public void iGetTheTitleOfTheCurrentPageAndVerifyIfItContains(String string) {
//    getting the title of the page
        Assert.assertTrue(title().contains(string));
    }
}
