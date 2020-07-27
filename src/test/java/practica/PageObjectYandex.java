package practica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PageObjectYandex {
//    private String selectorSearchItems="//div[@class='g']";
    private String selectorSearchItems="//h2[@class='organic__title-wrapper typo typo_text_l typo_line_m']";
    private String selectorURL = ".//div[@class='r']/a[@href]";
    private String selectorNamePage = ".//div[@class='r']/a[@href]";
    private String selectorDiscriprion = ".//div[@class='s']";
    private WebDriver driver;
    private List<WebElement> searchWebItems = new ArrayList<>();
    private List<String> collectResults = new ArrayList<>();

    private WebDriver chromeDriver;
    private List<WebElement> listResult;
    public List<String> getCollectResults() {
        searchWebItems.stream().forEach(x->collectResults.add(x.getText()));
        return collectResults;
    }

    public List<WebElement> getSearchWebItems() {
        return searchWebItems;
    }

    WebElement searchField;
    WebElement searchButton;

    public PageObjectYandex(WebDriver driver, String search){
        this.driver=driver;
        this.driver.get("https://www.yandex.ru/search?text="+search);
        searchWebItems =driver.findElements(By.xpath(selectorSearchItems));

    }

    PageObjectYandex(WebDriver chromeDriver) {
        this.chromeDriver = chromeDriver;
        searchField = chromeDriver.findElement(By.xpath("//*[@id=\"text\"]"));
        searchButton = chromeDriver.findElement(By.cssSelector(".mini-suggest__button"));

    }

    public void find(String wordFind) {
        searchField.click();
        searchField.sendKeys(wordFind);
        searchButton.click();
        listResult = chromeDriver.findElements(By.xpath("//*[@class=\"organic__title-wrapper typo typo_text_l typo_line_m\"]"));
    }

}
