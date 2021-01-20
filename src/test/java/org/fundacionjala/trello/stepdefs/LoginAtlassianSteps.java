package org.fundacionjala.trello.stepdefs;

import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.utils.user.UserReader;
import org.fundacionjala.trello.trello.ui.pages.HomePage;
import org.fundacionjala.trello.trello.ui.pages.InitialPage;
import org.fundacionjala.trello.trello.ui.pages.LoginAtlassianPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.trello.ui.pages.TransporterPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;

public class LoginAtlassianSteps {
    private LoginAtlassianPage loginAtlassianPage;
    private HomePage homePage;
    private Context context;

    /**
     * Constructor.
     * @param sharedContext
     */
    public LoginAtlassianSteps(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Go login page.
     * @throws MalformedURLException
     */
    @Given("I'm in Login page")
    public void stayInLoginPage() throws MalformedURLException {
        TransporterPage.navigateToPage();
        InitialPage initialPage = new InitialPage();
        loginAtlassianPage = initialPage.clickInitSessionAtlassian();
    }

    /**
     * Login to Trello with valid credentials.
     * @param typeUser
     * @throws IOException
     * @throws ParseException
     */
    @Given("I log in to Trello with {word} user credentials")
    public void logInToTrelloWithUserCredentials(final String typeUser) throws IOException, ParseException {
        TransporterPage.navigateToPage();
        InitialPage initialPage = new InitialPage();
        loginAtlassianPage = initialPage.clickInitSessionAtlassian();
        homePage = loginAtlassianPage.login(UserReader.getEmail(typeUser), UserReader.getPassword(typeUser));
        context.saveEntity("user", UserReader.getUser(typeUser));
    }

    /**
     * Verify if homePage is displayed.
     */
    @Then("the Home Page should be displayed")
    public void verifyHomePageIsDisplayed() {
        Assert.assertNotNull(homePage);
    }

    /**
     * Set user and password empty.
     */
    @When("I set user and password with empty fields")
    public void setUserAndPasswordWithEmptyFields() {
        homePage = loginAtlassianPage.login("", "");
    }
}
