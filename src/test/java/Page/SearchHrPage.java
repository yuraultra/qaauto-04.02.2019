package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchHrPage extends BasePage{

    @FindBy(xpath = "//input[@placeholder='Поиск']")
    private WebElement fieldSearch;

    @FindBy(xpath = "//li[@id='profile-nav-item']")
    private WebElement profileNavigationItem;

    @FindBy(xpath = "//ul[@class='artdeco-pagination__pages artdeco-pagination__pages--number']")
    private WebElement lineResultSearch;

    public SearchHrPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return profileNavigationItem.isDisplayed();
    }

    public void enterHrSearchField() {
        fieldSearch.sendKeys("HR");
        fieldSearch.sendKeys(Keys.ENTER);
    }

    public boolean isPageLoadedSearchResult() {
        return lineResultSearch.isDisplayed();
    }


    public void something () {
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='search-result__wrapper']"));
        int count = 0;
        for(WebElement searchResult :searchResults)
        {
            count++;
            String searchResultString = searchResult.getText();
            if (searchResultString.toLowerCase().contains("Human Resources".toLowerCase())) {
                System.out.println("OK   " + searchResult.getText() + "\n");
            } else {
                System.out.println("Not OK   " + searchResult.getText());
            }
        }
    }


}
