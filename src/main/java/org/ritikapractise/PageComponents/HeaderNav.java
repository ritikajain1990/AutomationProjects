package org.ritikapractise.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ritikapractise.AbstractComponents.AbstractComponents;

public class HeaderNav extends AbstractComponents {
    WebDriver driver;
    By flights = By.cssSelector("a[title='Flights']");

    public HeaderNav(WebDriver driver, By headerSection) {
        super(driver, headerSection);
        this.driver = driver;

    }

    public String selectFlight() {

        return findElement(flights).getAttribute("class");
    }
}
