package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "pretty",
                "html:target/default-cucumber-reports.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
        },
        monochrome = true,
        features = "./src/test/resources/features", //path of the features file
        glue = {"stepdefinitions"}, //path os the step definitions
        tags = "@iframe",
        dryRun = false
)

public class Runner {
}
