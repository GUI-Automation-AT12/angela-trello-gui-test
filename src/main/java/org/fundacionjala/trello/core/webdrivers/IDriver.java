package org.fundacionjala.trello.core.webdrivers;

import org.openqa.selenium.WebDriver;

public interface IDriver {
    /**
     * Inits Driver.
     * @return WebDriver
     */
    WebDriver initDriver();

    /**
     * Gets implicit wait.
     * @return int
     */
    int getImplicitWait();

    /**
     * Gets explicit wait.
     * @return int
     */
    int getExplicitWait();
}
