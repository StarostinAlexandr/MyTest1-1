package practica;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;

public class Tests extends WebDriverSettings {

    @Test
    @Description(value = "В результате список больше трёх (PageObject)")
    public void testPOYandexResultMoreThanThree(){
        chromeDriver.get("https://www.yandex.ru/");
        PageObjectYandex pageObjectYandex = new PageObjectYandex(chromeDriver, "гладиолус");
        System.out.println(pageObjectYandex.getSearchWebItems().size());
        pageObjectYandex.getCollectResults().stream().forEach(System.out::println);
        Steps.checkYandexResultMoreThanThree(pageObjectYandex.getCollectResults(), chromeDriver);
    }

    @Test
    @Description(value = "Негативный тест: Список в результате не должен быть больше нуля")
    public void testPOYandexResultMoreThanThreeNegative(){
        chromeDriver.get("https://www.yandex.ru/");
        PageObjectYandex pageObjectYandex = new PageObjectYandex(chromeDriver, "");
        System.out.println(pageObjectYandex.getSearchWebItems().size());
        pageObjectYandex.getCollectResults().stream().forEach(System.out::println);
        Steps.checkYandexResultMoreThanThreeNegative(pageObjectYandex.getCollectResults(), chromeDriver);
    }

    @Test
    @Description(value = "Тест что есть ссылка Гладиолус - Википедия")
    public void testPOYandexResultContains(){
        chromeDriver.get("https://www.yandex.ru/");
        PageObjectYandex pageObjectYandex = new PageObjectYandex(chromeDriver, "гладиолус");
        System.out.println(pageObjectYandex.getSearchWebItems().size());
        pageObjectYandex.getCollectResults().stream().forEach(System.out::println);
        Steps.checkContainsName(pageObjectYandex.getCollectResults(),"Гладиолус - Википедия", chromeDriver);
    }

    @Test
    @Description(value = "Негативный Тест что есть ссылка Гладиолус - Википедия ")
    public void testPOYandexResultContainsNegative(){
        chromeDriver.get("https://www.yandex.ru/");
        PageObjectYandex pageObjectYandex = new PageObjectYandex(chromeDriver, "гладиолус");
        System.out.println(pageObjectYandex.getSearchWebItems().size());
        pageObjectYandex.getCollectResults().stream().forEach(System.out::println);
        Steps.checkContainsNameNegative(pageObjectYandex.getCollectResults(),"Гладиолус — Википедия", chromeDriver);
    }

    @Test
    @Description(value = "В результате список больше трёх (PageFactory)")
    public void testPFYandexResultMoreThanThree(){
        chromeDriver.get("https://www.yandex.ru/search?text="+ "гладиолус");

        PageFactoryYandex pageFactoryYandex = PageFactory.initElements(chromeDriver,PageFactoryYandex.class);
//        pageFactoryYandex.find("гладиолус");
//        pageFactoryYandex.findAll();
//        PageFactoryYandex pageFactoryYandex2 = PageFactoryYandex.initElements(chromeDriver,PageFsctoryBell.class);
//        PageFactoryYandex pageFactoryYandex = new PageFactoryYandex(chromeDriver, "гладиолус");
//        System.out.println(pageFactoryYandex.getListResult().size());
        System.out.println(pageFactoryYandex.getCollectResults().size());
//        pageFactoryYandex.getCollectResults().stream().forEach(System.out::println);
        Steps.checkYandexResultMoreThanThree(pageFactoryYandex.getCollectResults(), chromeDriver);

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
