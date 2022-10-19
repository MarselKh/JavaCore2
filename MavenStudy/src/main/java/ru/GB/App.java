package ru.GB;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class App
{
    public static void main( String[] args ){

        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("https://www.colins.ru/");

        webDriver.findElement(By.xpath("//img[@alt=\"user-icon\"]")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'Войти')]")).click();
        webDriver.findElement(By.xpath("//input[@id=\"LoginModel_Email\"]")).sendKeys("marsel-x@internet.ru");
        webDriver.findElement(By.xpath("//input[@id=\"LoginModel_Password\"]")).sendKeys("2k!Kiwy9yG9kG9M");
        webDriver.findElement(By.xpath("//input[@value=\"Войти в личный кабинет\"]")).click();
    }
}
