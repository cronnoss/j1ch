package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.PassengerData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class PassengerModificationTests extends TestNGTestBase {

    @Test(description = "Verify modification Passenger card on Passengers Page")
    @Description("Verify modification Passenger card on Passengers Page...")
    @Epic("EP001")
    @Feature("Feature2: Passenger")
    @Story("Story: Passenger modification")
    @Step("Verify modification Passenger")
    @Severity(SeverityLevel.TRIVIAL)
    public void testPassengerModification() throws InterruptedException, AWTException {
        app.goTo().PassengersPage();
        int before = app.passenger().count();
        if (!app.passenger().isThereAPassenger()) {
            app.passenger().create(new PassengerData("Daniel", "Zagar", null, "19800505", "Slovenia", "Slovenia", "PB1258535", "Slovenia", "20140216", "20240215"));
        }
        app.passenger().openPassengerForEditing();
        app.passenger().fillPassengerForm(new PassengerData("Elon", "Musk ", null, "19710628", "Canada", "Canada", "CA056783", "Canada", "20180101", "20280101"));
        app.passenger().submitSavePassenger();
        app.goTo().PassengersPage();
        int after = app.passenger().count();
        Assert.assertEquals(after, before);
    }
}
