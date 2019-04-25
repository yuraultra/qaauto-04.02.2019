package Page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage{

    @FindBy(xpath="//li[contains(@class, 'search-result__occluded-item')]")
    private List<WebElement> searchResults;

    @FindBy(xpath="//h3[contains(@class, 'search-results__total ')]")
    private List<WebElement> totalResults;



    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waitUntilElementInVisible(totalResults);
    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/search");
    }

    public int getSearchResultCount() {
        return searchResults.size();
    }

    public List<String> getSearchResults() {
        List<String> searchResultList = new ArrayList<String>();
        for (WebElement searchResult : searchResults){
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResult);
            String searchResultText = searchResult.getText();
            searchResultList.add(searchResultText);
        }
        return searchResultList;
    }
}
