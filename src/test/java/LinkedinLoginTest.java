import org.openqa.selenium.WebDriver;
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
        Assert.assertTrue(errorPage.isUserNameErrorPresent(),
                "Unknown error");
        Assert.assertEquals(errorPage.isUserNameErrorPresent(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "userPassword validation message is incorrect.");

        driver.quit();
    }
    @Test
    public void emptyFieldLoginPassword() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        loginPage.login("yura.ultra@gmail.com","");

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        driver.quit();
    }
}
