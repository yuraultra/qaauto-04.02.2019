package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page object class for LoginPage
 */
public class LoginPage extends BasePage{

    @FindBy(xpath="//input[@class='login-email reg-field__input']")
    private WebElement mailField;

    @FindBy(xpath="//input[@class='login-password reg-field__input']")
    private WebElement passField;

    @FindBy(xpath="//input[@class='login submit-button']")
    private WebElement submit;

    /**
     * Constructor of LoginPage object.
     * @param driver WebDriver instance from BaseTest.
     */
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Метод для авторизации пользователя
     *
     * @param userEmail - логин пользователя
     * @param userPassword - пароль пользователя
     * @param <GenericPage> - специальный конструктор позволяющий получать разный результат в звисимости от входящих условий
     * @return - возвращает необходимую нам страницу(класс)
     */
    public <GenericPage> GenericPage login(String userEmail, String userPassword) {
        mailField.sendKeys(userEmail);
        passField.sendKeys(userPassword);
        submit.click();
        if (driver.getCurrentUrl().contains("/feed")) {
            return (GenericPage) new HomePage(driver);
        }
        if (driver.getCurrentUrl().contains("/login-submit")) {
            return (GenericPage) new ErrorPage(driver);
        } else {
            return (GenericPage) new LoginPage(driver);
        }
    }

    /**
     * Метод позволяющий проверить наличие элементов на экране
     * @return - возвращает (правда/лож)
     */
        public boolean isPageLoaded () {
            return submit.isDisplayed();
        }
    }
