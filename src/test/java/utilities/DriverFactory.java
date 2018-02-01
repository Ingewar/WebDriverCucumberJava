package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverFactory {

    protected static WebDriver driver;

    public DriverFactory(){
        initialize();
    }

    public void initialize(){
        if(driver==null){
            createNewDriverInstance();
        }
    }

    private void createNewDriverInstance() {
        String systemName = System.getProperty("os.name");
        if(systemName.contains("Mac")){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedrivermac");
            driver = new ChromeDriver();
        }else{
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriverlinux");
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void destroyDriver(){
        driver.quit();
        driver = null;
    }

    public WebDriver getDriver(){
        return driver;
    }
}
