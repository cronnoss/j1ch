package com.dzdz.web1ch.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SessionHelper extends HelperBase {

    SessionHelper(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".btn-default:nth-child(2)")).click();
        type(By.name("email"), email);
        type(By.name("password"), password);
        click(By.xpath("//button[@class='btn btn-primary btn-block']"));
        Thread.sleep(2000);
        try {
            driver.switchTo().activeElement();
            click(By.id("onesignal-popover-cancel-button"));
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException for PopUp window");
        }
    }
}
