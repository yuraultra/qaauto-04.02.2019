import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "linkedin.tst.yanina@gmail.com", "Mykola123" },
                { "linkedin.TST.yanina@gmail.com", "Mykola123" }
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        loginPage.login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");
    }




    @DataProvider
    public Object[][] wrongLoginDataProvider() {
        return new Object[][]{
                { "yura.ultra@@gmail.com", "Ultra_777" },
                { "yura.ultra@gmail..com", "Ultra_777" },
                { "Yyura.ultra@gmail.com", "Ultra_777" }
        };
    }

    @Test(dataProvider = "wrongLoginDataProvider")
    public void notSuccessfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        loginPage.login(userEmail, userPassword);

        ErrorPage errorPage = new ErrorPage(driver);
        Assert.assertTrue(errorPage.isPageLoaded(),
                "Error page was not loaded.");
        Assert.assertEquals(errorPage.getUserEmailValidationMessage(),
                "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.",
                "userEmail validation message is incorrect.");
    }




    @DataProvider
    public Object[][] wrongPassworDataProvider() {
        return new Object[][]{
                { "yura.ultra@gmail.com", "Ultra_777" },
                { "yura.ultra@gmail.com", "ULTRA_777" },
                { "yura.ultra@gmail.com", "ultra_777" }
        };
    }

    @Test(dataProvider = "wrongPassworDataProvider")
    public void notSuccessfulPasswordTest(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        loginPage.login(userEmail, userPassword);

        ErrorPage errorPage = new ErrorPage(driver);
        Assert.assertTrue(errorPage.isPageLoaded(),
                "Error page was not loaded.");
        Assert.assertEquals(errorPage.getUserPasswordValidationMessage(),
                "Это неверный пароль. Повторите попытку или измените пароль.",
                "userPassword validation message is incorrect.");
    }




    @DataProvider
    public Object[][] emptyFieldDataProvider() {
        return new Object[][]{
                { "yura.ultra@gmail.com", "" },
                { "", "Mykola123" },
                { "", "" }
        };
    }

    @Test(dataProvider = "emptyFieldDataProvider")
    public void emptyFieldLoginPassword(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
        loginPage.login(userEmail, userPassword);

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");
    }
}
