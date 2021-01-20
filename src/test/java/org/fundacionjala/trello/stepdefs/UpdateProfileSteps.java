package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.entities.User;
import org.fundacionjala.trello.trello.ui.pages.HomePage;
import org.fundacionjala.trello.trello.ui.pages.LoginAtlassianPage;
import org.fundacionjala.trello.trello.ui.pages.ProfilePage;
import org.fundacionjala.trello.trello.ui.pages.TransporterPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.net.MalformedURLException;
import java.util.Map;

public class UpdateProfileSteps {
    private LoginAtlassianPage loginAtlassianPage;
    private HomePage homePage;
    private Context context;
    private User user;
    private ProfilePage profilePage = new ProfilePage();

    /**
     * Constructor.
     * @param sharedContext
     */
    public UpdateProfileSteps(final Context sharedContext) {
        this.context = sharedContext;
        user = new User();
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
        Assert.assertTrue(profilePage.isUpdatedProfileMessageDisplayed());
    }

    /**
     * Verify user's information after update.
     */
    @Then("my profile information should be updated in Profile and Visibility section")
    public void verifyMmyProfileInformationIsUpdatedInProfileAndVisibilitySection() {
        SoftAssert softAssert = new SoftAssert();
        Map<String, String> actualProfileInfo = profilePage.getUserInformationAsMap(user.getUpdatedFields());
        Map<String, String> expectedProfileInfo = user.getUpdatedInfo();
        actualProfileInfo.forEach((field, actualValue) -> {
            softAssert.assertEquals(actualValue, expectedProfileInfo.get(field));
        });
        softAssert.assertAll();
    }

    /**
     * Reload the page.
     * @throws MalformedURLException
     */
    @When("I reload the page")
    public void reloadThePage() throws MalformedURLException {
        TransporterPage.setUsername(user.getUsername());
        TransporterPage.navigateToPage("Profile");
    }

    /**
     * Verify username into top content.
     */
    @Then("my username should be updated into Top Content")
    public void verifyUsernameIsUpdatedIntoTopContent() {
        String actualUsername = profilePage.getUsernameFromTopContent();
        String expectedUsername = "@".concat(user.getUsername());
        Assert.assertEquals(actualUsername, expectedUsername);
    }
}
