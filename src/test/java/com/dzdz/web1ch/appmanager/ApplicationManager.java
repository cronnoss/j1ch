package com.dzdz.web1ch.appmanager;

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
    private PassengerHelper passengerHelper;

    public void init() throws InterruptedException {
        driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        driver.get(baseUrl);
        driver.manage().window().maximize();
        sessionHelper = new SessionHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        flightHelper = new FlightHelper(driver);
        passengerHelper = new PassengerHelper(driver);
        sessionHelper.login("test9161@yahoo.com", "UbSme!pvy");
    }

    public void stop() {
        WebDriverPool.DEFAULT.dismissAll();
    }

    public FlightHelper getFlightHelper() {
        return flightHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public PassengerHelper getPassengerHelper() {
        return passengerHelper;
    }
}
