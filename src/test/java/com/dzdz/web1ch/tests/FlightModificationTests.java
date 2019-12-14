package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.FlightData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class FlightModificationTests extends TestNGTestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException, AWTException {
        app.getNavigationHelper().gotoHome();
        if (!app.getFlightHelper().isThereAFlight()) {
            app.getFlightHelper().createFlight(new FlightData(randomeString(), "LH", randomeNum(), "20200331", "1700", "1800", "TXL", "JFK", "Greta", "Garbo", null), true);
        }
    }

    @Test(description = "Verify modification flight card on Flights Page")
    @Description("Verify modification flight card on Flights Page...")
    @Epic("EP001")
    @Feature("Feature1: Flight")
    @Story("Story: Flight modification")
    @Step("Verify modification flight")
    @Severity(SeverityLevel.TRIVIAL)
    public void testFlightModification() throws InterruptedException, AWTException {
        int before = app.getFlightHelper().getFlightCount();
        app.getFlightHelper().modifyFlight(new FlightData(randomeString(), "LH", randomeNum(), "20200430", "2000", "2100", "TXL", "JFK", "Mark", "Zuckerberg", null), false);
        int after = app.getFlightHelper().getFlightCount();
        Assert.assertEquals(after, before);
    }
}
