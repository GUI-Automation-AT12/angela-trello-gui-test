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

    public BasePage(final WebDriver driver, final WebDriverWait wait) {
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
        this.webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        PageFactory.initElements(driver, this);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public WebElement waitElement(WebElement element) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
