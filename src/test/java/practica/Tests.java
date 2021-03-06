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
//        System.out.println(pageObjectYandex.getSearchWebItems().size());
//        pageObjectYandex.getCollectResults().stream().forEach(System.out::println);
        Steps.checkYandexResultMoreThanThree(pageObjectYandex.getCollectResults(), chromeDriver);
    }

    @Test
    @Description(value = "Негативный тест: Список в результате не должен быть больше нуля")
    public void testPOYandexResultMoreThanZeroNegative(){
        chromeDriver.get("https://www.yandex.ru/");
        PageObjectYandex pageObjectYandex = new PageObjectYandex(chromeDriver, "");
        Steps.checkYandexResultMoreThanZeroNegative(pageObjectYandex.getCollectResults(), chromeDriver);
    }

    @Test
    @Description(value = "Тест что есть ссылка Гладиолус - Википедия")
    public void testPOYandexResultContains(){
        chromeDriver.get("https://www.yandex.ru/");
        PageObjectYandex pageObjectYandex = new PageObjectYandex(chromeDriver, "гладиолус");
        Steps.checkContainsName(pageObjectYandex.getCollectResults(),"Гладиолус - Википедия", chromeDriver);
    }

    @Test
    @Description(value = "Негативный Тест что есть ссылка Гладиолус - Википедия ")
    public void testPOYandexResultContainsNegative(){
        chromeDriver.get("https://www.yandex.ru/");
        PageObjectYandex pageObjectYandex = new PageObjectYandex(chromeDriver, "гладиолус");
        Steps.checkContainsNameNegative(pageObjectYandex.getCollectResults(),"Гладиолус — Википедия", chromeDriver);
    }

    @Test
    @Description(value = "В результате список больше трёх (PageFactory)")
    public void testPFYandexResultMoreThanThree(){
        chromeDriver.get("https://www.yandex.ru/search?text=" + "гладиолус");
        PageFactoryYandex pageFactoryYandex = PageFactory.initElements(chromeDriver,PageFactoryYandex.class);
        Steps.checkYandexResultMoreThanThree(pageFactoryYandex.getCollectResults(), chromeDriver);
    }

    @Test
    @Description(value = "Негативный тест: Список в результате не должен быть больше нуля (PageFactory)")
    public void testPFYandexResultMoreThanZeroNegative(){
        chromeDriver.get("https://www.yandex.ru/search?text=" + "");
        PageFactoryYandex pageFactoryYandex = PageFactory.initElements(chromeDriver,PageFactoryYandex.class);
        Steps.checkYandexResultMoreThanZeroNegative(pageFactoryYandex.getCollectResults(), chromeDriver);
    }

    @Test
    @Description(value = "Тест что есть ссылка Гладиолус - Википедия")
    public void testPFYandexResultContains(){
        chromeDriver.get("https://www.yandex.ru/search?text=" + "гладиолус");
        PageFactoryYandex pageFactoryYandex = PageFactory.initElements(chromeDriver,PageFactoryYandex.class);
        Steps.checkContainsName(pageFactoryYandex.getCollectResults(),"Гладиолус — Википедия", chromeDriver);
    }

    @Test
    @Description(value = "Негативный Тест что есть ссылка Гладиолус - Википедия ")
    public void testPFYandexResultContainsNegative(){
        chromeDriver.get("https://www.yandex.ru/search?text=" + "гладиолус");
        PageFactoryYandex pageFactoryYandex = PageFactory.initElements(chromeDriver,PageFactoryYandex.class);
        Steps.checkContainsNameNegative(pageFactoryYandex.getCollectResults(),"Гладиолус — Википедия", chromeDriver);
    }
}

