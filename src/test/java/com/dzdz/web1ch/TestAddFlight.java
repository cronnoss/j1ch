package com.dzdz.web1ch;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class TestAddFlight extends TestJUnitTestBase {

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

        driver.findElement(By.cssSelector(".btn-toolbar > .btn-primary")).click();
        Thread.sleep(6000);
        driver.findElement(By.name("booking_ref")).click();
        driver.findElement(By.name("booking_ref")).sendKeys("TTTTTT");
        driver.findElement(By.name("airline_code")).click();
        driver.findElement(By.name("airline_code")).sendKeys("SU: Aeroflot");
        Thread.sleep(5000);
        {
            WebElement element = driver.findElement(By.cssSelector(".selected"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        Thread.sleep(5000);
    }
}