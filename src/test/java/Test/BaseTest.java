package Test;

import Page.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    private WebDriver driver;
    protected LoginPage loginPage;

    /**
     * Метод инициирует перед каждым тестом запуск хромдайвера (новое окно браузера) переходит на указанный
     * URL и создаёт новый объект класса LoginPage
     */
    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        loginPage = new LoginPage(driver);
    }

    /**
     * Метод после каждого теста закрывает все вкладки браузера (и браузер)
     */
    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
