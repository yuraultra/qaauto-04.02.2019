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

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        loginPage.login("yura.ultra@gmail.com","Ultra_777");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");

        driver.quit();
    }
    @Test
    public void notSuccessfulLoginTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        loginPage.login("yura.ultra@gmail.comxx","Ultra_777");

        ErrorPage errorPage = new ErrorPage(driver);
        Assert.assertTrue(errorPage.isPageLoaded(),
                "Error page was not loaded.");
        Assert.assertTrue(errorPage.loginFail(),
                "Login is wrong");

        driver.quit();
    }
    @Test
    public void notSuccessfulPasswordTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        WebElement mailField = driver.findElement(By.xpath("//input[@class='login-email reg-field__input']"));
        WebElement passField = driver.findElement(By.xpath("//input[@class='login-password reg-field__input']"));
        WebElement submit = driver.findElement(By.xpath("//input[@class='login submit-button']"));

        mailField.sendKeys("yura.ultra@gmail.com");
        passField.sendKeys("Ultra");
        submit.click();

        WebElement errorPassword = driver.findElement(By.xpath("//div[@id='error-for-password']"));

        errorPassword.isDisplayed();

        Assert.assertEquals(errorPassword.getText(), "Это неверный пароль. Повторите попытку или измените пароль.",
                "Password is wrong");
        driver.quit();
    }
}
