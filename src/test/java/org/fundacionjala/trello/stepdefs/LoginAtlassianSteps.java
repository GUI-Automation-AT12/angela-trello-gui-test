package org.fundacionjala.trello.stepdefs;

import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.config.Environment;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.trello.pages.HomePage;
import org.fundacionjala.trello.trello.pages.InitialPage;
import org.fundacionjala.trello.trello.pages.LoginAtlassianPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.trello.pages.TransporterPage;
import org.testng.Assert;

import java.net.MalformedURLException;

public class LoginAtlassianSteps {
    private LoginAtlassianPage loginAtlassianPage;
    private HomePage homePage;
    private Context context;

    public  LoginAtlassianSteps(final Context sharedContext) {
        this.context = sharedContext;
    }

    @Given("I'm in Login page")
    public void stayInLoginPage() throws MalformedURLException {
        TransporterPage.navigateToPage();
        InitialPage initialPage = new InitialPage();
        loginAtlassianPage = initialPage.clickInitSessionAtlassian();
    }

    @When("I set user and password")
    public void setUserAndPassword() {
        homePage = loginAtlassianPage.login(Environment.getInstance().getEmail(), Environment.getInstance().getPassword());
        //loginAtlassianPage.login(context.getEmail(kindUser), context.getPassword(kindUser));
    }

    @Then("the Home Page should be displayed")
    public void verifyHomePageIsDisplayed() {
        Assert.assertNotNull(homePage);
    }

    @When("I set user and password with empty fields")
    public void iSetUserAndPasswordWithEmptyFields() {
        homePage = loginAtlassianPage.login("", "");
    }

    /*@After
    public void end() {
        WebDriverManager.getInstance().quite();
    }*/
}
