package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.PassengerData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class PassengerCreationTests extends TestNGTestBase {

    @Test(description = "Verify creation Passenger card on Passengers Page")
    @Description("Verify creation Passenger card on Passengers Page...")
    @Epic("EP001")
    @Feature("Feature2: Passenger")
    @Story("Story: Passenger creation")
    @Step("Verify creation Passenger")
    @Severity(SeverityLevel.MINOR)
    public void testPassengerCreation() throws InterruptedException, AWTException {
        app.getNavigationHelper().gotoPassengersPage();
        int before = app.getPassengerHelper().getPassengerCount();
        app.getPassengerHelper().createPassenger(new PassengerData("Daniel", "Zagar", null, "19800505", "Slovenia", "Slovenia", "PB1258535", "Slovenia", "20140216", "20240215"));
        int after = app.getPassengerHelper().getPassengerCount();
        Assert.assertEquals(after, before + 1);
    }
}