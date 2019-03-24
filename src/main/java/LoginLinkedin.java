import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginLinkedin {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        WebElement login = driver.findElement(By.xpath("//input[@class='login-email reg-field__input']"));
        login.sendKeys("yura.ultra@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@class='login-password reg-field__input']"));
        password.sendKeys("Ultra_777");
        password.sendKeys(Keys.ENTER);

    }
}


//input[@class='login submit-button']