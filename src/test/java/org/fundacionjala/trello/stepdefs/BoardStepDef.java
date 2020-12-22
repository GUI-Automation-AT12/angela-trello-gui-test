package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.core.context.Context;

public class BoardStepDef {
    private Context context;

    BoardStepDef(final Context context) {
        this.context = context;
    }
    @Given("I log in to Trello with valid credentials")
    public void iLogInToTrelloWithValidCredentials() {
    }

    @When("I navigate to create board page")
    public void iNavigateToCreateBoardPage() {
    }

    @And("I create a board with the following form data")
    public void iCreateABoardWithTheFollowingFormData() {
    }

    @Then("the board should be created")
    public void theBoardShouldBeCreated() {
    }
}
