package org.fundacionjala.trello.unit;

import org.fundacionjala.trello.trello.utils.user.UserReader;
import org.fundacionjala.trello.core.selenium.WebDriverManager;
import org.fundacionjala.trello.trello.pages.InitialPage;
import org.fundacionjala.trello.trello.pages.LoginAtlassianPage;
import org.fundacionjala.trello.trello.pages.TransporterPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTest {

    /**
     * Quite webDriver.
     */
    @AfterMethod
    public void tearDown() {
        WebDriverManager.getInstance().quit();
    }

    /**
     * Login with valid credentials.
     */
    @Test
    public void loginWithValidCredentialsInAtlassian() throws IOException, ParseException {
        TransporterPage.navigateToPage();
        InitialPage initialPage = new InitialPage();
        LoginAtlassianPage loginAtlassianPage = initialPage.clickInitSessionAtlassian();
        loginAtlassianPage.login(UserReader.getEmail("Editable"), UserReader.getPassword("Editable"));
    }
}
