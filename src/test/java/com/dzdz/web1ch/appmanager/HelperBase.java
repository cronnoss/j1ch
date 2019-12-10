package com.dzdz.web1ch.appmanager;

import org.openqa.selenium.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void downEnter(By locator) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(locator).sendKeys(Keys.DOWN);
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }

    protected void type(By locator, String text) throws InterruptedException {
        click(locator);
        if (text != null) {
            driver.findElement(locator).clear();
            Thread.sleep(1000);
            driver.findElement(locator).sendKeys(text);
        }
    }

    protected void click(By locator) throws InterruptedException {
        driver.findElement(locator).click();
        Thread.sleep(3000);
    }

    protected void keyTab() throws AWTException {
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    public static void refreshBrowserByJs(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }
}
