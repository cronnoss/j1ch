package com.dzdz.web1ch.appmanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.selenium.factory.WebDriverPool;

import java.net.URL;
import java.util.concurrent.TimeUnit;

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
        //driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        driver.get(baseUrl);
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
