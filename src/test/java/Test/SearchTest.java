package Test;

import Page.HomePage;
import Page.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest{


    @Test
    public void basicSearchTest(){
        String userEmail = "yura.ultra@gmail.com";
        String userPassword = "Ultra_777";
        String searchTerm = "Human";

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");

        SearchResultsPage searchResultsPage = homePage.search(searchTerm);
        Assert.assertTrue(searchResultsPage.isPageLoaded(), "SearchResults page is not loaded");

        Assert.assertEquals(searchResultsPage.getSearchResultCount(),10, "Result count is wrong");

        List<String> searchResults = searchResultsPage.getSearchResults();

        for (String searchResult : searchResults){
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "searchTerm: " + searchTerm+ " not found in: \n" + searchResult);
        }
    }
}
