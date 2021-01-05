package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.core.utils.user.UserReader;
import org.fundacionjala.trello.trello.config.EnvironmentTrello;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public final class TransporterPage {
    public static final HashMap<String, String> PAGE_URL = new HashMap<>();
    static {
        //User
        String username = null;
        try {
            username = UserReader.getUsername("Editable");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PAGE_URL.put("Profile", username + "/profile");
        PAGE_URL.put("Board", username + "/boards");
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
     * Navigates to specific url.
     * @param url
     * @throws MalformedURLException
     */
    public static void navigateToSpecificUrl(final String url) throws MalformedURLException {
        WebDriverManager.getInstance().getWebDriver().navigate().to(new URL(url));
    }

    /**
     * Navigates to a page.
     * @param pageName
     * @throws MalformedURLException
     */
    public static void navigateToPage(final String pageName) throws MalformedURLException {
        navigateToUrl(EnvironmentTrello.getInstance().getBaseUrl().concat(PAGE_URL.get(pageName)));
    }

    /**
     * Navigates to a base page.
     * @throws MalformedURLException
     */
    public static void navigateToPage() {
        WebDriverManager.getInstance().getWebDriver().get(EnvironmentTrello.getInstance().getBaseUrl());
    }

    /**
     * Refreshes the page.
     */
    public static void refreshPage() {
        WebDriverManager.getInstance().getWebDriver().navigate().refresh();
    }
}
