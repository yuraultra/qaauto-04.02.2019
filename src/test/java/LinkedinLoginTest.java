import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinkedinLoginTest {
    @Test
    public void successfulLoginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        WebElement mailField = driver.findElement(By.xpath("//input[@class='login-email reg-field__input']"));
        WebElement passField = driver.findElement(By.xpath("//input[@class='login-password reg-field__input']"));
        WebElement submit = driver.findElement(By.xpath("//input[@class='login submit-button']"));

        mailField.sendKeys("yura.ultra@gmail.com");
        passField.sendKeys("Ultra_777");
        submit.click();

        WebElement profileNavigationItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));

        profileNavigationItem.isDisplayed();

        Assert.assertTrue(!profileNavigationItem.isDisplayed(),
                "profileNavigationItem item is not displayed in home page ");




        driver.close();
    }
}
