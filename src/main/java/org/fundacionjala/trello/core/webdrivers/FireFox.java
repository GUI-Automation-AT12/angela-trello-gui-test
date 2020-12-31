package org.fundacionjala.trello.core.webdrivers;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox implements IDriver {
    public static final int IMPLICIT_WAIT = 30;
    public static final int EXPLICIT_WAIT = 40;

    /**
     * Init driver.
     * @return WebDriver
     */
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).version("84.0.1").setup();
        return new FirefoxDriver();
    }

    /**
     * Gets implicit wait.
     * @return int
     */
    @Override
    public int getImplicitWait() {
        return IMPLICIT_WAIT;
    }

    /**
     * Gets explicit wait.
     * @return int
     */
    @Override
    public int getExplicitWait() {
        return EXPLICIT_WAIT;
    }
}
