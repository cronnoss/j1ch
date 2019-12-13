package com.dzdz.web1ch.appmanager;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.stqa.selenium.factory.WebDriverPool;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public static URL gridHubUrl = null;
    public static String baseUrl;
    public static Capabilities capabilities;

    /*public WebDriver driver;*/
    public RemoteWebDriver driver;
    private SessionHelper sessionHelper;
    private FlightHelper flightHelper;
    private NavigationHelper navigationHelper;
    private PassengerHelper passengerHelper;

    public void init() throws InterruptedException, MalformedURLException {
        /*driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);*/

        DesiredCapabilities dc = DesiredCapabilities.chrome();
        URL url = new URL("http://localhost:4444/wd/hub/");
        driver = new RemoteWebDriver(url, dc);

        /*System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();*/

        /*System.setProperty("webdriver.chrome.driver", "Drivers/win/chromedriver.exe");*/

        /*System.setProperty("webdriver.chrome.driver", "Drivers/lin/chromedriver");
        driver = new ChromeDriver();*/

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
