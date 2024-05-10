package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src\\test\\resources\\features\\feature.feature"},
        glue = {"stepdefs"},
        dryRun = false,
        plugin = {
                "pretty",
                "json:cucumber/Cucumber.json"
        }

)
// @Listeners( {CucumberTestListener.class})
public class MyTests {

}
