package com.dzdz.web1ch.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void homePage() throws InterruptedException {
        refreshBrowserByJs(driver);
        Thread.sleep(2000);
        if (isElementPresent(By.xpath("//menu[@class='menu-top hidden-xs']//li[@class='active']//a[contains(text(),'Upcoming')]"))
                && driver.findElement(By.xpath("//menu[@class='menu-top hidden-xs']//li[@class='active']//a[contains(text(),'Upcoming')]")).getText().equals("Upcoming")
                && isElementPresent(By.xpath("(//span[@class='menu-label'])[1]"))) {
            return;
        } else {
            click(By.xpath("(//span[@class='menu-label'])[1]"));
        }
    }

    public void PassengersPage() throws InterruptedException {
        refreshBrowserByJs(driver);
        Thread.sleep(2000);
        if (isElementPresent(By.xpath("//div[@class='text-secondry text-center']//b[contains(text(),'Personal 1Checkin email address')]"))) {
            return;
        } else {
            click(By.xpath("(//span[@class='menu-label'])[2]"));
        }
    }
}