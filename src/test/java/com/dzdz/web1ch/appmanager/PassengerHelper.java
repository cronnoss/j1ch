package com.dzdz.web1ch.appmanager;

import com.dzdz.web1ch.model.PassengerData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.util.NoSuchElementException;

public class PassengerHelper extends HelperBase {

    PassengerHelper(WebDriver driver) {
        super(driver);
    }

    public void initPassengerCreation() throws InterruptedException {
        click(By.cssSelector(".hidden-sm > .icon > svg"));
    }

    public void fillPassengerForm(PassengerData passengerData) throws InterruptedException, AWTException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        click(By.cssSelector(".card:nth-child(1) > .card-wrap .btn-group > .btn:nth-child(1)"));
        type(By.name("first_name"), passengerData.getFirstName());
        type(By.name("last_name"), passengerData.getLastName());
        type(By.name("middle_name"), passengerData.getMiddleName());
        type(By.name("birth_date"), passengerData.getBirthDate());
        type(By.name("citizenship_id"), passengerData.getCitizenshipId());
        downEnter(By.name("citizenship_id"));
        Thread.sleep(1000);

        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);

        type(By.name("residence_id"), passengerData.getResidenceId());
        downEnter(By.name("residence_id"));

        js.executeScript("window.scrollBy(0,100)");
        try {
            click(By.cssSelector(".card:nth-child(1) .item:nth-child(2) > .form-group:nth-child(1) a:nth-child(1)"));
            Thread.sleep(2000);
            js.executeScript("window.scrollBy(0,300)");
        } catch (NoSuchElementException e) {
            System.out.println("NoSuchElementException for add passport");
            click(By.cssSelector(".card:nth-child(1) .item > .form-group:nth-child(1) .input-holder"));
            Thread.sleep(2000);
        }

        type(By.name("passport_num"), passengerData.getPassportNum());
        type(By.name("passport_issue_country_id"), passengerData.getPassportIssueCountryId());
        downEnter(By.name("passport_issue_country_id"));
        type(By.name("passport_issue_date"), passengerData.getPassportIssueDate());
        driver.findElement(By.name("passport_issue_date")).sendKeys(Keys.ENTER);

        type(By.name("passport_expiry_date"), passengerData.getPassportExpiryDate());
        driver.findElement(By.name("passport_expiry_date")).sendKeys(Keys.ENTER);
        keyTab();
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,110)");
    }

    public void submitSavePassenger() throws InterruptedException {
        click(By.xpath("//div[@class='card obj-passenger subcomponent backside']//button[@class='btn btn-primary btn-block'][contains(text(),'Save')]"));
        Thread.sleep(2000);
    }

    public void openPassengerForEditing() throws InterruptedException {
        click(By.cssSelector(".card:nth-child(1) > .card-wrap > .header > .btn-clear svg"));
    }

    public void deleteEditablePassenger() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        Thread.sleep(2000);
        click(By.xpath("//div[4]/div/button"));
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
    }

    public void createPassenger(PassengerData passenger) throws InterruptedException, AWTException {
        initPassengerCreation();
        fillPassengerForm(passenger);
        submitSavePassenger();
    }

    public boolean isThereAPassenger() {
        return isElementPresent(By.cssSelector(".card:nth-child(1) > .card-wrap > .header > .btn-clear svg"));
    }

    public int getPassengerCount() {
        return driver.findElements(By.xpath("//div[@data-class='passenger']")).size();
    }
}
