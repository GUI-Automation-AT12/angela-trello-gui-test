package org.fundacionjala.trello.unit;

import org.fundacionjala.trello.trello.config.Environment;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.trello.pages.InitialPage;
import org.fundacionjala.trello.trello.pages.LoginAtlassianPage;
import org.fundacionjala.trello.trello.pages.TransporterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LoginTest {

    /**
     * Quite webDriver.
     */
    @AfterMethod
    public void tearDown() {
        WebDriverManager.getInstance().quite();
    }

    /**
     * Login with valid credentials.
     */
    @Test
    public void loginWithValidCredentialsInAtlassian() {
        TransporterPage.navigateToPage();
        InitialPage initialPage = new InitialPage();
        LoginAtlassianPage loginAtlassianPage = initialPage.clickInitSessionAtlassian();
        loginAtlassianPage.login(Environment.getInstance().getEmail(), Environment.getInstance().getPassword());
    }
}
