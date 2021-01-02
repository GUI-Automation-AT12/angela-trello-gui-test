package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.core.utils.user.UserReader;
import org.fundacionjala.trello.trello.entities.User;
import org.fundacionjala.trello.trello.pages.HomePage;
import org.fundacionjala.trello.trello.pages.InitialPage;
import org.fundacionjala.trello.trello.pages.LoginAtlassianPage;
import org.fundacionjala.trello.trello.pages.ProfilePage;
import org.fundacionjala.trello.trello.pages.TransporterPage;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UpdateProfileStep {
    private LoginAtlassianPage loginAtlassianPage;
    private HomePage homePage;
    private Context context;
    private User user;
    private ProfilePage profilePage = new ProfilePage();

    /**
     * Constructor.
     * @param sharedContext
     */
    public UpdateProfileStep(final Context sharedContext) {
        this.context = sharedContext;
        user = new User();
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
        context.saveData("typeUser", typeUser);
    }

    /**
     * Edit user's profile.
     * @param userInformation
     */
    @When("I edit my profile with the following information")
    public void editMyProfile(final Map<String, String> userInformation) {
        user.processInformation(userInformation);
        profilePage.updateProfile(user);
    }

    /**
     * Verify message after user's information update.
     * @param expectedMessage
     */
    @Then("{string} message should be displayed in Profile and Visibility section")
    public void verifyMessageIsDisplayedInProfileAndVisibilitySection(final String expectedMessage) {
        Assert.assertTrue(profilePage.getMessageOfUpdatedProfile());
    }

    /**
     * Verify user's information after update.
     */
    @And("My profile information should be updated in Profile and Visibility section")
    public void verifyMmyProfileInformationIsUpdatedInProfileAndVisibilitySection() {
        SoftAssert softAssert = new SoftAssert();
        Map<String, String> actualProfileInfo = profilePage.getUserInformationAsMap(user.getUpdatedFields());
        Map<String, String> userInfo = new HashMap<>();
        Map<String, String> expectedProfileInfo = user.getUpdatedInfo();
        actualProfileInfo.forEach((field, actualValue) -> {
            softAssert.assertEquals(actualValue, expectedProfileInfo.get(field));
        });
        softAssert.assertAll();
    }

    /**
     * Verify username into top content.
     */
    @And("My username should be updated into Top Content")
    public void verifyUsernameIsUpdatedIntoTopContent() {
        String actualUsername = profilePage.getUsernameFromTopContent();
        String expectedUsername = user.getUsername();
        Assert.assertEquals(actualUsername, expectedUsername);
    }
}
