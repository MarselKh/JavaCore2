package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProductPage extends AbstractPage {

    @FindBy(xpath="//img[@alt=\"cart-icon\"]")
    private WebElement userIcon;

    @FindBy(xpath="//span[contains(text(),'Удалить')]")
    private WebElement deleteButton;

    @FindBy(id="btnYes")
    private WebElement yesButton;

    public DeleteProductPage(WebDriver webdriver) {
        super(webdriver);
    }

    public DeleteProductPage clickUserIcon () {
        userIcon.click();
        return this;
    }

    public DeleteProductPage clickDeleteButton () {
        deleteButton.click();
        return this;
    }

    public DeleteProductPage clickYesButton () {
        yesButton.click();
        return this;
    }
}
