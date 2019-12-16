package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.FlightData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;

public class FlightCreationTests extends TestNGTestBase {

    @Test(description = "Verify creation flight card on Flights Page")
    @Description("Verify creation flight card on Flights Page...")
    @Epic("EP001")
    @Feature("Feature1: Flight")
    @Story("Story: Flight creation")
    @Step("Verify creation flight")
    @Severity(SeverityLevel.MINOR)
    public void testFlightCreation() throws InterruptedException, AWTException {
        app.goTo().homePage();
        int before = app.flight().count();
        FlightData flight = new FlightData().withPnr(randomeString()).withAirlineCode("LH").withFlightNum(randomeNum())
                .withDate("20200331").withFlightTime("1700").withArrivalTime("1800")
                .withDeparture("TXL").withDestination("JFK").withFirstName("Greta").withLastName("Garbo");
        app.flight().create(flight, true);
        int after = app.flight().count();
        Assert.assertEquals(after, before + 1);
    }
}