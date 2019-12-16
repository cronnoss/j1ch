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
        app.goTo().PassengersPage();
        int before = app.passenger().count();
        PassengerData passenger = new PassengerData().withFirstName("Daniel").withLastName("Zagar").withBirthDate("19800505")
                .withCitizenshipId("Slovenia").withResidenceId("Slovenia").withPassportNum("PB1258535")
                .withPassportIssueCountryId("Slovenia").withPassportIssueDate("20140216").withPassportExpiryDate("20240215");
        app.passenger().create(passenger);
        int after = app.passenger().count();
        Assert.assertEquals(after, before + 1);
    }
}