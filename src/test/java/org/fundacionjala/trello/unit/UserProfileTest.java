package org.fundacionjala.trello.unit;

import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.core.utils.user.UserReader;
import org.fundacionjala.trello.trello.config.Environment;
import org.fundacionjala.trello.trello.entities.User;
import org.fundacionjala.trello.trello.pages.InitialPage;
import org.fundacionjala.trello.trello.pages.LoginAtlassianPage;
import org.fundacionjala.trello.trello.pages.ProfilePage;
import org.fundacionjala.trello.trello.pages.TransporterPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

public class UserProfileTest {
    private WebDriver webDriver;
    //private Map<String, Object> vars;
    //JavascriptExecutor js;
    private WebDriverWait webDriverWait;

    @BeforeTest
    public void setUp() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        //js = (JavascriptExecutor) webDriver;
        //vars = new HashMap<String, Object>();
        webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriver.get(Environment.getInstance().getBaseUrl());
    }

    @AfterTest
    public void tearDown() {
        WebDriverManager.getInstance().quite();
        //webDriver.quit();
    }

    @Test
    public void fillProfile() throws IOException, ParseException {
        InitialPage initialPage = new InitialPage(webDriver, webDriverWait);
        LoginAtlassianPage loginAtlassianPage = initialPage.clickInitSessionAtlassian();
        loginAtlassianPage.login(Environment.getInstance().getEmail(), Environment.getInstance().getPassword());
        TransporterPage.navigateToPage("PROFILE");
        Map<String, String> map = new HashMap<>();
        map.put("username", "mary");
        map.put("bio", "mary");
        User user = new User();
        user.processInformation(map);
        ProfilePage profilePage = new ProfilePage(webDriver, webDriverWait);
        user.processUIInformation(map, profilePage);
    }
}
