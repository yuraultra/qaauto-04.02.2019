package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class PasswordResetPage extends BasePage{


    @FindBy(xpath="//a[@class='link-forgot-password']")
    private WebElement passwordResetLink;

    @FindBy(xpath="//input[@class='login submit-button']")
    private WebElement submit;

    @FindBy(xpath="//input[@name='userName']")
    private WebElement fieldEmail;

    @FindBy(xpath="//button[@class='form__submit']")
    private WebElement submitButton;

    @FindBy(xpath="//a[@href='https://www.linkedin.com/help/linkedin/answer/1501']")
    private WebElement sendMailOk;



    public PasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void cliсkPasswordResetLink(){
        passwordResetLink.click();
    }

    public void requestRestore(String email){
        fieldEmail.sendKeys(email);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        submitButton.click();
    }

    public void confirmRestore(){
        submitButton.click();
    }

    public boolean isLoginPageLoaded () {
        return submit.isDisplayed();
    }

    public boolean isResetPageLoaded() {
        return driver.getCurrentUrl().contains("/uas");
    }

    public boolean isConfirmPageLoaded() {
        return driver.getCurrentUrl().contains("/checkpoint/rp");
    }

    public boolean isOkSendEmail() {
        return sendMailOk.isDisplayed();
    }

    public boolean isPageLoaded() {
        return false;
    }
}
