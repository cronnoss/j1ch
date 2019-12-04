package com.dzdz.web1ch.appmanager;

import com.dzdz.web1ch.model.FlightData;
import org.openqa.selenium.*;

import java.awt.*;

public class FlightHelper extends HelperBase {

    FlightHelper(WebDriver driver) {
        super(driver);
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

    public void fillFlightForm(FlightData flightData) throws InterruptedException, AWTException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement bookingRef = driver.findElement(By.name("booking_ref"));
        js.executeScript("arguments[0].scrollIntoView();", bookingRef);
        js.executeScript("window.scrollBy(0,-90)");

        type(By.name("booking_ref"), flightData.getPnr());
        type(By.name("airline_code"), flightData.getAirlineCode());
        downEnter(By.name("airline_code"));

        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);

        type(By.name("flight_num"), flightData.getFlightNum());
        type(By.name("flight_date"), flightData.getDate());
        keyTab();

        driver.findElement(By.name("flight_time")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.name("flight_time")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("flight_time")).sendKeys(flightData.getFlightTime());

        driver.findElement(By.name("arrival_time")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.name("arrival_time")).sendKeys(Keys.DELETE);
        driver.findElement(By.name("arrival_time")).sendKeys(flightData.getArrivalTime());
        keyTab();

        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(3000);

        type(By.name("departure_code"), flightData.getDeparture());
        downEnter(By.name("departure_code"));

        WebElement destinationCode = driver.findElement(By.name("destination_code"));
        js.executeScript("arguments[0].scrollIntoView();", destinationCode);
        js.executeScript("window.scrollBy(0,-70)");

        type(By.name("destination_code"), flightData.getDestination());
        downEnter(By.name("destination_code"));

        WebElement passengers = driver.findElement(By.xpath("//h3[contains(.,'Passengers')]")); //css=.backside h3
        js.executeScript("arguments[0].scrollIntoView();", passengers);
        js.executeScript("window.scrollBy(0,-90)");

        try {
            driver.findElement(By.xpath("//button[contains(.,' Add new passenger')]")).click();
            Thread.sleep(1000);
            type(By.name("first_name"), flightData.getFirstName());
            type(By.name("last_name"), flightData.getLastName());
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException for add new passenger");
            try {
                driver.findElement(By.linkText("Change")).click();
                Thread.sleep(1000);
                type(By.name("first_name"), flightData.getFirstName());
                type(By.name("last_name"), flightData.getLastName());
            } catch (NoSuchElementException e1) {
                System.out.println("NoSuchElementException for Change passenger");
            }
        }

        Thread.sleep(1000);
    }

    public void submitSaveFlight() throws InterruptedException {
        click(By.xpath("//button[@type='submit']"));
        return;
    }

    public void openFlightForEditing() throws InterruptedException {
        click(By.cssSelector(".card:nth-child(1) > .card-wrap > .header svg"));
    }

    public void deleteEditableFlight() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(2000);
        click(By.xpath("//button[contains(.,' Delete')]"));
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
}
