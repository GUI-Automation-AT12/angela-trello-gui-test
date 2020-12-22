package org.fundacionjala.trello.core.webdrivers;

import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome implements IDriver {
    @Override
    public WebDriver initDriver() {
        FirefoxDriverManager.getInstance(DriverManagerType.CHROME).setup();
        return new ChromeDriver();
    }
}
