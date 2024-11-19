package org.ritikapractise.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.ritikapractise.AbstractComponents.AbstractComponents;
import org.ritikapractise.AbstractComponents.FlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponents implements FlightAvail {
    WebDriver driver;
    private By roundTrip = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private By fromArrow = By.id("ctl00_mainContent_ddl_originStation1_CTXTaction");
    private By toArrow = By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction");
    private By checkbox = By.id("ctl00_mainContent_chk_friendsandfamily");


    public RoundTrip(WebDriver driver, By sectionTrip) {
        super(driver, sectionTrip);
        this.driver = driver;
    }

    @Override
    public void checkAvailability(HashMap<String,String> reservationDetails) {

        makeStateReady(s->selectCity(reservationDetails.get("origin")));
        selectDestination(reservationDetails.get("destination"));
        findElement(checkbox).click();
    }

    public void selectCity(String origin) {
        findElement(fromArrow).click();
        findElement(By.xpath("//a[@value='" + origin + "']")).click();


    }

    public void selectDestination(String destination) {
        findElement(toArrow).click();
        findElement(By.xpath("//a[@value='" + destination + "']")).click();
    }
public void makeStateReady(Consumer consumer)
{
    System.out.println("RoundTrip");
    findElement(roundTrip).click();
    System.out.println("I have completed Round Trip");
    consumer.accept(this);
}

}




