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

    private void initElements(){
        mailField = driver.findElement(By.xpath("//input[@class='login-email reg-field__input']"));
        passField = driver.findElement(By.xpath("//input[@class='login-password reg-field__input']"));
        submit = driver.findElement(By.xpath("//input[@class='login submit-button']"));
    }

    public void login(String userEmail, String userPassword){
         mailField.sendKeys(userEmail);
         passField.sendKeys(userPassword);
         submit.click();
     }

    public boolean isPageLoaded() {
        return submit.isDisplayed();
    }
}
