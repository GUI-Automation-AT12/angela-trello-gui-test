package org.fundacionjala.trello.core.selenium.webdrivers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IDriver {
    private static final int IMPLICIT_WAIT = 60;
    private static final int EXPLICIT_WAIT = 80;

    /**
     * Init driver.
     * @return WebDriver
     */
    @Override
    public WebDriver initDriver() {
        ChromeDriverManager.getInstance(DriverManagerType.CHROME).version("87.0").setup();
        return new ChromeDriver();
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
