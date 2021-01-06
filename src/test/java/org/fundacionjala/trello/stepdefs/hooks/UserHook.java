package org.fundacionjala.trello.stepdefs.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.entities.User;
import org.fundacionjala.trello.trello.pages.ProfilePage;
import java.util.HashMap;
import java.util.Map;

public class UserHook {
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
     */
    @After(value = "@ResetUserInformation", order = 1)
    public void restoreUserProfile() {
        User user = new User();
        Map<String, String> userInformation = new HashMap<>();
        User userJson = (User) context.getEntity("user");
        userInformation.put("username", userJson.getUsername());
        userInformation.put("bio", userJson.getBio());
        user.processInformation(userInformation);
        profilePage.updateProfile(user);
    }
}
