package stepdefinitions;

import io.cucumber.java.en.And;
import org.junit.Assert;
import pages.TestPage;

import static com.codeborne.selenide.Selenide.*;

public class TechproStepDefinitions {

    TestPage testPage = new TestPage();

    @And("I get the title of the current page and verify if it contains {string}")
    public void iGetTheTitleOfTheCurrentPageAndVerifyIfItContains(String string) {
//    getting the title of the page
        Assert.assertTrue(title().contains(string));
    }

//  SCREENSHOT OF SPECIFIC ELEMENT (Opportunities)
    @And("I capture the screenshot of Dialogue icon at the right bottom corner")
    public void iCaptureTheScreenshotOfDialogueIconAtTheRightBottomCorner() {
        try {
            testPage.dialogueIcon.screenshot();
        } catch (Exception e) {

        }
    }

}
