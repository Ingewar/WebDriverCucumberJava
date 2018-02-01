package steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import utilities.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utilities.utilities.uniqValue;

public class StartingSteps {

    private WebDriver driver;
    public Scenario scenario;

    @Before
    public void beforeScenario(Scenario scenario){
        driver = new DriverFactory().getDriver();
        this.scenario = scenario;
        driver.manage().window().setPosition(new Point(0, 0));
        driver.manage().window().setSize(new Dimension(1440, 900));
        uniqValue = RandomStringUtils.randomAlphanumeric(10);
    }

    @After
    public void afterScenario(){
        embedScreenShot(scenario);
        new DriverFactory().destroyDriver();
    }

    public void embedScreenShot(Scenario scenario){
        if(scenario.isFailed()){
            File screenshot =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            DateFormat dateFormat = new SimpleDateFormat("dd.MM-HH:mm");
            try {
                FileUtils.copyFile(screenshot, new File("target/testResults/"+scenario.getName()+" "+dateFormat.format(new Date())+".png"));
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
