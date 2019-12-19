package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.FlightData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class FlightDeletionTests extends TestNGTestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException, AWTException {
        app.goTo().homePage();
        if (!app.flight().isThereAFlight()) {
            int indexOfCard = 0;
            FlightData flight = new FlightData().withPnr(randomeString()).withAirlineCode("LH").withFlightNum(randomeNum())
                    .withDate("20200331").withFlightTime("1700").withArrivalTime("1800")
                    .withDeparture("TXL").withDestination("JFK").withFirstName("Greta").withLastName("Garbo");
            app.flight().create(flight, indexOfCard, true);
        }
    }

    @Test(description = "Verify deletion flight card on Flights Page")
    @Description("Verify deletion flight card on Flights Page...")
    @Epic("EP001")
    @Feature("Feature1: Flight")
    @Story("Story: Flight deletion")
    @Step("Verify deletion flight")
    @Severity(SeverityLevel.NORMAL)
    public void testFlightDeletion() throws InterruptedException {
        int before = app.flight().count();
        int indexOfCard = before - 1;
        app.flight().openFlightForEditing(indexOfCard);
        app.flight().deleteEditableFlight(indexOfCard);
        int after = app.flight().count();
        Assert.assertEquals(after, before - 1);
    }
}
