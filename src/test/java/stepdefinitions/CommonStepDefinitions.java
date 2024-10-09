package stepdefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.en.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.codeborne.selenide.Selenide.screenshot;

public class CommonStepDefinitions {
    @Given("I set Configuration.screenshots to false")
    public void i_set_configuration_screenshots_to_false() {
        //This will DISABLE Selenide from taking screenshots of the failed tests
        Configuration.screenshots = false;
    }

    @And("I capture the screenshot of the page")
    public void iCaptureTheScreenshotOfThePage() {
        // Format the date to avoid invalid characters in file names (e.g., replace colons with hyphens)
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = dateFormat.format(new Date());

        // Use the formatted date string for the screenshot filename
        screenshot(timestamp); // You might want to pass the sanitized timestamp to the screenshot method
    }
        //screenshot(new Date().toString()); //This method gets us a screenshot with a dynamic filename
            //but did not work for me because of the date formatting, so I had to use chatgpt code to adjust the date format


}

