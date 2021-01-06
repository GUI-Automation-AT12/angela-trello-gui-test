package org.fundacionjala.trello.stepdefs;

import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.entities.User;
import org.fundacionjala.trello.trello.pages.TransporterPage;
import io.cucumber.java.en.When;
import java.net.MalformedURLException;

public class NavigationSteps {
    private Context context;

    /**
     * Constructor.
     * @param sharedContext
     */
    public NavigationSteps(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Navigate to url.
     * @param pageName
     * @throws MalformedURLException
     */
    @When("I navigate to {word} page")
    public void navigateToPage(final String pageName) throws MalformedURLException {
        User user = (User) (context.getEntity("user"));
        TransporterPage.setUsername(user.getUsername());
        TransporterPage.navigateToPage(pageName);
    }
}
