package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.PassengerData;
import org.junit.Test;

import java.awt.*;

public class PassengerDeletionTests extends TestJUnitTestBase {

    @Test
    public void testPassengerDeletion() throws InterruptedException, AWTException {
        app.getNavigationHelper().gotoPassengersPage();
        if (!app.getPassengerHelper().isThereAPassenger()) {
            app.getPassengerHelper().createPassenger(new PassengerData("Daniel", "Zagar", null, "19800505", "Slovenia", "Slovenia", "PB1258535", "Slovenia", "20140216", "20240215"));
        }
        app.getPassengerHelper().openPassengerForEditing();
        app.getPassengerHelper().deleteEditablePassenger();
        app.getNavigationHelper().gotoPassengersPage();
    }
}
