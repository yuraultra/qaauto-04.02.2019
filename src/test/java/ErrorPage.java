import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ErrorPage {
    WebDriver driver;
    WebElement errorUserName;

    public ErrorPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    public void initElements() {
        errorUserName = driver.findElement(By.xpath("//div[@id='error-for-username']"));
    }

    public boolean isPageLoaded() {
        return errorUserName.isDisplayed();
    }

    public boolean loginFail() {
        return errorUserName.getText().contains("Этот адрес эл. почты не зарегистрирован в LinkedIn.");
    }
}
