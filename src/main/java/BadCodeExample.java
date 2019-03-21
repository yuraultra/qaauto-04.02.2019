import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BadCodeExample {
    public static void main(String[] args) {
        //System.out.printf("Hello World!!!");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        String searchTerm = "Selenium";
        //WebElement searchField = driver.findElement(By.name("q"));
        WebElement searchField = driver.findElement(By.xpath("//input[@name='q']"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));
        System.out.println(searchResults.size()+ "\n");
        for (WebElement searchResult : searchResults) {
            String searchResultString = searchResult.getText();
            if (searchResultString.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("OK   " + searchResult.getText() + "\n");
            } else {
                System.out.println("Not OK   " + searchResult.getText());
            }
        }

        /*List<WebElement> findAll = driver.findElements(By.className("LC20lb"));
        System.out.println("Всего на странице найдено: " + findAll.size() + " ссылок.");
        for (int i=0;i<findAll.size();i++) {
            System.out.println("Текст найденной ссылки: " +findAll.get(i).getText());
        }*/
        driver.close();
    }
}



    /*WebElement element = driver.findElement(By.name("q"));
    element.sendKeys("Selenium");
    element.submit();
         driver.close(); */


