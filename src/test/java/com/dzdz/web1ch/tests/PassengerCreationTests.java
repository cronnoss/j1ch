package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.PassengerData;
import org.junit.Test;

public class PassengerCreationTests extends TestJUnitTestBase {

    @Test
    public void testPassengerCreation() throws InterruptedException {
        app.getNavigationHelper().gotoPassengersPage();
        app.getPassengerHelper().initPassengerCreation();
        app.getPassengerHelper().fillPassengerForm( new PassengerData("Daniel", "Zagar","19800505", "Slovenia", "Slovenia", "PB1258535","Slovenia","20140216","20240215"));
        app.getPassengerHelper().submitPassengerCreation();
    }
}