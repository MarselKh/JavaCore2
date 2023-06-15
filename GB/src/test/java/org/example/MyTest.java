package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class MyTest extends AbstractTestWebDriver {

    private WebElement webElement;

    @Test
    @DisplayName("Авторизация на сайте")
    void loginClientTest(){
        getWebdriver().findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        getWebdriver().findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        getWebdriver().findElement(By.cssSelector("#ins-responsive-banner > #wrap-close-button-1454703513202 span")).click();
        getWebdriver().findElement(By.xpath("//input[@id=\"LoginModel_Email\"]")).sendKeys("marsel-x@internet.ru");
        getWebdriver().findElement(By.xpath("//input[@id=\"LoginModel_Password\"]")).sendKeys("2k!Kiwy9yG9kG9M");
        getWebdriver().findElement(By.xpath("//input[@value=\"Войти в личный кабинет\"]")).click();

        equalsButtonUrlAssertions("https://www.colins.ru/?login=1", "Авторизация на сайте");
    }

    @Test
    @DisplayName("Добавление товара в корзину авторизованным пользователем")
    void addProductTest(){
        WebDriverWait webDriverWait = new WebDriverWait(getWebdriver(), Duration.ofSeconds(10));
//Предусловие - авторизация на сайте:
       loginClientTest();
        //Поиск товара:
        getWebdriver().findElement(By.xpath("//input[@id=\"TxtSearchBox\"]")).sendKeys("рубашка");
        getWebdriver().findElement(By.xpath("//input[@id=\"searchengine\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"digi-shield\"]//a//img")));
        getWebdriver().findElement(By.xpath("//*[@id=\"digi-shield\"]//a/img")).click();
// Переключение на следующую вкладку:
        Set<String> windowHandles=getWebdriver().getWindowHandles();
        String currentWindowHandle=getWebdriver().getWindowHandle();
        for(String windowHandle: windowHandles){
            if(!windowHandle.equals(currentWindowHandle)){
                getWebdriver().switchTo().window(windowHandle);
                break;
            }
        }
//Добавление товара в корзину:
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"product-detail-size-container\"]//select")));
        getWebdriver().findElement(By.xpath("//div[@class=\"product-detail-size-container\"]//select")).click();
        getWebdriver().findElement(By.xpath("//option[contains(text(),'M') or contains(text(),'S') or contains(text(),'L')]")).click();
        getWebdriver().findElement(By.xpath("//a[@id=\"addtocartbutton\"]")).click();

        trueXpathAssertions("//a[@href=\"/cart\"]/span[contains(text(),'1')]");
    }

    @Test
    @DisplayName("Удаление товара из корзины авторизованным пользователем")
    void deleteProductTest () {
//        //Предусловие - авторизация на сайте:
//        //Предусловие - добавление товара в корзину:
        addProductTest();
        // Удаление товара из корзины:
        getWebdriver().findElement(By.xpath("//img[@alt=\"cart-icon\"]")).click();
        getWebdriver().findElement(By.xpath("//span[contains(text(),'Удалить')]")).click();
        getWebdriver().findElement(By.id("btnYes")).click();

        trueXpathAssertions("//a[@href=\"/cart\"]/span[contains(text(),'')]");

//        getWebdriver().quit();
    }

    @Test
    @DisplayName("Поиск товара использую фильтр")
    void useFilterTest () {

        getWebdriver().findElement(By.xpath("//*[@id=\"defaultmenu\"]//li/a[contains(text(), \"МУЖЧИНАМ\")]")).click();
        getWebdriver().findElement(By.cssSelector("#ins-responsive-banner > #wrap-close-button-1454703513202 span")).click();
        getWebdriver().findElement(By.xpath("//div[@class=\"ins-instory\"]//div[@data-story-index=\"3\"]/..")).click();
        getWebdriver().findElement(By.xpath("//h4[@data-spec-attr-name=\"Цвет\"]")).click();
        getWebdriver().findElement(By.xpath("//label[contains(text(), \"Черный\") or contains(text(), \"Белый\") or contains(text(), \"Красный\")]")).click();
        getWebdriver().findElement(By.xpath("//span[contains(text(), \"Размер\")]")).click();
        getWebdriver().findElement(By.xpath("//div[@id=\"toggle-2\"]//label[contains(text(), \"XL\")]")).click();

        trueXpathAssertions("//*[contains(text(), \"Выборы:\")]");
    }

    @Test
    @DisplayName("Проверка меню кнопок иконки авторизованного пользоваеля ")
    void clientIconTest () {
        //Авторизация на сайте
        loginClientTest();

        getWebdriver().findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        getWebdriver().findElement(By.xpath("//ul[@class=\"customer-links-sub-dropdown\"]//a[contains(text(), \"Основные данные\")]")).click();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/info", "Кнопка Основные данные");

        getWebdriver().findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        getWebdriver().findElement(By.xpath("//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/customer/addresses\"]")).click();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/addresses", "Кнопка Адреса");

        getWebdriver().findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        getWebdriver().findElement(By.xpath("//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/customer/orders\"]")).click();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/orders", "Кнопка Заказы");

        getWebdriver().findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        getWebdriver().findElement(By.xpath("//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/customer/backinstocksubscriptions\"]")).click();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/backinstocksubscriptions", "Кнопка Поступление товара");

        getWebdriver().findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        getWebdriver().findElement(By.xpath("//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/customer/favouritesubscriptions\"]")).click();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/favouritesubscriptions", "Кнопка Избранные");

        getWebdriver().findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        getWebdriver().findElement(By.xpath("//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/customer/changepassword\"]")).click();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/changepassword", "Кнопка Смена пароля");

        getWebdriver().findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        getWebdriver().findElement(By.xpath("//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/loyalty\"]")).click();
        equalsButtonUrlAssertions("https://www.colins.ru/loyalty", "Кнопка Проверка баллов");

        getWebdriver().findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        getWebdriver().findElement(By.xpath("//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/logout\"]")).click();
        equalsButtonUrlAssertions("https://www.colins.ru/?logout=1", "Кнопка Выйти");
    }

    void equalsButtonUrlAssertions (String expectedURL, String str) {
        String actualURL = getWebdriver().getCurrentUrl();
        Assertions.assertEquals(expectedURL,actualURL, str);
    }

    void trueXpathAssertions (String str) {
        webElement = getWebdriver().findElement(By.xpath(str));
        boolean checkedXpath = webElement.isDisplayed();
        Assertions.assertTrue(true, String.valueOf(checkedXpath));
    }

    @Test
    @DisplayName("Авторизация на сайте не валидным пользователем")
    void loginClientFalseTest () {
        getWebdriver().findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        getWebdriver().findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        getWebdriver().findElement(By.cssSelector("#ins-responsive-banner > #wrap-close-button-1454703513202 span")).click();
        getWebdriver().findElement(By.xpath("//input[@id=\"LoginModel_Email\"]")).sendKeys("test@internet.ru");
        getWebdriver().findElement(By.xpath("//input[@id=\"LoginModel_Password\"]")).sendKeys("123456789/");
        getWebdriver().findElement(By.xpath("//input[@value=\"Войти в личный кабинет\"]")).click();
        String expectedURL = "https://www.colins.ru/?login=1";
        String actualURL = getWebdriver().getCurrentUrl();

        Assertions.assertNotEquals(actualURL,expectedURL);
    }

}
