package org.fundacionjala.trello.core.utils;

import org.openqa.selenium.WebElement;

public class WebElementsHelper {

    public static void sendKeys(final WebElement webElement, final String value) {
        webElement.clear();
        webElement.sendKeys(value);
    }

    public static void clickElement(final WebElement webElement) {
        webElement.click();
    }
}
