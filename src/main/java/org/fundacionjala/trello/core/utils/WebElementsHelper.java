package org.fundacionjala.trello.core.utils;

import org.openqa.selenium.WebElement;

public final class WebElementsHelper {
    /**
     * Constructor.
     */
    private WebElementsHelper() { }

    /**
     * Sends keys.
     * @param webElement
     * @param value
     */
    public static void sendKeys(final WebElement webElement, final String value) {
        //Actions act = new Actions(WebDriverManager.getInstance().getWebDriver());
        webElement.clear();
        //act.moveToElement(webElement).sendKeys(value).perform();
        webElement.sendKeys(value);
    }

    /**
     * Clicks on elements.
     * @param webElement
     */
    public static void clickElement(final WebElement webElement) {
        webElement.click();
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
     * Gets value from elements.
     * @param webElement
     * @param attibute
     * @return value from element
     */
    public static String getValueFromElement(final WebElement webElement, final String attibute) {
        return webElement.getAttribute(attibute);
    }
}
