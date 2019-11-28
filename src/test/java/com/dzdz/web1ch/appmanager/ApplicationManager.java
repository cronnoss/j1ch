package com.dzdz.web1ch.appmanager;

import com.dzdz.web1ch.model.FlightData;
import org.openqa.selenium.*;
import ru.stqa.selenium.factory.WebDriverPool;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public static URL gridHubUrl = null;
    public static String baseUrl;
    public static Capabilities capabilities;
    public WebDriver driver;

    public void init() throws InterruptedException {
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        driver.manage().window().maximize();
        login("test9161@yahoo.com", "UbSme!pvy");
    }

    public void stop() {
        WebDriverPool.DEFAULT.dismissAll();
    }

    public void login(String email, String password) throws InterruptedException {
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
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException for PopUp window");
        } finally {
            gotoHome();
        }
    }

    public void gotoHome() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='menu-label'])[1]")).click();
        Thread.sleep(2000);
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
        driver.findElement(By.name("booking_ref")).sendKeys(flightData.getPnr());
        driver.findElement(By.name("airline_code")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("airline_code")).sendKeys(flightData.getAirlineCode());
        Thread.sleep(4000);
        driver.findElement(By.name("airline_code")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("airline_code")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".obj-flight")).click();
        driver.findElement(By.name("flight_num")).sendKeys(flightData.getFlightNum());
        driver.findElement(By.name("flight_date")).sendKeys(flightData.getDate());
        Thread.sleep(1000);
        driver.findElement(By.name("flight_time")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("flight_time")).clear();
        driver.findElement(By.name("flight_time")).sendKeys(flightData.getFlightTime());
        driver.findElement(By.name("arrival_time")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("arrival_time")).clear();
        driver.findElement(By.name("arrival_time")).sendKeys(flightData.getArrivalTime());
        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(3000);
        driver.findElement(By.name("departure_code")).sendKeys(flightData.getDeparture());
        Thread.sleep(3000);
        driver.findElement(By.name("departure_code")).sendKeys(Keys.DOWN);
        Thread.sleep(2000);
        driver.findElement(By.name("departure_code")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.name("destination_code")).sendKeys(flightData.getDestination());
        Thread.sleep(3000);
        driver.findElement(By.name("destination_code")).sendKeys(Keys.DOWN);
        Thread.sleep(2000);
        driver.findElement(By.name("destination_code")).sendKeys(Keys.ENTER);
        js.executeScript("window.scrollBy(0,300)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,' Add new passenger')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("first_name")).click();
        driver.findElement(By.name("first_name")).sendKeys(flightData.getFirstName());
        driver.findElement(By.name("last_name")).sendKeys(flightData.getLastName());
        Thread.sleep(1000);
    }

    public void submitFlightCreation() throws InterruptedException {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(3000);
    }

    public void selectFlight() throws InterruptedException {
        driver.findElement(By.cssSelector(".card:nth-child(1) > .card-wrap > .header svg")).click();
        Thread.sleep(3000);
    }

    public void deleteSelectedFlights() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1300)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(.,' Delete')]")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }
}
