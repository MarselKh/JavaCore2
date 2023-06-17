package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AddProductPage extends AbstractPage {
    @FindBy(xpath="//input[@id=\"TxtSearchBox\"]")
    private WebElement searchBox;

    @FindBy(xpath="//input[@id=\"searchengine\"]")
    private WebElement searchEngine;

    @FindBy(xpath="//*[@id=\"digi-shield\"]//a/img[1]")
    private WebElement result;

    @FindBy(xpath="//div[@class=\"product-detail-size-container\"]//select")
    private WebElement select;

    @FindBy(xpath="//option[contains(text(),'M') or contains(text(),'S') or contains(text(),'L')]")
    private WebElement sizeSelect;

    @FindBy(xpath="//a[@id=\"addtocartbutton\"]")
    private WebElement submitAdd;

    public AddProductPage(WebDriver webdriver) {
        super(webdriver);
    }

    public AddProductPage setSearch(String search) {
        this.searchBox.sendKeys(search);
        return this;
    }

    public AddProductPage clickSearchEngine() {
        this.searchEngine.click();
        return this;
    }

    public AddProductPage clickResult() {
        //       new WebDriverWait(getWebdriver(), Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(result))));
        new WebDriverWait(getWebdriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(result)).click();
        this.result.click();
        return this;
    }

    public AddProductPage clickSelect() {
        new WebDriverWait(getWebdriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(select)).click();
        this.select.click();
        return this;
    }

    public AddProductPage clickSizeSelect() {
        this.sizeSelect.click();
        return this;
    }

    public AddProductPage clickSubmitAdd() {
        this.submitAdd.click();
        return this;
    }

    public AddProductPage switchTab() {
        Set<String> windowHandles=getWebdriver().getWindowHandles();
        String currentWindowHandle=getWebdriver().getWindowHandle();
        for(String windowHandle: windowHandles){
            if(!windowHandle.equals(currentWindowHandle)){
                getWebdriver().switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }
}
