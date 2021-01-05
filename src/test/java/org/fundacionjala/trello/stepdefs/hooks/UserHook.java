package org.fundacionjala.trello.stepdefs.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.core.utils.user.UserReader;
import org.fundacionjala.trello.trello.entities.User;
import org.fundacionjala.trello.trello.pages.LoginAtlassianPage;
import org.fundacionjala.trello.trello.pages.ProfilePage;
import org.json.simple.parser.ParseException;

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

    /**
     * Reset user' information.
     * @throws IOException
     * @throws ParseException
     */
    @After(value = "@ResetUserInformation", order = 1)
    public void restoreUserProfile() throws IOException, ParseException {
        User user = new User();
        Map<String, String> userInformation = new HashMap<>();
        //User userJson = UserReader.getUser();
        userInformation.put("username", UserReader.getUsername(context.getValueData("typeUser")));
        userInformation.put("bio", UserReader.getBio(context.getValueData("typeUser")));
        user.processInformation(userInformation);
        profilePage.updateProfile(user);
    }
}
