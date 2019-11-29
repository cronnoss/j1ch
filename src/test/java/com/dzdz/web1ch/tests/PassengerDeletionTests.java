package com.dzdz.web1ch.tests;

import org.junit.Test;

public class PassengerDeletionTests extends TestJUnitTestBase {

    @Test
    public void testPassengerDeletion() throws InterruptedException {
        app.getNavigationHelper().gotoPassengersPage();
        app.openPassengerForEditing();
        app.deleteEditablePassenger();
    }
}
