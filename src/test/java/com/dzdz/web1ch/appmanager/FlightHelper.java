package com.dzdz.web1ch.appmanager;

import com.dzdz.web1ch.model.FlightData;
import org.openqa.selenium.*;
import org.testng.Assert;

import java.awt.*;

public class FlightHelper extends HelperBase {

    protected JavascriptExecutor js = (JavascriptExecutor) driver;

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

    public void fillFlightForm(FlightData flightData, int indexOfCard, boolean creation) throws InterruptedException, AWTException {

        WebElement bookingRef = driver.findElements(By.name("booking_ref")).get(indexOfCard);
        js.executeScript("arguments[0].scrollIntoView();", bookingRef);
        js.executeScript("window.scrollBy(0,-90)");

        typeWithIndexOfCard(By.name("booking_ref"), indexOfCard, flightData.getPnr());
        typeWithIndexOfCard(By.name("airline_code"), indexOfCard, flightData.getAirlineCode());
        downEnterWithIndexOfCard(By.name("airline_code"), indexOfCard);

        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);

        typeWithIndexOfCard(By.name("flight_num"), indexOfCard, flightData.getFlightNum());
        typeWithIndexOfCard(By.name("flight_date"), indexOfCard, flightData.getDate());
        keyTab();

        driver.findElements(By.name("flight_time")).get(indexOfCard).sendKeys(Keys.CONTROL + "a");
        driver.findElements(By.name("flight_time")).get(indexOfCard).sendKeys(Keys.DELETE);
        driver.findElements(By.name("flight_time")).get(indexOfCard).sendKeys(flightData.getFlightTime());

        driver.findElements(By.name("arrival_time")).get(indexOfCard).sendKeys(Keys.CONTROL + "a");
        driver.findElements(By.name("arrival_time")).get(indexOfCard).sendKeys(Keys.DELETE);
        driver.findElements(By.name("arrival_time")).get(indexOfCard).sendKeys(flightData.getArrivalTime());
        keyTab();

        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(3000);

        typeWithIndexOfCard(By.name("departure_code"), indexOfCard, flightData.getDeparture());
        downEnter(By.name("departure_code"));

        WebElement destinationCode = driver.findElements(By.name("destination_code")).get(indexOfCard);
        js.executeScript("arguments[0].scrollIntoView();", destinationCode);
        js.executeScript("window.scrollBy(0,-70)");

        typeWithIndexOfCard(By.name("destination_code"), indexOfCard, flightData.getDestination());
        downEnter(By.name("destination_code"));

        WebElement passengers = driver.findElements(By.xpath("//h3[contains(.,'Passengers')]")).get(indexOfCard);
        js.executeScript("arguments[0].scrollIntoView();", passengers);
        js.executeScript("window.scrollBy(0,-90)");

        if (creation) {
            driver.findElement(By.xpath("//button[contains(.,' Add new passenger')]")).click();
            Thread.sleep(1000);
            type(By.name("first_name"), flightData.getFirstName());
            type(By.name("last_name"), flightData.getLastName());
            type(By.name("last_name"), flightData.getMiddleName());
        } else {
            Assert.assertFalse(isElementPresent(By.xpath("//button[contains(.,' Add new passenger')]")));
            try {
                click(By.xpath("//div[@class='pull-right']/a[@data-bind='btn-psg-add']"));
                Thread.sleep(1000);

                WebElement passenger = driver.findElement(By.name("first_name"));
                js.executeScript("arguments[0].scrollIntoView();", passenger);
                js.executeScript("window.scrollBy(0,-90)");

                type(By.name("first_name"), flightData.getFirstName());
                type(By.name("last_name"), flightData.getLastName());
                type(By.name("last_name"), flightData.getMiddleName());
            } catch (NoSuchElementException e) {
                System.out.println("NoSuchElementException for Change passenger");
            }
        }
        Thread.sleep(1000);
    }

    public void submitSaveFlight(int indexOfCard) throws InterruptedException {
        WebElement submitButton = driver.findElements(By.xpath("//button[@type='submit']")).get(indexOfCard);
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        js.executeScript("window.scrollBy(0,-90)");

        driver.findElements(By.xpath("//button[@type='submit']")).get(indexOfCard).click();
    }

    public void openFlightForEditing(int index) {
        driver.findElements(By.xpath("//button[@class='btn-clear pull-right']")).get(index).click();
    }

    public void deleteEditableFlight(int indexOfCard) throws InterruptedException {
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(2000);
        driver.findElements(By.xpath("//i[@class='icon icon-remove']")).get(indexOfCard).click();
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }

    public void create(FlightData flight, int indexOfCard, boolean creation) throws InterruptedException, AWTException {
        initFlightCreation();
        fillFlightForm(flight, indexOfCard, creation);
        submitSaveFlight(indexOfCard);
    }

    public void modify(FlightData flight, int indexOfCard, boolean creation) throws InterruptedException, AWTException {
        fillFlightForm(flight, indexOfCard, creation);
        submitSaveFlight(indexOfCard);
    }


    public boolean isThereAFlight() {
        return isElementPresent(By.cssSelector(".card:nth-child(1) > .card-wrap > .header svg"));
    }

    public int count() {
        return driver.findElements(By.xpath("//button[@class='btn-clear pull-right']")).size();
    }
}
