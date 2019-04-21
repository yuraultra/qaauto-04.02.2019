import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PasswordResetTest {
    WebDriver driver;
    PasswordResetPage PasswordResetPage;
    EmailPage EmailPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        PasswordResetPage = new PasswordResetPage(driver);
    }

    @AfterMethod
    public void afterMethod() {
       driver.quit();
    }

    @Test
    public void passwordReset() {

        String userEmail = "Test.yura.ultra@gmail.com";
        String userPassword = "Test_Yura_Ultra";

        Assert.assertTrue(PasswordResetPage.isLoginPageLoaded(),
                "Login page was not loaded.");

        PasswordResetPage.cliсkPasswordResetLink();

        Assert.assertTrue(PasswordResetPage.isResetPageLoaded(),
                "Reset page was not loaded.");

        PasswordResetPage.requestRestore(userEmail);

        Assert.assertTrue(PasswordResetPage.isConfirmPageLoaded(),
                "Confirm page was not loaded.");

        PasswordResetPage.confirmRestore();

        Assert.assertTrue(PasswordResetPage.isOkSendEmail(),
                "Email is not send.");

        EmailPage emailPage = new EmailPage(driver);
        emailPage.goToGmail();
        emailPage.LoginGmail(userEmail, userPassword);

        Assert.assertTrue(EmailPage.isPageGmailLoaded(),
                "Gmail page was not loaded.");

        Assert.assertTrue(EmailPage.isGmailConteinsLinkedIn(),
               "Email from LinkedIn not found");

        EmailPage.clickToLinkedInMail();

    }

}
