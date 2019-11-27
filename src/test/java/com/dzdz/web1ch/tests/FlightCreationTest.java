package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.TestJUnitTestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;

import java.util.concurrent.TimeUnit;

public class FlightCreationTest extends TestJUnitTestBase {

    @Test
    public void testFlightCreation() throws InterruptedException {
        login();
        gotoHome();
        try {
            initFlightCreation(By.xpath("//button[@data-bind='btn-main-add']"), 2000);
        } catch (TimeoutException ex) {
            initFlightCreation(By.cssSelector(".btn-toolbar > .btn-primary"), 2000);
        }
        driver.findElement(By.name("booking_ref")).click();
        driver.findElement(By.name("booking_ref")).sendKeys("TUZ2R7");
        driver.findElement(By.name("airline_code")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("airline_code")).sendKeys("SU");
        Thread.sleep(3000);
        driver.findElement(By.name("airline_code")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("airline_code")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".obj-flight")).click();
        driver.findElement(By.name("flight_num")).sendKeys("001");
        driver.findElement(By.name("flight_date")).sendKeys("20191231");
        Thread.sleep(1000);
        driver.findElement(By.name("flight_time")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("flight_time")).clear();
        driver.findElement(By.name("flight_time")).sendKeys("1700");
        driver.findElement(By.name("arrival_time")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("arrival_time")).clear();
        driver.findElement(By.name("arrival_time")).sendKeys("1800");
        Thread.sleep(2000);
        driver.findElement(By.name("departure_code")).sendKeys("Sheremetyevo");
        Thread.sleep(3000);
        driver.findElement(By.name("departure_code")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.name("departure_code")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.name("destination_code")).sendKeys("JFK");
        Thread.sleep(3000);
        driver.findElement(By.name("destination_code")).sendKeys(Keys.DOWN);
        Thread.sleep(1000);
        driver.findElement(By.name("destination_code")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(".form-group > .btn")).click();
        driver.findElement(By.name("first_name")).click();
        driver.findElement(By.name("first_name")).sendKeys("Greta");
        driver.findElement(By.name("last_name")).sendKeys("Garbo");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
        Assert.assertNotNull(driver.findElement(By.xpath("//div[@data-class='thread']")));
    }

    private void initFlightCreation(By by, int i) throws InterruptedException {
        driver.findElement(by).click();
        Thread.sleep(i);
    }

    private void login() throws InterruptedException {
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
            //close popUpWindow
            driver.switchTo().activeElement();
            driver.findElement(By.id("onesignal-popover-cancel-button")).click();
            Thread.sleep(2000);
        } finally {
            gotoHome();
        }
    }

    private void gotoHome() throws InterruptedException {
        driver.findElement(By.xpath("(//span[@class='menu-label'])[1]")).click();
        Thread.sleep(2000);
    }
}