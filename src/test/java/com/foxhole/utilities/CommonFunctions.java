package com.foxhole.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CommonFunctions {

    Actions action = new Actions(Driver.getDriver());

    public void waitFor(int seconds){
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void hoverOver(WebElement element){
        action.moveToElement(element).build().perform();
        waitFor(2);
    }
}
