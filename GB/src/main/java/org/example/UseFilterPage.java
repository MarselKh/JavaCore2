package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UseFilterPage extends AbstractPage {

    @FindBy(xpath="//*[@id=\"defaultmenu\"]//li/a[contains(text(), \"МУЖЧИНАМ\")]")
    private WebElement mensButton;

    @FindBy(css="#ins-responsive-banner > #wrap-close-button-1454703513202 span")
    private WebElement closeBanner;

    @FindBy(xpath="//div[@class=\"ins-instory\"]//div[@data-story-index=\"3\"]/..")
    private WebElement elementShorts;

    @FindBy(xpath="//h4[@data-spec-attr-name=\"Цвет\"]")
    private WebElement colorBox;

    @FindBy(xpath="//label[contains(text(), \"Черный\") or contains(text(), \"Белый\") or contains(text(), \"Красный\")]")
    private WebElement selectColor;

    @FindBy (xpath="//span[contains(text(), \"Размер\")]")
    private WebElement sizeBox;

    @FindBy (xpath="//div[@id=\"toggle-2\"]//label[contains(text(), \"XL\")]")
    private WebElement selectSize;

    public UseFilterPage(WebDriver webdriver) {
        super(webdriver);
    }

    public UseFilterPage clickMensButton () {
        mensButton.click();
        return this;
    }

    public UseFilterPage clickCloseBanner () {
        closeBanner.click();
        return this;
    }

    public UseFilterPage clickElementShorts () {
        elementShorts.click();
        return this;
    }

    public UseFilterPage clickColorBox () {
        colorBox.click();
        return this;
    }

    public UseFilterPage selectColor () {
        selectColor.click();
        return this;
    }

    public UseFilterPage clickSizeBox () {
        sizeBox.click();
        return this;
    }

    public UseFilterPage selectSize () {
        selectSize.click();
        return this;
    }
}
