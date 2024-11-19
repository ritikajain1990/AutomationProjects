package org.ritikapractise.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ritikapractise.AbstractComponents.AbstractComponents;

public class FooterNav extends AbstractComponents {
    WebDriver driver;
    By flights = By.cssSelector("a[title='Flights']");

    public FooterNav(WebDriver driver, By footerSection) {
        super(driver, footerSection);
        this.driver = driver;

    }

    public String selectFlight() {

        return findElement(flights).getAttribute("class");
    }
}
