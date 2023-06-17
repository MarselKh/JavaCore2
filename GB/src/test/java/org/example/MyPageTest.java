package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyPageTest extends AbstractTestWebDriver{

    @Test
    @DisplayName("Авторизация на сайте")
    void loginPageTest () {
        LoginClientPage loginClientPage = new LoginClientPage(getWebdriver());
        loginClientPage
                .clickUserIcon()
                .clickButtonLoginIcon()
                .clickCloseBanner()
                .setLoginEmail("marsel-x@internet.ru")
                .setLoginPassword("2k!Kiwy9yG9kG9M")
                .clickLoginSubmit();

        equalsButtonUrlAssertions("https://www.colins.ru/?login=1","Авторизация на сайте");
    }

    @Test
    @DisplayName("Добавление товара в корзину авторизованным пользователем")
    void addProductPageTest () {
        //Предусловие - авторизация на сайте:
        loginPageTest();
        //Поиск товара:
        AddProductPage addProductPage = new AddProductPage(webdriver);
        addProductPage
                .setSearch("Рубашка")
                .clickSearchEngine()
                .clickResult()
                .switchTab()
                .clickSelect()
                .clickSizeSelect()
                .clickSubmitAdd();

        trueXpathAssertions("//a[@href=\"/cart\"]/span[contains(text(),'1') or contains(text(),'2') or contains(text(),'3')]");
    }

    @Test
    @DisplayName("Удаление товара из корзины авторизованным пользователем")
    void deleteProductPageTest () {
        //Предусловие - авторизация на сайте:
        //Предусловие - добавление товара в корзину:
        addProductPageTest();
        // Удаление товара из корзины:
        DeleteProductPage deleteProductPage = new DeleteProductPage(webdriver);
        deleteProductPage
                .clickUserIcon()
                .clickDeleteButton()
                .clickYesButton();

        trueXpathAssertions("//a[@href=\"/cart\"]/span[contains(text(),'')]");
    }

    @Test
    @DisplayName("Поиск товара использую фильтр")
    void useFilterPageTest () {
        UseFilterPage useFilterPage = new UseFilterPage(webdriver);
        useFilterPage
                .clickMensButton()
                .clickCloseBanner()
                .clickElementShorts()
                .clickSizeBox()
                .selectColor()
                .clickSizeBox()
                .selectSize();

        trueXpathAssertions("//*[contains(text(), \"Выборы:\")]");
    }

    @Test
    @DisplayName("Проверка меню кнопок иконки авторизованного пользоваеля ")
    void clientIconPageTest () {
        //Предусловие - авторизация на сайте:
        loginPageTest();

        ClientIconPage clientIconPage= new ClientIconPage(webdriver);
        clientIconPage
                .clickUserIcon()
                .clickBasicDate();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/info", "Кнопка Основные данные");

        clientIconPage
                .clickUserIcon()
                .clickAddresses();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/addresses", "Кнопка Адреса");

        clientIconPage
                .clickUserIcon()
                .clickOrders();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/orders", "Кнопка Заказы");

        clientIconPage
                .clickUserIcon()
                .clickIncomingGoods();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/backinstocksubscriptions", "Кнопка Поступление товара");

        clientIconPage
                .clickUserIcon()
                .clickFavourite();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/favouritesubscriptions", "Кнопка Избранные");

        clientIconPage
                .clickUserIcon()
                .clickChangePassword();
        equalsButtonUrlAssertions("https://www.colins.ru/customer/changepassword", "Кнопка Смена пароля");

        clientIconPage
                .clickUserIcon()
                .clickLoyalty();
        equalsButtonUrlAssertions("https://www.colins.ru/loyalty", "Кнопка Проверка баллов");

        clientIconPage
                .clickUserIcon()
                .clickLogout();
        equalsButtonUrlAssertions("https://www.colins.ru/?logout=1", "Кнопка Выйти");
    }

    @Test
    @DisplayName("Авторизация на сайте не валидным пользователем")
    void loginClientFalsePageTest () {
        LoginClientPage loginClientPage = new LoginClientPage(getWebdriver());
        loginClientPage
                .clickUserIcon()
                .clickButtonLoginIcon()
                .clickCloseBanner()
                .setLoginEmail("test@internet.ru")
                .setLoginPassword("123456789/")
                .clickLoginSubmit();

        String expectedURL = "https://www.colins.ru/?login=1";
        String actualURL = getWebdriver().getCurrentUrl();

        Assertions.assertNotEquals(actualURL,expectedURL);
    }

}
