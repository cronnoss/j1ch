package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.PassengerData;
import org.junit.Test;

import java.awt.*;

public class PassengerModificationTests extends TestJUnitTestBase {

    @Test
    public void testPassengerModification() throws InterruptedException, AWTException {
        app.getNavigationHelper().gotoPassengersPage();
        app.getPassengerHelper().openPassengerForEditing();
        app.getPassengerHelper().fillPassengerForm( new PassengerData("Elon", "Musk ","19710628", "Canada", "Canada", "CA056783","Canada","20180101","20280101"));
        app.getPassengerHelper().submitSavePassenger();
    }
}
