import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private WebElement mailField;
    private WebElement passField;
    private WebElement submit;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        mailField = driver.findElement(By.xpath("//input[@class='login-email reg-field__input']"));
        passField = driver.findElement(By.xpath("//input[@class='login-password reg-field__input']"));
        submit = driver.findElement(By.xpath("//input[@class='login submit-button']"));
    }

    public HomePage login(String userEmail, String userPassword) {
        mailField.sendKeys(userEmail);
        passField.sendKeys(userPassword);
        submit.click();
        return new HomePage(driver);
    }

    public LoginPage loginToLoginPage(String userEmail, String userPassword) {
        mailField.sendKeys(userEmail);
        passField.sendKeys(userPassword);
        submit.click();
        return new LoginPage(driver);
    }

    public ErrorPage loginToErrorPage(String userEmail, String userPassword) {
        mailField.sendKeys(userEmail);
        passField.sendKeys(userPassword);
        submit.click();
        return new ErrorPage(driver);
    }

    public boolean isPageLoaded() {
        return submit.isDisplayed();
    }
}
