package com.dzdz.web1ch.appmanager;

import com.dzdz.web1ch.model.PassengerData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class PassengerHelper {
    private WebDriver driver;

    PassengerHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void initPassengerCreation() throws InterruptedException {
        driver.findElement(By.cssSelector(".hidden-sm > .icon > svg")).click();
        Thread.sleep(2000);
    }

    public void fillPassengerForm(PassengerData passengerData) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.cssSelector(".card:nth-child(1) > .card-wrap .btn-group > .btn:nth-child(1)")).click();

        driver.findElement(By.name("first_name")).click();
        driver.findElement(By.name("first_name")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("first_name")).sendKeys(passengerData.getFirstName());

        driver.findElement(By.name("last_name")).click();
        driver.findElement(By.name("last_name")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("last_name")).sendKeys(passengerData.getLastName());

        driver.findElement(By.name("birth_date")).click();
        driver.findElement(By.name("birth_date")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("birth_date")).sendKeys(passengerData.getBirthDate());

        driver.findElement(By.name("citizenship_id")).click();
        driver.findElement(By.name("citizenship_id")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("citizenship_id")).sendKeys(passengerData.getCitizenshipId());
        Thread.sleep(2000);
        driver.findElement(By.name("citizenship_id")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("citizenship_id")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("residence_id")).click();
        driver.findElement(By.name("residence_id")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("residence_id")).sendKeys(passengerData.getResidenceId());
        Thread.sleep(2000);
        driver.findElement(By.name("residence_id")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("residence_id")).sendKeys(Keys.ENTER);

        js.executeScript("window.scrollBy(0,100)");
        driver.findElement(By.linkText("Add")).click();
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,300)");

        driver.findElement(By.name("passport_num")).click();
        driver.findElement(By.name("passport_num")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("passport_num")).sendKeys(passengerData.getPassportNum());

        driver.findElement(By.name("passport_issue_country_id")).click();
        driver.findElement(By.name("passport_issue_country_id")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("passport_issue_country_id")).sendKeys(passengerData.getPassportIssueCountryId());
        Thread.sleep(2000);
        driver.findElement(By.name("passport_issue_country_id")).sendKeys(Keys.DOWN);
        driver.findElement(By.name("passport_issue_country_id")).sendKeys(Keys.ENTER);

        driver.findElement(By.name("passport_issue_date")).click();
        driver.findElement(By.name("passport_issue_date")).clear();
        Thread.sleep(1000);
        driver.findElement(By.name("passport_issue_date")).sendKeys(passengerData.getPassportIssueDate());

        driver.findElement(By.name("passport_expiry_date")).click();
        driver.findElement(By.name("passport_expiry_date")).clear();
        Thread.sleep(1000);
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
}
