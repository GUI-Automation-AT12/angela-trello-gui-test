package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.trello.config.Environment;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public final class TransporterPage {
    public static final HashMap<String, String> PAGE_URL = new HashMap<>();
    static {
        //User Profile
        PAGE_URL.put("Profile", "angelamariela/profile");
        PAGE_URL.put("Board", "angelamariela/boards");
        PAGE_URL.put("Settings", "settings");
    }

    /**
     * Constructor.
     */
    private TransporterPage() {
    }

    /**
     * Navigates to url.
     * @param url
     * @throws MalformedURLException
     */
    private static void navigateToUrl(final String url) throws MalformedURLException {
        WebDriverManager.getInstance().getWebDriver().navigate().to(new URL(url));
    }

    /**
     * Navigates to a page.
     * @param pageName
     * @throws MalformedURLException
     */
    public static void navigateToPage(final String pageName) throws MalformedURLException {
        navigateToUrl(Environment.getInstance().getBaseUrl().concat(PAGE_URL.get(pageName)));
    }

    /**
     * Navigates to a base page.
     * @throws MalformedURLException
     */
    public static void navigateToPage() {
        WebDriverManager.getInstance().getWebDriver().get(Environment.getInstance().getBaseUrl());
    }

    /**
     * Refreshes the page.
     */
    public static void refreshPage() {
        WebDriverManager.getInstance().getWebDriver().navigate().refresh();
    }
}
