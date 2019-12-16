package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.model.PassengerData;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class PassengerDeletionTests extends TestNGTestBase {

    @BeforeMethod
    public void ensurePreconditions() throws InterruptedException, AWTException {
        app.goTo().PassengersPage();
        if (!app.passenger().isThereAPassenger()) {
            app.passenger().create(new PassengerData().withFirstName("Daniel").withLastName("Zagar").withBirthDate("19800505")
                    .withCitizenshipId("Slovenia").withResidenceId("Slovenia").withPassportNum("PB1258535")
                    .withPassportIssueCountryId("Slovenia").withPassportIssueDate("20140216").withPassportExpiryDate("20240215"));
        }
    }

    @Test(description = "Verify deletion Passenger card on Passengers Page")
    @Description("Verify deletion Passenger card on Passengers Page...")
    @Epic("EP001")
    @Feature("Feature2: Passenger")
    @Story("Story: Passenger deletion")
    @Step("Verify deletion Passenger")
    @Severity(SeverityLevel.NORMAL)
    public void testPassengerDeletion() throws InterruptedException {
        int before = app.passenger().count();
        app.passenger().openPassengerForEditing();
        app.passenger().deleteEditablePassenger();
        app.goTo().PassengersPage();
        int after = app.passenger().count();
        Assert.assertEquals(after, before - 1);
    }
}
