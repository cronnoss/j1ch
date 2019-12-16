package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.PassengerData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class PassengerModificationTests extends TestNGTestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException, AWTException {
        app.goTo().PassengersPage();
        if (!app.passenger().isThereAPassenger()) {
            app.passenger().create(new PassengerData().withFirstName("Daniel").withLastName("Zagar").withBirthDate("19800505")
                    .withCitizenshipId("Slovenia").withResidenceId("Slovenia").withPassportNum("PB1258535")
                    .withPassportIssueCountryId("Slovenia").withPassportIssueDate("20140216").withPassportExpiryDate("20240215"));
        }
    }

    @Test(description = "Verify modification Passenger card on Passengers Page")
    @Description("Verify modification Passenger card on Passengers Page...")
    @Epic("EP001")
    @Feature("Feature2: Passenger")
    @Story("Story: Passenger modification")
    @Step("Verify modification Passenger")
    @Severity(SeverityLevel.TRIVIAL)
    public void testPassengerModification() throws InterruptedException, AWTException {
        int before = app.passenger().count();
        PassengerData passenger = new PassengerData().withFirstName("Elon").withLastName("Musk").withBirthDate("19710628")
                .withCitizenshipId("Canada").withResidenceId("Canada").withPassportNum("CA056783")
                .withPassportIssueCountryId("Canada").withPassportIssueDate("20180101").withPassportExpiryDate("20280101");
        app.passenger().modify(passenger);
        app.goTo().PassengersPage();
        int after = app.passenger().count();
        Assert.assertEquals(after, before);
    }


}
