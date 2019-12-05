package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.FlightData;
import org.junit.Test;

import java.awt.*;

public class FlightModificationTests extends TestJUnitTestBase {

    @Test
    public void testFlightModification() throws InterruptedException, AWTException {
        app.getNavigationHelper().gotoHome();
        app.getFlightHelper().openFlightForEditing();
        app.getFlightHelper().fillFlightForm(new FlightData(randomeString(), "LH", randomeNum(), "20191231", "2000", "2100", "TXL", "JFK", "Mark", "Zuckerberg"));
        app.getFlightHelper().submitSaveFlight();
    }
}