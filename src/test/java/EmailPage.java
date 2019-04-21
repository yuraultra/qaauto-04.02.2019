import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class EmailPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement loginField;

    @FindBy(xpath = "//span[@class='RveJvd snByac']")
    private WebElement loginSubmitButton;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//span[@class='zF' and contains(@name, 'LinkedIn')]")
    private WebElement emailLinkedInPost;

    @FindBy(xpath = "//a[contains(@href, 'https://www.linkedin.com/e/v2')]")
    private WebElement clickResetPasswordLinkInEmail;


    public EmailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public EmailPage goToGmail() {
        driver.get("https://mail.google.com");
        return new EmailPage(driver);
    }

    public void LoginGmail(String userEmail, String userPassword) {
        loginField.sendKeys(userEmail);
        loginSubmitButton.click();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        passwordField.sendKeys(userPassword);
        loginSubmitButton.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //loginSubmitButton.click();
    }

    public void clickToLinkedInMail(){
        emailLinkedInPost.click();
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clickResetPasswordLinkInEmail.click();

    }

    public boolean isPageGmailLoaded() {
        return driver.getCurrentUrl().contains("/mail/u");
    }

    public boolean isGmailConteinsLinkedIn() {
        return emailLinkedInPost.isDisplayed();
    }
}
