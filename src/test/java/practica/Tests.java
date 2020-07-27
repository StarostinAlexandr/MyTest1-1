package practica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends WebDriverSettings {

    @Test
    public void testPOYandexResultMoreThanThree(){
        chromeDriver.get("https://www.yandex.ru/");
        PageObjectYandex pageObjectYandex = new PageObjectYandex(chromeDriver);
        pageObjectYandex.find("гладиолус");
        System.out.println(pageObjectYandex.getSearchWebItems().size());
        pageObjectYandex.getCollectResults().stream().forEach(System.out::println);
        //resultSearch.stream().forEach(x-> System.out.println(x.get("NAME_PAGE").toString()));
        Steps.checkContainsName(pageObjectYandex.getCollectResults(),"Шпажник — Википедия", chromeDriver);

        Assertions.assertTrue(
                pageObjectYandex.getSearchWebItems().size() > 3
                , "Список с результатом поиска имеет размер не более трёх элементов"
        );
    }

    @Test
    public void testPOYandexResultContains(){
        chromeDriver.get("https://www.yandex.ru/");
        PageObjectYandex pageObjectYandex = new PageObjectYandex(chromeDriver, "гладиолус");
//        pageObjectYandex.find("гладиолус");
        System.out.println(pageObjectYandex.getSearchWebItems().size());
        pageObjectYandex.getCollectResults().stream().forEach(System.out::println);
        //resultSearch.stream().forEach(x-> System.out.println(x.get("NAME_PAGE").toString()));
        Steps.checkContainsName(pageObjectYandex.getCollectResults(),"Шпажник — Википедия", chromeDriver);


       /* chromeDriver.get("https://www.yandex.ru");
        PageObjectYandex pageObject = new PageObjectYandex(chromeDriver);
        pageObject.find("гладиолус");
        System.out.println(pageObject.getSearchWebItems().size());
        Assertions.assertTrue(
                pageObject.getSearchWebItems().stream().anyMatch(x->x.getText().contains("Гладиолус - Википедия"))
                , "Заданный текст не найден"
        );*/
    }

    @Test
    public void testPFYandexResultMoreThanThree(){
        chromeDriver.get("https://yandex.ru");
        PageFactoryYandex pageFactory = PageFactory.initElements(chromeDriver,PageFactoryYandex.class);
        pageFactory.find("гладиолус");
        Assertions.assertTrue(
                pageFactory.getListResult().size() > 3
                , "Список с результатом поиска имеет размер не более трёх элементов"
        );
    }

    @Test
    public void testPFYandexResultContains(){

       /* chromeDriver.get("https://yandex.ru");
        PageFactoryYandex pageFactory = PageFactory.initElements(chromeDriver,PageFactoryYandex.class);
        pageFactory.find("гладиолус");
        Assertions.assertTrue(
                pageFactory.getListResult().stream().anyMatch(x->x.getText().contains("Гладиолус - Википедия"))
                , "Заданный текст не найден"
        );*/
    }
}
