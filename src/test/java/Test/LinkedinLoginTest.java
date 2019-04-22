package Test;

import Page.ErrorPage;
import Page.HomePage;
import Page.LoginPage;
import Page.SearchHrPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LinkedinLoginTest extends BaseTest{



    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
               { " yura.ultra@gmail.com ", "Ultra_777" }
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        HomePage homePage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(homePage.isPageLoaded(),
                "Home page is not loaded.");
    }

    @DataProvider
    public Object[][] wrongLoginDataProvider() {
        return new Object[][]{
                { "yura.ultra@gmail.com", "Ultra_777", "", "Это неверный пароль. Повторите попытку или измените пароль."},
                { "yura.ultra@@gmail.com", "Ultra_777", "Этот адрес эл. почты не зарегистрирован в LinkedIn. Повторите попытку.", ""}
        };
    }

    @Test(dataProvider = "wrongLoginDataProvider")
    public void notSuccessfulLoginTest(String userEmail,
                                       String userPassword,
                                       String emailValidation,
                                       String passwordValidation) {

        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        ErrorPage errorPage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(errorPage.isPageLoaded(),
                "Error page was not loaded.");
        Assert.assertEquals(errorPage.getUserEmailValidationMessage(),
                emailValidation,
                "userEmail validation message is incorrect.");
        Assert.assertEquals(errorPage.getUserPasswordValidationMessage(),
                passwordValidation,
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

        LoginPage loginPage1 = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(loginPage1.isPageLoaded(),
                "Login page was not loaded.");
    }




    @DataProvider
    public Object[][] searchDataProvider() {
        return new Object[][]{
                { " yura.ultra@gmail.com ", "Ultra_777" }
        };
    }

    @Test(dataProvider = "searchDataProvider")
    public void loginTestSearch(String userEmail, String userPassword) {
        Assert.assertTrue(loginPage.isPageLoaded(),
                "Login page was not loaded.");

        SearchHrPage searchHrPage = loginPage.login(userEmail, userPassword);

        Assert.assertTrue(searchHrPage.isPageLoaded(),
                "Home page is not loaded.");

        searchHrPage.enterHrSearchField();

        Assert.assertTrue(searchHrPage.isPageLoadedSearchResult(),
                "Result search page is not loaded.");



    }
}
