package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.core.utils.user.UserReader;
import org.fundacionjala.trello.trello.entities.User;
import org.fundacionjala.trello.trello.pages.*;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
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

    public UpdateProfileStep(final Context sharedContext) {
        this.context = sharedContext;
        user = new User();
    }

    @Given("I log in to Trello with {word} user credentials")
    public void logInToTrelloWithUserCredentials(final String typeUser) throws IOException, ParseException {
        TransporterPage.navigateToPage();
        InitialPage initialPage = new InitialPage();
        loginAtlassianPage = initialPage.clickInitSessionAtlassian();
        loginAtlassianPage.login(UserReader.getEmail(typeUser), UserReader.getPassword(typeUser));
        context.saveData("typeUser", typeUser);
    }

    @When("I edit my profile with the following information")
    public void editMyProfile(final Map<String, String> userInformation) {
        user.processInformation(userInformation);
        profilePage.updateProfile(user);
    }

    @Then("{string} message should be displayed in Profile and Visibility section")
    public void verifyMessageIsDisplayedInProfileAndVisibilitySection(final String expectedMessage) {
        Assert.assertTrue(profilePage.getMessageOfUpdatedProfile());
    }

    @And("My profile information should be updated in Profile and Visibility section")
    public void verifyMmyProfileInformationIsUpdatedInProfileAndVisibilitySection() {
        SoftAssert softAssert = new SoftAssert();
        Map<String, String> actualProfileInfo = profilePage.getUserInformationAsMap(user.getUpdatedFields());
        Map<String, String> userInfo = new HashMap<>();
        //userInfo.put("username", "juan");
        //userInfo.put("bio", "juanbio");
        //Map<String, String> expectedProfileInfo = userInfo;
        Map<String, String> expectedProfileInfo = user.getUpdatedInfo();
        actualProfileInfo.forEach((field, actualValue) -> {
            softAssert.assertEquals(actualValue, expectedProfileInfo.get(field), "The field: " + field+" were not the expected.");
        });
        softAssert.assertAll();
        //ver cual es mejor
        //Assert.assertEquals(actualProfileInfo.get("username"), expectedProfileInfo.get("username"));
        //Assert.assertEquals(actualProfileInfo.get("bio"), expectedProfileInfo.get("bio"));
    }

    @And("My username should be updated into Top Content")
    public void verifyUsernameIsUpdatedIntoTopContent() {
        String actualUsername = profilePage.getUsernameFromTopContent();
        String expectedUsername = user.getUsername();
        Assert.assertEquals(actualUsername, expectedUsername);
    }

    @AfterTest
    public void quite() {
        WebDriverManager.getInstance().quite();
    }
}
