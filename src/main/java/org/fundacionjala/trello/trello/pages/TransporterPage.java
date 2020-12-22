package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.trello.config.Environment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class TransporterPage {
    private static final HashMap<String, String> PAGE_URL = new HashMap<>();
    static {
        //User Profile
        PAGE_URL.put("PROFILE", "mariangela");
        PAGE_URL.put("SETTINGS", "settings");
    }
    public static void navigateToPage(final String pageName) throws MalformedURLException {
        navigateToUrl(Environment.getInstance().getBaseUrl().concat(PAGE_URL.get(pageName)));

    }

    private static void navigateToUrl(final String url) throws MalformedURLException {
        WebDriverManager.getInstance().getWebDriver().navigate().to(new URL(url));
    }
}
