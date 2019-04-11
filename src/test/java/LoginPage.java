import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    @FindBy(xpath="//input[@class='login-email reg-field__input']")
    private WebElement mailField;

    @FindBy(xpath="//input[@class='login-password reg-field__input']")
    private WebElement passField;

    @FindBy(xpath="//input[@class='login submit-button']")
    private WebElement submit;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
      //  PageFactory.initElements(driver, this);
    }

    public <GenericPage> GenericPage login(String userEmail, String userPassword) {
        mailField.sendKeys(userEmail);
        passField.sendKeys(userPassword);
        submit.click();
        if (driver.getCurrentUrl().contains("/feed")) {
            return (GenericPage) PageFactory.initElements(driver, HomePage.class);
        }
        if (driver.getCurrentUrl().contains("/login-submit")) {
            return (GenericPage) new ErrorPage(driver);
        } else {
            return (GenericPage) new LoginPage(driver);
        }
    }

        public boolean isPageLoaded () {
            return submit.isDisplayed();
        }
    }
