import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ErrorPage {
    private WebDriver driver;

    @FindBy(xpath="//form[@action='/checkpoint/lg/login-submit']")
    private WebElement loginSubmitForm;

    @FindBy(xpath="//div[@id='error-for-username']")
    private WebElement userEmailValidationMessage;

    @FindBy(xpath="//div[@id='error-for-password']")
    private WebElement userPasswordValidationMessage;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return loginSubmitForm.isDisplayed();
    }

    public String getUserEmailValidationMessage() {
        return userEmailValidationMessage.getText();
    }

    public String getUserPasswordValidationMessage() {
        return userPasswordValidationMessage.getText();
    }

}
