package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static utilities.utilities.elementVisible;
import static utilities.utilities.isElementPresent;

public class GooglePage extends BasePage {
    public GooglePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        URL = "https://www.google.com.ua/";
    }

    // ---- ELEMENTS ----
    @FindBy(id = "hplogo") protected WebElement googleLogo;

    // ---- METHODS ----
    public boolean googleLogoIsDisplayed(){
        return isElementPresent(googleLogo);
    }
}
