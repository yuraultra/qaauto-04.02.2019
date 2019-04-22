package Page;

import org.openqa.selenium.WebDriver;

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
}
