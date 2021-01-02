package org.fundacionjala.trello.stepdefs;

import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.pages.TransporterPage;
import io.cucumber.java.en.When;
import java.net.MalformedURLException;

public class NavigationSteps {
    private Context context;

    /**
     * Constructor.
     * @param sharedContext
     */
    public  NavigationSteps(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Navigate to a url.
     * @param pageName
     * @throws MalformedURLException
     */
    @When("I navigate to {word} page")
    public void navigateToProfilePage(final String pageName) throws MalformedURLException {
        TransporterPage.navigateToPage(pageName);
    }
}
