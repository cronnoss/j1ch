package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.FlightData;
import org.junit.Test;

import java.awt.*;

public class FlightDeletionTests extends TestJUnitTestBase {

    @Test
    public void testFlightDeletion() throws InterruptedException, AWTException {
        app.getNavigationHelper().gotoHome();
        if (!app.getFlightHelper().isThereAFlight()) {
            app.getFlightHelper().createFlight(new FlightData(randomeString(), "LH", randomeNum(), "20200331", "1700", "1800", "TXL", "JFK", "Greta", "Garbo", null), true);
        }
        app.getFlightHelper().openFlightForEditing();
        app.getFlightHelper().deleteEditableFlight();
    }
}
