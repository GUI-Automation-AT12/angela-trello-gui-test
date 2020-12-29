package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    /**
     * Constructor.
     */
    public BasePage() {
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
        this.webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Gets WebDriver.
     * @return WebDriver
     */
    public WebDriver getWebDriver() {
        return webDriver;
    }

    /**
     * Gets WebDriverWait.
     * @return WebDriverWait
     */
    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    /**
     * Waits for a web element.
     * @param element
     * @return WebElement
     */
    public WebElement waitElement(final WebElement element) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
