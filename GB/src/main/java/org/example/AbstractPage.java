package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public abstract class AbstractPage {
    private WebDriver webdriver;

    public AbstractPage (WebDriver webdriver) {
        this.webdriver = webdriver;
        PageFactory.initElements(webdriver,this);
    }

    protected WebDriver getWebdriver() {
        return this.webdriver;
    }
}
