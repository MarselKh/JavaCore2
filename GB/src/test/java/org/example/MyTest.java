package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.By;

public class MyTest extends AbstractTestWebDriver {

    @Test
    void test () {
        {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        Assertions.assertDoesNotThrow(() -> webdriver.navigate().to("https://www.colins.ru/"),
                "Страница не доступна");
    }
    }

    @Test
    @DisplayName("Верификация на сайте")
    void loginClient(){
 //       getWebdriver().get("https://www.colins.ru/");
        AbstractTestWebDriver.getWebdriver().findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        AbstractTestWebDriver.getWebdriver().findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        AbstractTestWebDriver.getWebdriver().findElement(By.cssSelector("#ins-responsive-banner > #wrap-close-button-1454703513202 span")).click();
        AbstractTestWebDriver.getWebdriver().findElement(By.xpath("//input[@id=\"LoginModel_Email\"]")).sendKeys("marsel-x@internet.ru");
        AbstractTestWebDriver.getWebdriver().findElement(By.xpath("//input[@id=\"LoginModel_Password\"]")).sendKeys("2k!Kiwy9yG9kG9M");
        AbstractTestWebDriver.getWebdriver().findElement(By.xpath("//input[@value=\"Войти в личный кабинет\"]")).click();
    }


}
