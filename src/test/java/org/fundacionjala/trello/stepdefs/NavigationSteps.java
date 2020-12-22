package org.fundacionjala.trello.stepdefs;

import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.pages.TransporterPage;
import io.cucumber.java.en.When;
import java.net.MalformedURLException;

public class NavigationSteps {
    private Context context;
    public  NavigationSteps(final Context context) {
        this.context = context;
    }
    @When("I navigate to (.*?) section")
    public void navigateToProfilePage(final String pageName) throws MalformedURLException {
        TransporterPage.navigateToPage(pageName);
    }
}
