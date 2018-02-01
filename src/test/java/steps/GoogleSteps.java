package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import pages.GooglePage;
import utilities.DriverFactory;

import static org.junit.Assert.*;

public class GoogleSteps  extends DriverFactory implements En{

    public GoogleSteps(){

        // ----- CREATING PAGE INSTANCES -----
        GooglePage googlePage = new GooglePage(driver);

        // ---- STEPS IMPLEMENTATION ----
        When("^I open Google start page$", () -> {
            googlePage.loadPage();
        });

        // ---- VERIFICATION STEPS ----

        Then("^I should see \"([^\"]*)\" page title$", (String title) -> {
            assertEquals(driver.getTitle(), title);
        });
        And("^Google logo should be displayed$", () -> {
            googlePage.googleLogoIsDisplayed();
        });
    }
}
