package com.dzdz.web1ch.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SessionHelper {
    private WebDriver driver;

    SessionHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".btn-default:nth-child(2)")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
        Thread.sleep(5000);
        try {
            driver.switchTo().activeElement();
            driver.findElement(By.id("onesignal-popover-cancel-button")).click();
            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException for PopUp window");
        }
    }
}
