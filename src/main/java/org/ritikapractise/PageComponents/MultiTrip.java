package org.ritikapractise.PageComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.ritikapractise.AbstractComponents.AbstractComponents;
import org.ritikapractise.AbstractComponents.FlightAvail;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponents implements FlightAvail {
    WebDriver driver;
    private By multiTrip = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private By modalPopUp = By.id("MultiCityModelAlert");
    private By fromArrow = By.id("ctl00_mainContent_ddl_originStation1_CTXTaction");
    private By toArrow = By.id("ctl00_mainContent_ddl_destinationStation1_CTXTaction");
    private By fromArrow2 = By.id("ctl00_mainContent_ddl_originStation3_CTXTaction");

    public MultiTrip(WebDriver driver, By sectionTrip) {
        super(driver, sectionTrip);
        this.driver = driver;

    }

    @Override
    public void checkAvailability(HashMap<String,String> reservationDetails) {
       makeStateReady(s->selectCity(reservationDetails.get("origin")));
        selectDestination(reservationDetails.get("destination"));
        selectDestination2(reservationDetails.get("destination2"));
    }

    public void selectCity(String origin) {
        //findElement(fromArrow).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", findElement(fromArrow));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", findElement(By.xpath("//a[@value='" + origin + "']")));

        //findElement(By.xpath("//a[@value='" + origin + "']"));


    }

    public void selectDestination(String destination) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", findElement(toArrow));
        //findElement(toArrow).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", findElement(By.xpath("//a[@value='" + destination + "']")));
        //findElement(By.xpath("//a[@value='" + destination + "']")).click();
    }

    public void selectDestination2(String destination) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", findElement(fromArrow2));
        //findElement(fromArrow2).click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", findElement(By.xpath("//a[@value='" + destination + "']")));
    }
    public void makeStateReady(Consumer consumer)
    {
        System.out.println("MultiTrip");
        findElement(multiTrip).click();
        findElement(modalPopUp).click();
        consumer.accept(this);
        System.out.println("I have completed Multi Trip ");
    }
}

