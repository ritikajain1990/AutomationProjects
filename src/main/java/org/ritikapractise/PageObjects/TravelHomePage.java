package org.ritikapractise.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ritikapractise.AbstractComponents.StrategyDesign;
import org.ritikapractise.AbstractComponents.FlightAvail;
import org.ritikapractise.PageComponents.FooterNav;
import org.ritikapractise.PageComponents.HeaderNav;

public class TravelHomePage {
    WebDriver driver;
    By footerSection = By.cssSelector("#traveller-home");
    By headerSection = By.cssSelector("#buttons");
    FlightAvail flightAvail;


    public TravelHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HeaderNav getHeaderNavigation() {
        return new HeaderNav(driver, headerSection);
    }

    public FooterNav getFooterNavigation() {
        return new FooterNav(driver, footerSection);
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public FlightAvail searchFlightStrategy(String name) {
        StrategyDesign sdesign = new StrategyDesign(driver);
        return sdesign.searchFlight(name);
    }


}



