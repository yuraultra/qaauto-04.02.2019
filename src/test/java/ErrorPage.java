import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorPage {
    private WebDriver driver;
    private WebElement errorUserName;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        errorUserName = driver.findElement(By.xpath("//div[@id='error-for-username']"));
    }

    public boolean isPageLoaded() {
        return errorUserName.isDisplayed();
    }

    public boolean isUserNameErrorPresent() {
        return errorUserName.getText().contains("Этот адрес эл. почты не зарегистрирован в LinkedIn.");
    }
}
