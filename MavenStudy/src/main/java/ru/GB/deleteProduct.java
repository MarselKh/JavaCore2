package ru.GB;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class deleteProduct {

    public static void main(String[] args) throws InterruptedException {
        //Предусловие: Добавить товар в корзину:
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
//        options.addArguments("--headless");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get("https://www.colins.ru/");
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,Duration.ofSeconds(3));
// Аутентификация:
        webDriver.findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        webDriver.findElement(By.cssSelector("#ins-responsive-banner > #wrap-close-button-1454703513202 span")).click();
        webDriver.findElement(By.xpath("//input[@id=\"LoginModel_Email\"]")).sendKeys("marsel-x@internet.ru");
        webDriver.findElement(By.xpath("//input[@id=\"LoginModel_Password\"]")).sendKeys("2k!Kiwy9yG9kG9M");
        webDriver.findElement(By.xpath("//input[@value=\"Войти в личный кабинет\"]")).click();
//Добавление товара в корзину:
        webDriver.findElement(By.xpath("//input[@id=\"TxtSearchBox\"]")).sendKeys("рубашка");
        webDriver.findElement(By.xpath("//input[@id=\"searchengine\"]")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"digi-shield\"]//a//img")));
        webDriver.findElement(By.xpath("//*[@id=\"digi-shield\"]//a/img")).click();
// Переключение на следующую вкладку:
        Set<String> windowHandles = webDriver.getWindowHandles();
        String currentWindowHandle = webDriver.getWindowHandle();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
//Добавление товара в корзину:
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"product-detail-size-container\"]//select")));
        webDriver.findElement(By.xpath("//div[@class=\"product-detail-size-container\"]//select")).click();
        webDriver.findElement(By.xpath("//option[contains(text(),'M') or contains(text(),'S') or contains(text(),'L')]")).click();
        webDriver.findElement(By.xpath("//a[@id=\"addtocartbutton\"]")).click();

// Удаление товара из корзины:
        webDriver.findElement(By.xpath("//img[@alt=\"cart-icon\"]")).click();
        webDriver.findElement(By.xpath("//span[contains(text(),'Удалить')]")).click();
        webDriver.findElement(By.id("btnYes")).click();

        webDriver.quit();

    }
}
