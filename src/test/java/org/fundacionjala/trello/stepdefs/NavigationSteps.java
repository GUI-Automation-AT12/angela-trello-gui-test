package org.fundacionjala.trello.stepdefs;

import org.fundacionjala.trello.trello.pages.TransporterPage;
import io.cucumber.java.en.When;
import java.net.MalformedURLException;

public class NavigationSteps {

    /**
     * Constructor.
     */
    public  NavigationSteps() { }

    /**
     * Navigate to url.
     * @param pageName
     * @throws MalformedURLException
     */
    @When("I navigate to {word} page")
    public void navigateToPage(final String pageName) throws MalformedURLException {
        TransporterPage.navigateToPage(pageName);
    }
}
