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
        login("test9161@yahoo.com", "UbSme!pvy");
        gotoHome();
        initFlightCreation();
        fillFlightForm("TUZ2R7", "LH", "001", "20191231", "1700", "1800", "TXL", "JFK", "Greta", "Garbo");
        submitFlightCreation();
        Assert.assertNotNull(driver.findElement(By.xpath("//div[@data-class='thread']")));
    }

    private void login(String email, String password) throws InterruptedException {
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector(".btn-default:nth-child(2)")).click();
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).sendKeys(password);
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

    private void initFlightCreation() throws InterruptedException {
        try {
            driver.findElement(By.xpath("//button[@data-bind='btn-main-add']")).click();
            Thread.sleep(2000);
        } catch (TimeoutException ex) {
            driver.findElement(By.cssSelector(".btn-toolbar > .btn-primary")).click();
            Thread.sleep(2000);
        }
    }

    private void fillFlightForm(String pnr, String airlineCode, String flightNum, String date, String flightTime, String arrivalTime, String departure, String destination, String firstName, String lastName) throws InterruptedException {
        driver.findElement(By.name("booking_ref")).click();
        driver.findElement(By.name("booking_ref")).sendKeys(pnr);
        driver.findElement(By.name("airline_code")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("airline_code")).sendKeys(airlineCode);
        Thread.sleep(4000);
        driver.findElement(By.name("airline_code")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("airline_code")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".obj-flight")).click();
        driver.findElement(By.name("flight_num")).sendKeys(flightNum);
        driver.findElement(By.name("flight_date")).sendKeys(date);
        Thread.sleep(1000);
        driver.findElement(By.name("flight_time")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("flight_time")).clear();
        driver.findElement(By.name("flight_time")).sendKeys(flightTime);
        driver.findElement(By.name("arrival_time")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("arrival_time")).clear();
        driver.findElement(By.name("arrival_time")).sendKeys(arrivalTime);
        Thread.sleep(4000);
        driver.findElement(By.name("departure_code")).sendKeys(departure);
        Thread.sleep(3000);
        driver.findElement(By.name("departure_code")).sendKeys(Keys.DOWN);
        Thread.sleep(2000);
        driver.findElement(By.name("departure_code")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.name("destination_code")).sendKeys(destination);
        Thread.sleep(5000);
        driver.findElement(By.name("destination_code")).sendKeys(Keys.DOWN);
        Thread.sleep(2000);
        driver.findElement(By.name("destination_code")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".form-group > .btn")).click();
        driver.findElement(By.name("first_name")).click();
        driver.findElement(By.name("first_name")).sendKeys(firstName);
        driver.findElement(By.name("last_name")).sendKeys(lastName);
        Thread.sleep(1000);
    }

    private void submitFlightCreation() throws InterruptedException {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
    }
}