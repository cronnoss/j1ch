package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.TestJUnitTestBase;
import org.junit.Test;

public class FlightDeletionTests extends TestJUnitTestBase {

    @Test
    public void testFlightDeletion() throws InterruptedException {
        gotoHome();
        selectFlight();
        deleteSelectedFlights();
    }
}
