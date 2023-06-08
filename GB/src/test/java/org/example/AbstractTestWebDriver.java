package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public abstract class AbstractTestWebDriver {

    public static WebDriver webdriver;
    public static long Timeout = 10;

    @BeforeAll
    static void setupOptionsWebDriver() {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
 //       options.addArguments("--headless");
 //       options.addArguments("--remote-allow-origins=*");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(Timeout, TimeUnit.SECONDS);
    }

//    @BeforeEach
//    void goTo() {
//        webdriver.get("https://www.colins.ru/");
////        System.setProperty("webdriver.http.factory", "jdk-http-client");
////        Assertions.assertDoesNotThrow(() -> webdriver.navigate().to("https://www.colins.ru/"),
////                "Страница не доступна");
//    }

    @AfterAll
    static void closeWebDriver() {
 //       webdriver.quit();
    }

    public static WebDriver getWebdriver() {
        return webdriver;
    }
}
