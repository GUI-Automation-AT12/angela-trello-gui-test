package org.fundacionjala.trello.core.webdrivers;

import java.util.HashMap;
import java.util.Map;

public final class DriverFactory {
    private static Map<String, IDriver> browsers = new HashMap<>();

    /**
     * Constructor.
     */
    private DriverFactory() { }
    static {
        browsers.put("chrome", new Chrome());
        browsers.put("firefox", new FireFox());
    }

    /**
     * Uses for select a Browser.
     * @param browser Parameter content a Browser Name.
     * @return a webDriver.
     */
    public static IDriver getWebDriver(final String browser) {
        return browsers.get(browser);
    }
}
