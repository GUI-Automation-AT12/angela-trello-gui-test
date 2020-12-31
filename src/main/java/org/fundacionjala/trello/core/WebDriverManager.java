package org.fundacionjala.trello.core;

import org.fundacionjala.trello.core.webdrivers.DriverFactory;
import org.fundacionjala.trello.trello.config.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public final class WebDriverManager {
    private static WebDriverManager webDriverManager;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private String browser = Environment.getInstance().getBrowser();

    /**
     * Constructor.
     */
    private WebDriverManager() {
        webDriver = DriverFactory.getWebDriver(browser).initDriver();
        int implicitWait = DriverFactory.getWebDriver(browser).getImplicitWait();
        int explicitWait = DriverFactory.getWebDriver(browser).getExplicitWait();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, explicitWait);
    }

    /**
     * Gets instance.
     * @return a instance of WebDriverManager
     */
    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }

    /**
     * Gets WebDRIVER.
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
     * Quite.
     */
    public void quite() {
        webDriverManager = null;
        webDriver.quit();
    }
}
