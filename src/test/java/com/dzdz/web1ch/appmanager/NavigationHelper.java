package com.dzdz.web1ch.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver driver;

    NavigationHelper(WebDriver driver) {
        this.driver = driver;
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
}