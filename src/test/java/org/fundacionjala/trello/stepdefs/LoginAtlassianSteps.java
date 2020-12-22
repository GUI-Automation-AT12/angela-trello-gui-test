package org.fundacionjala.trello.stepdefs;

import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.config.Environment;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.trello.pages.HomePage;
import org.fundacionjala.trello.trello.pages.InitialPage;
import org.fundacionjala.trello.trello.pages.LoginAtlassianPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAtlassianSteps {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private LoginAtlassianPage loginAtlassianPage;
    private HomePage homePage;
    private Context context;

    LoginAtlassianSteps(final Context context) {
        this.context = context;
    }

    @Before
    public void setup() {
        webDriver = WebDriverManager.getInstance().getWebDriver();
        //js = (JavascriptExecutor) driver;
        //vars = new HashMap<String, Object>();
        webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriver.get(Environment.getInstance().getBaseUrl());
    }

    @Given("The user is in login page")
    public void theUserIsInLoginPage() {
        InitialPage initialPage = new InitialPage(webDriver, webDriverWait);
        loginAtlassianPage = initialPage.clickInitSessionAtlassian();
    }

    @When("The user sets user and password")
    public void theUserSetsUserAndPassword() {
        homePage = loginAtlassianPage.login(Environment.getInstance().getEmail(), Environment.getInstance().getPassword());
    }

    @Then("The home page should be displayed")
    public void theHomePageShouldBeDisplayed() {
        //WebDriverManager.getInstance().quite();
    }
    @After
    public void end() {
        WebDriverManager.getInstance().quite();
    }
}
