package com.dzdz.web1ch.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void gotoHome() throws InterruptedException {
        Thread.sleep(2000);
        click(By.xpath("(//span[@class='menu-label'])[1]"));
    }

    public void gotoPassengersPage() throws InterruptedException {
        Thread.sleep(2000);
        click(By.xpath("(//span[@class='menu-label'])[2]"));
    }
}