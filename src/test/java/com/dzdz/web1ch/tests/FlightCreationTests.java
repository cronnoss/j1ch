package com.dzdz.web1ch.tests;

import com.dzdz.web1ch.TestJUnitTestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class FlightCreationTests extends TestJUnitTestBase {

    @Test
    public void testFlightCreation() throws InterruptedException {
        gotoHome();
        initFlightCreation();
        fillFlightForm(new FlightData("TUZ2R7", "LH", "001", "20191231", "1700", "1800", "TXL", "JFK", "Greta", "Garbo"));
        submitFlightCreation();
        Assert.assertNotNull(driver.findElement(By.xpath("//div[@data-class='thread']")));
    }
}