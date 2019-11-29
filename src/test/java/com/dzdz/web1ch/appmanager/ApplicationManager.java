package com.dzdz.web1ch.appmanager;

import com.dzdz.web1ch.model.PassengerData;
import org.openqa.selenium.*;
import ru.stqa.selenium.factory.WebDriverPool;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public static URL gridHubUrl = null;
    public static String baseUrl;
    public static Capabilities capabilities;

    public WebDriver driver;

    private FlightHelper flightHelper;

    public void init() throws InterruptedException {
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        driver.manage().window().maximize();
        flightHelper = new FlightHelper(driver);
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

    public void gotoPassengersPage() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='menu-label'])[2]")).click();
        Thread.sleep(2000);
    }

    public void initPassengerCreation() throws InterruptedException {
        driver.findElement(By.cssSelector(".hidden-sm > .icon > svg")).click();
        Thread.sleep(2000);
    }

    public void fillPassengerForm(PassengerData passengerData) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //click male
        driver.findElement(By.cssSelector(".card:nth-child(1) > .card-wrap .btn-group > .btn:nth-child(1)")).click();

        driver.findElement(By.name("first_name")).click();
        driver.findElement(By.name("first_name")).sendKeys(passengerData.getFirstName());
        driver.findElement(By.name("last_name")).click();
        driver.findElement(By.name("last_name")).sendKeys(passengerData.getLastName());
        driver.findElement(By.name("birth_date")).click();
        driver.findElement(By.name("birth_date")).sendKeys(passengerData.getBirthDate());

        driver.findElement(By.name("citizenship_id")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("citizenship_id")).sendKeys(passengerData.getCitizenshipId());
        Thread.sleep(2000);
        driver.findElement(By.name("citizenship_id")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("citizenship_id")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("residence_id")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("residence_id")).sendKeys(passengerData.getResidenceId());
        Thread.sleep(2000);
        driver.findElement(By.name("residence_id")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("residence_id")).sendKeys(Keys.ENTER);

        driver.findElement(By.linkText("Add")).click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,700)");

        driver.findElement(By.name("passport_num")).sendKeys(passengerData.getPassportNum());

        driver.findElement(By.name("passport_issue_country_id")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("passport_issue_country_id")).sendKeys(passengerData.getPassportIssueCountryId());
        Thread.sleep(2000);
        driver.findElement(By.name("passport_issue_country_id")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("passport_issue_country_id")).sendKeys(Keys.ENTER);

        Thread.sleep(1000);
        driver.findElement(By.name("passport_issue_date")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("passport_issue_date")).clear();
        driver.findElement(By.name("passport_issue_date")).sendKeys(passengerData.getPassportIssueDate());

        Thread.sleep(1000);
        driver.findElement(By.name("passport_expiry_date")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("passport_expiry_date")).clear();
        driver.findElement(By.name("passport_expiry_date")).sendKeys(passengerData.getPassportExpiryDate());
        driver.findElement(By.name("passport_expiry_date")).sendKeys(Keys.ENTER);
        js.executeScript("window.scrollBy(0,200)");

    }

    public void submitPassengerCreation() throws InterruptedException {
        driver.findElement(By.cssSelector(".item:nth-child(4) .col-xs-7 > .btn")).click();
        Thread.sleep(3000);
    }

    public void openPassengerForEditing() throws InterruptedException {
        driver.findElement(By.cssSelector(".card:nth-child(1) > .card-wrap > .header > .btn-clear svg")).click();
        Thread.sleep(3000);
    }

    public void deleteEditablePassenger() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[4]/div/button")).click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }

    public FlightHelper getFlightHelper() {
        return flightHelper;
    }
}
