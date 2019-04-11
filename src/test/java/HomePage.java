import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private WebElement profileNavigationItem;

    public HomePage(WebDriver driver){
        this.driver = driver;
        initElement();
    }

    public void initElement(){
        profileNavigationItem = driver.findElement(By.xpath("//li[@id='profile-nav-item']"));
    }

    public boolean isPageLoaded() {
        return profileNavigationItem.isDisplayed()
        && driver.getTitle().contains("Linkedin");
    }
}
