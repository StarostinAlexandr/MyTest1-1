package practica;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class PageFactoryYandex {
//    private WebDriver chromeDriver;
//    private WebDriver driver;

    @FindAll(@FindBy(how = How.XPATH, using="//h2[@class=\"organic__title-wrapper typo typo_text_l typo_line_m\"]"))
    private List<WebElement> searchWebItems = new ArrayList<>();

    private List<String> collectResults = new ArrayList<>();

//    @FindAll(@FindBy(how = How.XPATH, using="//*[@class=\"organic__title-wrapper typo typo_text_l typo_line_m\"]"))
//    private String selectorSearchItems;

/*    @FindBy(how = How.CSS, css=".mini-suggest__input")
    WebElement searchField;

    @FindBy(how= How.CSS, css=".mini-suggest__button")
    WebElement searchButton;

    @FindAll(@FindBy(how = How.XPATH, using="//h2[@class=\"organic__title-wrapper typo typo_text_l typo_line_m\"]"))
    List<WebElement> listResult;

    public List<WebElement> getListResult() {
        return listResult;
    }*/
    /*public PageFactoryYandex(WebDriver driver, String search){
        this.driver=driver;
        this.driver.get("https://www.yandex.ru/search?text="+search);
        searchWebItems =driver.findElements(By.xpath(selectorSearchItems));

    }*/

    public List<String> getCollectResults() {
        searchWebItems.stream().forEach(x->collectResults.add(x.getText()));
        return collectResults;
    }
/*
    public PageFactoryYandex(WebDriver chromeDriver){
        this.chromeDriver=chromeDriver;
    }*/

//    public List<WebElement> findAll() {
//      return   searchWebItems =driver.findElements(By.xpath(selectorSearchItems));
//    }

 /*   public void find(String wordFind){
        searchField.click();
        searchField.sendKeys(wordFind);
        searchButton.click();
    }*/


}
