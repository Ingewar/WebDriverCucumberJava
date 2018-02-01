package utilities;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class utilities {
    public static String uniqValue;

    public static boolean isElementPresent(WebElement element){
        try{
            return element.isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }catch (StaleElementReferenceException j){
            return false;
        }
    }

    public static void waitInSec(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static ExpectedCondition<Boolean> elementVisible(final WebElement element){
        return  new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                try {
                    return element.isDisplayed();
                } catch (NoSuchElementException e){
                    return false;
                } catch (StaleElementReferenceException el){
                    return  false;
                }
            }
        };
    }

    public static ExpectedCondition<Boolean> elementInvisible(final WebElement element){
        return  new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                try {
                    return !element.isDisplayed();
                } catch (NoSuchElementException e){
                    return true;
                } catch (StaleElementReferenceException el){
                    return  true;
                }
            }
        };
    }

    // adding random value to all except empty string or it contains 'auto'
    public static String addUniqValue(String value){
        String result = "";
        if(value.toLowerCase().contains("auto".toLowerCase())){
            result = value;
        }else if(!value.equals("")){
            if (value.contains("@")){
                String[] arrOfStrings = value.split("@", 2);
                result = arrOfStrings[0]+""+uniqValue+"@"+arrOfStrings[1];
            }else if(value.toLowerCase().contains("auto".toLowerCase())){
                result = value;
            }
            else {
                result = value +""+uniqValue;
            }
        }
        return result;
    }

}
