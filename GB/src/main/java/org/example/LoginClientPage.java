package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginClientPage extends AbstractPage {
    @FindBy(xpath="//img[@alt=\"user-icon\"]")
    private WebElement userIcon;

    @FindBy(xpath="//a[contains(text(),'Войти')]")
    private WebElement buttonLoginIcon;

    @FindBy(css="#ins-responsive-banner > #wrap-close-button-1454703513202 span")
    private WebElement closeBanner;

    @FindBy(xpath="//input[@id=\"LoginModel_Email\"]")
    private WebElement loginEmail;

    @FindBy(xpath="//input[@id=\"LoginModel_Password\"]")
    private WebElement loginPassword;

    @FindBy(xpath="//input[@value=\"Войти в личный кабинет\"]")
    private WebElement loginSubmit;

    public LoginClientPage(WebDriver webdriver) {
        super(webdriver);
    }

    public LoginClientPage clickUserIcon () {
        userIcon.click();
        return this;
    }

    public LoginClientPage clickButtonLoginIcon () {
        buttonLoginIcon.click();
        return this;
    }

    public LoginClientPage clickCloseBanner () {
        closeBanner.click();
        return this;
    }

    public LoginClientPage setLoginEmail (String loginEmail) {
        this.loginEmail.sendKeys(loginEmail);
        return this;
    }

    public LoginClientPage setLoginPassword (String loginPassword) {
        this.loginPassword.sendKeys(loginPassword);
        return this;
    }

    public void clickLoginSubmit () {
        this.loginSubmit.click();
    }

}
