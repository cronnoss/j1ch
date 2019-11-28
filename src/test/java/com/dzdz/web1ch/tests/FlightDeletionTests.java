package com.dzdz.web1ch.tests;

import org.junit.Test;

public class FlightDeletionTests extends TestJUnitTestBase {

    @Test
    public void testFlightDeletion() throws InterruptedException {
        app.gotoHome();
        app.selectFlight();
        app.deleteSelectedFlights();
    }
}
