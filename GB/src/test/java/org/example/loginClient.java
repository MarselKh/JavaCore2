package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class loginClient {
    public static void main(String[] args)  {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
//        options.addArguments("--headless");

        WebDriver webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        webDriver.get("https://www.colins.ru/");
// Аутентификация:
        webDriver.findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        webDriver.findElement(By.cssSelector("#ins-responsive-banner > #wrap-close-button-1454703513202 span")).click();
        webDriver.findElement(By.xpath("//input[@id=\"LoginModel_Email\"]")).sendKeys("marsel-x@internet.ru");
        webDriver.findElement(By.xpath("//input[@id=\"LoginModel_Password\"]")).sendKeys("2k!Kiwy9yG9kG9M");
        webDriver.findElement(By.xpath("//input[@value=\"Войти в личный кабинет\"]")).click();

//      Thread.sleep(5000);
        webDriver.quit();
    }
}
