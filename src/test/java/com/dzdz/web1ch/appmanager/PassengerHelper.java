package com.dzdz.web1ch.appmanager;

import com.dzdz.web1ch.model.PassengerData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PassengerHelper extends HelperBase{

    PassengerHelper(WebDriver driver) {
        super(driver);
    }

    public void initPassengerCreation() throws InterruptedException {
        click(By.cssSelector(".hidden-sm > .icon > svg"));
    }

    public void fillPassengerForm(PassengerData passengerData) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.cssSelector(".card:nth-child(1) > .card-wrap .btn-group > .btn:nth-child(1)")).click();

        type(By.name("first_name"), passengerData.getFirstName());
        type(By.name("last_name"),passengerData.getLastName());
        type(By.name("birth_date"), passengerData.getBirthDate());
        type(By.name("citizenship_id"), passengerData.getCitizenshipId());
        downEnter(By.name("citizenship_id"));
        Thread.sleep(1000);

        js.executeScript("window.scrollBy(0,100)");
        Thread.sleep(1000);

        type(By.name("residence_id"), passengerData.getResidenceId());
        downEnter(By.name("residence_id"));

        js.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.linkText("Add")).click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,300)");

        type(By.name("passport_num"), passengerData.getPassportNum());
        type(By.name("passport_issue_country_id"), passengerData.getPassportIssueCountryId());
        downEnter(By.name("passport_issue_country_id"));
        type(By.name("passport_issue_date"), passengerData.getPassportIssueDate());
        driver.findElement(By.name("passport_issue_date")).sendKeys(Keys.ENTER);

        type(By.name("passport_expiry_date"),passengerData.getPassportExpiryDate());
        driver.findElement(By.name("passport_expiry_date")).sendKeys(Keys.ENTER);
        js.executeScript("window.scrollBy(0,200)");

    }

    public void submitPassengerCreation() throws InterruptedException {
        click(By.cssSelector(".item:nth-child(4) .col-xs-7 > .btn"));
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
}
