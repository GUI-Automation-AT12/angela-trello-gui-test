package org.fundacionjala.trello.unit;

import org.fundacionjala.trello.trello.config.Environment;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.trello.pages.InitialPage;
import org.fundacionjala.trello.trello.pages.LoginAtlassianPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Map;

public class LoginTest {
    private WebDriver webDriver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private WebDriverWait webDriverWait;

    @BeforeTest
    public void setUp() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        //System.out.println(webDriver.toString());
        //js = (JavascriptExecutor) webDriver;
        //vars = new HashMap<String, Object>();
        webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriver.get(Environment.getInstance().getBaseUrl());
    }

    @AfterTest
    public void tearDown() {
        WebDriverManager.getInstance().quite();
    }

    /*@Test
    public void loginWithValidCredentials() {
        InitialPage initialPage = new InitialPage(webDriver, webDriverWait);
        LoginPage loginPage = initialPage.clickInitSession();
        loginPage.login(Environment.getInstance().getEmail(), Environment.getInstance().getPassword());
    }*/

    @Test
    public void loginWithValidCredentialsInAtlassian() {
        InitialPage initialPage = new InitialPage();
        LoginAtlassianPage loginAtlassianPage = initialPage.clickInitSessionAtlassian();
        loginAtlassianPage.login(Environment.getInstance().getEmail(), Environment.getInstance().getPassword());
    }
}
