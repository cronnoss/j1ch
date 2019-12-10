package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.PassengerData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class PassengerModificationTests extends TestNGTestBase {

    @Test
    public void testPassengerModification() throws InterruptedException, AWTException {
        app.getNavigationHelper().gotoPassengersPage();
        int before = app.getPassengerHelper().getPassengerCount();
        if (!app.getPassengerHelper().isThereAPassenger()) {
            app.getPassengerHelper().createPassenger(new PassengerData("Daniel", "Zagar", null, "19800505", "Slovenia", "Slovenia", "PB1258535", "Slovenia", "20140216", "20240215"));
        }
        app.getPassengerHelper().openPassengerForEditing();
        app.getPassengerHelper().fillPassengerForm(new PassengerData("Elon", "Musk ", null, "19710628", "Canada", "Canada", "CA056783", "Canada", "20180101", "20280101"));
        app.getPassengerHelper().submitSavePassenger();
        app.getNavigationHelper().gotoPassengersPage();
        int after = app.getPassengerHelper().getPassengerCount();
        Assert.assertEquals(after, before);
    }
}
