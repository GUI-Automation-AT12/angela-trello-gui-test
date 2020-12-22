package org.fundacionjala.trello.core.webdrivers;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFox implements IDriver {
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        return new FirefoxDriver();
    }
}
