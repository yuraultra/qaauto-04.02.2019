import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkedinLoginTest {

    WebDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    @Test
    public void successfulLoginTest() {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        loginPage.login("yura.ultra@gmail.com", "Ultra_777");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");
    }

    @Test
    public void notSuccessfulLoginTest() {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        loginPage.login("yura.ultra@gmail.comxx", "Ultra_777");

        ErrorPage errorPage = new ErrorPage(driver);
        Assert.assertTrue(errorPage.isPageLoaded(),
                "Error page was not loaded.");
        Assert.assertTrue(errorPage.isUserNameErrorPresent(),
                "Unknown error");
        Assert.assertEquals(errorPage.isUserNameErrorPresent(),
                "Hmm, that's not the right password. Please try again or request a new one.",
                "userPassword validation message is incorrect.");

    }

    @Test
    public void emptyFieldLoginPassword() {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        loginPage.login("yura.ultra@gmail.com", "");

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
    }
}
