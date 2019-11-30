package com.dzdz.web1ch.appmanager;

import com.dzdz.web1ch.model.FlightData;
import org.openqa.selenium.*;

public class FlightHelper {
    private WebDriver driver;

    FlightHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void initFlightCreation() throws InterruptedException {
        try {
            driver.findElement(By.xpath("//button[@data-bind='btn-main-add']")).click();
            Thread.sleep(2000);
        } catch (TimeoutException ex) {
            driver.findElement(By.cssSelector(".btn-toolbar > .btn-primary")).click();
            Thread.sleep(2000);
        }
    }

    public void fillFlightForm(FlightData flightData) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.name("booking_ref")).click();
        driver.findElement(By.name("booking_ref")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("booking_ref")).sendKeys(flightData.getPnr());

        driver.findElement(By.name("airline_code")).click();
        driver.findElement(By.name("airline_code")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("airline_code")).sendKeys(flightData.getAirlineCode());
        Thread.sleep(2000);
        driver.findElement(By.name("airline_code")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("airline_code")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("flight_num")).click();
        driver.findElement(By.name("flight_num")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("flight_num")).sendKeys(flightData.getFlightNum());

        driver.findElement(By.name("flight_date")).click();
        driver.findElement(By.name("flight_date")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("flight_date")).sendKeys(flightData.getDate());

        driver.findElement(By.name("flight_time")).click();
        driver.findElement(By.name("flight_time")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("flight_time")).sendKeys(flightData.getFlightTime());

        driver.findElement(By.name("arrival_time")).click();
        driver.findElement(By.name("arrival_time")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("arrival_time")).sendKeys(flightData.getArrivalTime());

        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(3000);

        driver.findElement(By.name("departure_code")).click();
        driver.findElement(By.name("departure_code")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("departure_code")).sendKeys(flightData.getDeparture());
        Thread.sleep(2000);
        driver.findElement(By.name("departure_code")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("departure_code")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("destination_code")).click();
        driver.findElement(By.name("destination_code")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("destination_code")).sendKeys(flightData.getDestination());
        Thread.sleep(2000);
        driver.findElement(By.name("destination_code")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("destination_code")).sendKeys(Keys.ENTER);

        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,' Add new passenger')]")).click();
        Thread.sleep(1000);

        driver.findElement(By.name("first_name")).click();
        driver.findElement(By.name("first_name")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("first_name")).sendKeys(flightData.getFirstName());

        driver.findElement(By.name("last_name")).click();
        driver.findElement(By.name("last_name")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("last_name")).sendKeys(flightData.getLastName());
        Thread.sleep(1000);
    }

    public void submitFlightCreation() throws InterruptedException {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
    }

    public void openFlightForEditing() throws InterruptedException {
        driver.findElement(By.cssSelector(".card:nth-child(1) > .card-wrap > .header svg")).click();
        Thread.sleep(3000);
    }

    public void deleteEditableFlight() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,' Delete')]")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
}
