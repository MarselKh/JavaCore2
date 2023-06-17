package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ClientIconPage extends AbstractPage {

    @FindBy(xpath="//img[@alt=\"user-icon\"]")
    private WebElement userIcon;

    @FindBy(xpath="//ul[@class=\"customer-links-sub-dropdown\"]//a[contains(text(), \"Основные данные\")]")
    private WebElement basicDate;

    @FindBy(xpath="//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/customer/addresses\"]")
    private WebElement addresses;

    @FindBy(xpath="//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/customer/orders\"]")
    private WebElement orders;

    @FindBy(xpath="//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/customer/backinstocksubscriptions\"]")
    private WebElement incomingGoods;

    @FindBy(xpath="//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/customer/favouritesubscriptions\"]")
    private WebElement favourite;

    @FindBy(xpath="//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/customer/changepassword\"]")
    private WebElement changePassword;

    @FindBy(xpath="//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/loyalty\"]")
    private WebElement loyalty;

    @FindBy(xpath="//ul[@class=\"customer-links-sub-dropdown\"]//a[@href=\"/logout\"]")
    private WebElement logout;

    public ClientIconPage(WebDriver webdriver) {
        super(webdriver);
    }

    public ClientIconPage clickUserIcon () {
        userIcon.click();
        return this;
    }

    public ClientIconPage clickBasicDate() {
        basicDate.click();
        return this;
    }

    public ClientIconPage clickAddresses() {
        addresses.click();
        return this;
    }

    public ClientIconPage clickOrders() {
        orders.click();
        return this;
    }

    public ClientIconPage clickIncomingGoods() {
        incomingGoods.click();
        return this;
    }

    public ClientIconPage clickFavourite() {
        favourite.click();
        return this;
    }

    public ClientIconPage clickChangePassword() {
        changePassword.click();
        return this;
    }

    public ClientIconPage clickLoyalty() {
        loyalty.click();
        return this;
    }

    public ClientIconPage clickLogout() {
        logout.click();
        return this;
    }
}
