package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.PassengerData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class PassengerDeletionTests extends TestNGTestBase {

    @Test(description = "Verify deletion Passenger card on Passengers Page")
    @Description("Verify deletion Passenger card on Passengers Page...")
    @Epic("EP001")
    @Feature("Feature2: Passenger")
    @Story("Story: Passenger deletion")
    @Step("Verify deletion Passenger")
    @Severity(SeverityLevel.NORMAL)
    public void testPassengerDeletion() throws InterruptedException, AWTException {
        app.getNavigationHelper().gotoPassengersPage();
        int before = app.getPassengerHelper().getPassengerCount();
        if (!app.getPassengerHelper().isThereAPassenger()) {
            app.getPassengerHelper().createPassenger(new PassengerData("Daniel", "Zagar", null, "19800505", "Slovenia", "Slovenia", "PB1258535", "Slovenia", "20140216", "20240215"));
        }
        app.getPassengerHelper().openPassengerForEditing();
        app.getPassengerHelper().deleteEditablePassenger();
        app.getNavigationHelper().gotoPassengersPage();
        int after = app.getPassengerHelper().getPassengerCount();
        Assert.assertEquals(after, before);
    }
}
