package com.dzdz.web1ch.appmanager;

import com.dzdz.web1ch.model.FlightData;
import org.openqa.selenium.*;

import java.awt.*;
import java.awt.event.KeyEvent;

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
        js.executeScript("window.scrollBy(0,-70)");

        type(By.name("booking_ref"), flightData.getPnr());
        type(By.name("airline_code"), flightData.getAirlineCode());
        downEnter(By.name("airline_code"));

        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);

        type(By.name("flight_num"), flightData.getFlightNum());
        type(By.name("flight_date"), flightData.getDate());

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);

        type(By.name("flight_time"), flightData.getFlightTime());
        downEnter(By.name("flight_time"));
        type(By.name("arrival_time"), flightData.getArrivalTime());
        downEnter(By.name("arrival_time"));

        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(3000);

        type(By.name("departure_code"), flightData.getDeparture());
        downEnter(By.name("departure_code"));

        WebElement destinationCode = driver.findElement(By.name("destination_code"));
        js.executeScript("arguments[0].scrollIntoView();", destinationCode);
        js.executeScript("window.scrollBy(0,-70)");

        type(By.name("destination_code"), flightData.getDestination());
        downEnter(By.name("destination_code"));

        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,' Add new passenger')]")).click();
        Thread.sleep(1000);

        type(By.name("first_name"), flightData.getFirstName());
        type(By.name("last_name"), flightData.getLastName());
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
