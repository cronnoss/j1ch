package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.FlightData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightCreationTests extends TestJUnitTestBase {

    @Test
    public void testFlightCreation() throws InterruptedException {
        app.gotoHome();
        app.getFlightHelper().initFlightCreation();
        app.getFlightHelper().fillFlightForm(new FlightData("TUZ2R7", "LH", "001", "20191231", "1700", "1800", "TXL", "JFK", "Greta", "Garbo"));
        app.getFlightHelper().submitFlightCreation();
        Assert.assertNotNull(app.getFlightHelper().driver.findElement(By.xpath("//div[@data-class='thread']")));
    }
}