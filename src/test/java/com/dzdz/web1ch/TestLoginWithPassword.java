package com.dzdz.web1ch;

import org.junit.Test;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class TestLoginWithPassword extends TestJUnitTestBase {

    @Test
    public void loginWithPassword() throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".btn-default:nth-child(2)")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("test9161@yahoo.com");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys("UbSme!pvy");
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-block']")).click();
        Thread.sleep(5000);
        driver.switchTo().activeElement();
        Thread.sleep(5000);
        driver.findElement(By.id("onesignal-popover-cancel-button")).click();
        Thread.sleep(5000);
    }
}