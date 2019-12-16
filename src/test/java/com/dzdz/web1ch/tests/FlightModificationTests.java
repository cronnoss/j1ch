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
        app.goTo().homePage();
        if (!app.flight().isThereAFlight()) {
            FlightData flight = new FlightData().withPnr(randomeString()).withAirlineCode("LH").withFlightNum(randomeNum())
                    .withDate("20200331").withFlightTime("1700").withArrivalTime("1800")
                    .withDeparture("TXL").withDestination("JFK").withFirstName("Greta").withLastName("Garbo");
            app.flight().create(flight, true);
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
        int before = app.flight().count();
        FlightData flight = new FlightData().withPnr(randomeString()).withAirlineCode("LH").withFlightNum(randomeNum())
                .withDate("20200430").withFlightTime("2000").withArrivalTime("2100")
                .withDeparture("TXL").withDestination("JFK").withFirstName("Mark").withLastName("Zuckerberg");
        app.flight().modify(flight, false);
        int after = app.flight().count();
        Assert.assertEquals(after, before);
    }
}
