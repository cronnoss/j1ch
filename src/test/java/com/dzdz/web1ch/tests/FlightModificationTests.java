package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.FlightData;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class FlightModificationTests extends TestJUnitTestBase {

    @Test
    public void testFlightModification() throws InterruptedException, AWTException {
        app.getNavigationHelper().gotoHome();
        int before = app.getFlightHelper().getFlightCount();
        if (!app.getFlightHelper().isThereAFlight()) {
            app.getFlightHelper().createFlight(new FlightData(randomeString(), "LH", randomeNum(), "20200331", "1700", "1800", "TXL", "JFK", "Greta", "Garbo", null), true);
        }
        app.getFlightHelper().openFlightForEditing();
        app.getFlightHelper().fillFlightForm(new FlightData(randomeString(), "LH", randomeNum(), "20200430", "2000", "2100", "TXL", "JFK", "Mark", "Zuckerberg", null), false);
        app.getFlightHelper().submitSaveFlight();
        int after = app.getFlightHelper().getFlightCount();
        Assert.assertEquals(after, before);
    }
}
