package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    void equalsButtonUrlAssertions (String expectedURL, String str) {
        String actualURL = getWebdriver().getCurrentUrl();
        Assertions.assertEquals(expectedURL,actualURL, str);
    }

    void trueXpathAssertions (String str) {
        WebElement webElement = getWebdriver().findElement(By.xpath(str));
        boolean checkedXpath = webElement.isDisplayed();
        Assertions.assertTrue(true, String.valueOf(checkedXpath));
    }

    public static WebDriver getWebdriver() {
        return webdriver;
    }
}
