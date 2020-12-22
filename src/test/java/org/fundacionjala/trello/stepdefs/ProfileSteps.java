package org.fundacionjala.trello.stepdefs;

import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.entities.User;
import org.fundacionjala.trello.trello.utils.Authentication;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.Map;

public class ProfileSteps {
    private Context context;

    public  ProfileSteps(final Context context) {
        this.context = context;
    }
    //Entities
    private User user;
    @And("I edit my profile with the following information$")
    public void editMyProfile(final Map<String, String> userInformation) {
        user.processInformation(userInformation);

    }

    @Given("I log in to Trello with (.*?) credentials")
    public void logInToTrelloWithUserCredentials() {
        Authentication.getLoggedReqSpec();
    }
}
