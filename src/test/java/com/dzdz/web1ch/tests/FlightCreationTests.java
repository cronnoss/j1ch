package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.FlightData;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.awt.*;

public class FlightCreationTests extends TestJUnitTestBase {

    @Test
    public void testFlightCreation() throws InterruptedException, AWTException {
        app.getNavigationHelper().gotoHome();
        app.getFlightHelper().initFlightCreation();
        app.getFlightHelper().fillFlightForm(new FlightData(randomeString(), "LH", randomeNum(), "20200331", "1700", "1800", "TXL", "JFK", "Greta", "Garbo", null));
        app.getFlightHelper().submitSaveFlight();
        Assert.assertNotNull(app.driver.findElement(By.xpath("//div[@data-class='thread']")));
    }
}