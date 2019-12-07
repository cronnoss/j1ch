package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.PassengerData;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class PassengerCreationTests extends TestJUnitTestBase {

    @Test
    public void testPassengerCreation() throws InterruptedException, AWTException {
        app.getNavigationHelper().gotoPassengersPage();
        int before  = app.getPassengerHelper().getPassengerCount();
        app.getPassengerHelper().initPassengerCreation();
        app.getPassengerHelper().fillPassengerForm(new PassengerData("Daniel", "Zagar", null, "19800505", "Slovenia", "Slovenia", "PB1258535", "Slovenia", "20140216", "20240215"));
        app.getPassengerHelper().submitSavePassenger();
        int after  = app.getPassengerHelper().getPassengerCount();
        Assert.assertEquals(after, before + 1);
    }
}