package org.fundacionjala.trello.stepdefs.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.core.utils.user.UserReader;
import org.fundacionjala.trello.trello.entities.User;
import org.fundacionjala.trello.trello.pages.*;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserHook {
    private LoginAtlassianPage loginAtlassianPage;
    private Context context;
    private ProfilePage profilePage = new ProfilePage();

    /**
     * Constructor.
     * @param sharedContext
     */
    public UserHook(final Context sharedContext) {
        this.context = sharedContext;
    }

    @After(value = "@ResetUserInformation", order = 1)
    public void restoreUserProfile() throws IOException, ParseException {
        User user = new User();
        Map<String, String> userInformation = new HashMap<>();
        userInformation.put("username", UserReader.getUsername(context.getValueData("typeUser")));
        userInformation.put("bio", UserReader.getBio(context.getValueData("typeUser")));
        user.processInformation(userInformation);
        TransporterPage.navigateToPage();
        InitialPage initialPage = new InitialPage();
        loginAtlassianPage = initialPage.clickInitSessionAtlassian();
        loginAtlassianPage.login(UserReader.getEmail(context.getValueData("typeUser")), UserReader.getPassword(context.getValueData("typeUser")));
        profilePage.updateProfile(user);
    }
}
