package utilities;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "features",
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class RunCukesTest {
}
