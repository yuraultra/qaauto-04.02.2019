package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Parent  class for every page object class.
 */
public abstract class BasePage {

    /**
     * Variable that holds driver value for page.
     */
    protected WebDriver driver;

    /**
     * Abstract method is check  if page was loaded.
     *
     * @return true/false is page loaded or not.
     */
    public abstract boolean isPageLoaded();

    public void waitUntilElementInVisible(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(webElement))

    }
}
