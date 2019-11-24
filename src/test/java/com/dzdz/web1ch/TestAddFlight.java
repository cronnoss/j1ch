package com.dzdz.web1ch;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

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
        try {
            driver.switchTo().activeElement();
            Thread.sleep(3000);
            driver.findElement(By.id("onesignal-popover-cancel-button")).click();
            Thread.sleep(3000);
        } finally {
            driver.findElement(By.cssSelector(".btn-toolbar > .btn-primary")).click();
            Thread.sleep(3000);
            driver.findElement(By.name("booking_ref")).click();
            driver.findElement(By.name("booking_ref")).sendKeys("TUZ2R7");
            driver.findElement(By.name("airline_code")).click();
            Thread.sleep(2000);
            driver.findElement(By.name("airline_code")).sendKeys("SU");
            Thread.sleep(2000);
            driver.findElement(By.name("airline_code")).sendKeys(Keys.DOWN);
            driver.findElement(By.name("airline_code")).sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            driver.findElement(By.name("airline_code")).click();
            Thread.sleep(2000);
            driver.findElement(By.cssSelector(".obj-flight")).click();
            driver.findElement(By.name("flight_num")).sendKeys("001");
            Thread.sleep(3000);
            driver.findElement(By.name("flight_date")).sendKeys("30.11.2019");
            Thread.sleep(3000);
            driver.findElement(By.name("flight_time")).sendKeys("16:18");
            Thread.sleep(3000);
            driver.findElement(By.name("arrival_time")).sendKeys("16:18");
            Thread.sleep(3000);
            driver.findElement(By.name("departure_code")).sendKeys("SVO");
            Thread.sleep(2000);
            driver.findElement(By.name("departure_code")).sendKeys(Keys.DOWN);
            driver.findElement(By.name("departure_code")).sendKeys(Keys.ENTER);
            Thread.sleep(2000);
            driver.findElement(By.name("destination_code")).sendKeys("JFK");
            Thread.sleep(2000);
            driver.findElement(By.name("destination_code")).sendKeys(Keys.DOWN);
            driver.findElement(By.name("destination_code")).sendKeys(Keys.ENTER);
            driver.findElement(By.cssSelector(".form-group > .btn")).click();
            driver.findElement(By.name("first_name")).click();
            driver.findElement(By.name("first_name")).sendKeys("Mark");
            driver.findElement(By.name("last_name")).sendKeys("Muler");
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(7000);
        }
    }
}