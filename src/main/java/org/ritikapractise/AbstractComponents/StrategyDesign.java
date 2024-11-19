package org.ritikapractise.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ritikapractise.PageComponents.MultiTrip;
import org.ritikapractise.PageComponents.RoundTrip;

public class StrategyDesign {
    By sectionTrip = By.id("content-change");
    WebDriver driver;

    public StrategyDesign(WebDriver driver) {
        this.driver = driver;
    }

    public FlightAvail searchFlight(String tripType) {
        if (tripType.equalsIgnoreCase("roundtrip")) {
            return new RoundTrip(driver, sectionTrip);
        }
        if (tripType.equalsIgnoreCase("multitrip")) {
            return new MultiTrip(driver, sectionTrip);
        } else {
            return null;
        }
    }
}
