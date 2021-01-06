package org.fundacionjala.trello.core.utils;

import org.fundacionjala.trello.core.selenium.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public final class WebElementsHelper {
    /**
     * Constructor.
     */
    private WebElementsHelper() { }

    /**
     * Sends keys.
     * @param webElement to send keys
     * @param value to set in webElement
     */
    public static void sendKeys(final WebElement webElement, final String value) {
        waitElement(webElement);
        webElement.clear();
        webElement.sendKeys(value);
    }

    /**
     * Clicks on elements.
     * @param webElement to click
     */
    public static void clickElement(final WebElement webElement) {
        waitElement(webElement);
        webElement.click();
    }

    /**
     * Waits for a web element.
     * @param elem is the element for which it is waiting
     * @return WebElement
     */
    public static WebElement waitElement(final WebElement elem) {
        return WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(elem));
    }

    /**
     * Gets text from element.
     * @param webElement
     * @return String with the text
     */
    public static String getTextFromElement(final WebElement webElement) {
        return webElement.getText();
    }

    /**
     * Gets text from by element.
     * @param by
     * @return String with the text
     */
    public static String getTextFromBy(final By by) {
        return WebDriverManager.getInstance().getWebDriver().findElement(by).getText();
    }

    /**
     * Gets value from elements.
     * @param webElement
     * @param attribute
     * @return value from element
     */
    public static String getAttributeValueFromElement(final WebElement webElement, final String attribute) {
        return webElement.getAttribute(attribute);
    }

    /**
     * Click by element.
     * @param byElement
     */
    public static void clickElement(final By byElement) {
        waitElement(byElement);
        WebDriverManager.getInstance().getWebDriver().findElement(byElement).click();
    }

    /**
     * Wait for by element.
     * @param byElem
     * @return WebElement
     */
    public static WebElement waitElement(final By byElem) {
        return WebDriverManager.getInstance().getWebDriverWait().until(ExpectedConditions.elementToBeClickable(byElem));
    }
}
