package ru.GB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class addProduct {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver,Duration.ofSeconds(25));

        //Предусловие:
        driver.get("https://www.colins.ru/LoginRegister");
        driver.findElement(By.xpath("//input[@id=\"LoginModel_Email\"]")).sendKeys("marsel-x@internet.ru");
        driver.findElement(By.xpath("//input[@id=\"LoginModel_Password\"]")).sendKeys("2k!Kiwy9yG9kG9M");
        driver.findElement(By.xpath("//input[@value=\"Войти в личный кабинет\"]")).click();
        driver.findElement(By.id("TxtSearchBox")).sendKeys("Рубашка");
        driver.findElement(By.id("searchengine")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@alt,'Cl1041746')]")));
        driver.findElement(By.xpath("//img[contains(@alt,'Cl1041746')]")).click();

        driver.findElement(By.xpath("//option[contains(text(),'Выбрать')]")).click();
        driver.findElement(By.xpath("//option[contains(text(),'S')]")).click();
        driver.findElement(By.id("addtocartbutton")).click();

        Thread.sleep(5000);
        driver.quit();


    }
}
