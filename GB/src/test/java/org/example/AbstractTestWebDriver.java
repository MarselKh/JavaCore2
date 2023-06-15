package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTestWebDriver {

    public static WebDriver webdriver;
    public static long time = 10L;

    @BeforeAll
    static void setupOptionsWebDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
 //       options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");

        webdriver = new ChromeDriver(options);
        webdriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);

    }

    @BeforeEach
    void goTo() {
        Assertions.assertDoesNotThrow(() -> webdriver.navigate().to("https://www.colins.ru/"));
    }

    @AfterAll
    static void closeWebDriver() {
 //       webdriver.quit();
    }

    public static WebDriver getWebdriver() {
        return webdriver;
    }
}
