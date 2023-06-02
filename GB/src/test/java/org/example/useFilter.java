package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class useFilter {

    public static void main (String [] args) {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get("https://www.colins.ru/");

        //Поиск товара используя фильтр:
        webDriver.findElement(By.xpath("//*[@id=\"defaultmenu\"]//li/a[contains(text(), \"МУЖЧИНАМ\")]")).click();
        webDriver.findElement(By.cssSelector("#ins-responsive-banner > #wrap-close-button-1454703513202 span")).click();
        webDriver.findElement(By.xpath("//div[@class=\"ins-instory\"]//div[@data-story-index=\"3\"]/..")).click();
        webDriver.findElement(By.xpath("//h4[@data-spec-attr-name=\"Цвет\"]")).click();
        webDriver.findElement(By.xpath("//label[contains(text(), \"Черный\") or contains(text(), \"Белый\") or contains(text(), \"Красный\")]")).click();
        webDriver.findElement(By.xpath("//span[contains(text(), \"Размер\")]")).click();
        webDriver.findElement(By.xpath("//div[@id=\"toggle-2\"]//label[contains(text(), \"XL\")]")).click();

        webDriver.quit();
    }
}
