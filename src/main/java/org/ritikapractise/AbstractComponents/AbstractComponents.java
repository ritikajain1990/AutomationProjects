package org.ritikapractise.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractComponents {
    WebDriver driver;
    WebElement sectionElement;

    public AbstractComponents(WebDriver driver, By sectionElement) {
        this.driver = driver;
        this.sectionElement = driver.findElement(sectionElement);
    }

    public WebElement findElement(By finByElement) {
        return sectionElement.findElement(finByElement);
    }
}
