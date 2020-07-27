package practica;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class Steps {

    @Step("Шаг 1. Проверка наличия имени: {name}")
//    public static void checkContainsName(List<Map<String,Object>> resultSearch, String name, WebDriver driver){
    public static void checkContainsName(List<String> resultSearch, String name, WebDriver driver){
        if(resultSearch.stream().anyMatch(x -> x.contains(name))){
            Assertions.assertTrue(true);
        }
        else {
            CustomUtils.getScreen(driver);
            Assertions.assertTrue(false,"Не найдено: "+ name);
        }
    }

//    @Step("Шаг 2. Перейдём по ссылке с текстом {textTitle}")
   /* @Step("Шаг 2. Проверка длыны списка с результатом поиска по слову {textTitle} больше трех ")
    public static void checkLenghtResultMoreThanThree(PageObjectGoogleWithSearch googleWithSearch, String textTitle){
        Assertions.assertTrue(googleWithSearch.goPage(textTitle), "Страница "+textTitle+" не найдена");
    }*/



}
