package com.dzdz.web1ch.appmanager;

import com.dzdz.web1ch.model.PassengerData;
import org.openqa.selenium.*;
import ru.stqa.selenium.factory.WebDriverPool;

import java.net.URL;

public class ApplicationManager {
    public static URL gridHubUrl = null;
    public static String baseUrl;
    public static Capabilities capabilities;

    public WebDriver driver;
    private SessionHelper sessionHelper;
    private FlightHelper flightHelper;
    private NavigationHelper navigationHelper;

    public void init() throws InterruptedException {
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        driver.manage().window().maximize();
        driver.get(baseUrl);
        sessionHelper = new SessionHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        flightHelper = new FlightHelper(driver);
        sessionHelper.login("test9161@yahoo.com", "UbSme!pvy");
    }

    public void stop() {
        WebDriverPool.DEFAULT.dismissAll();
    }

    public void initPassengerCreation() throws InterruptedException {
        driver.findElement(By.cssSelector(".hidden-sm > .icon > svg")).click();
        Thread.sleep(2000);
    }

    public void fillPassengerForm(PassengerData passengerData) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
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

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }
}
