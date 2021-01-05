package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.entities.Team;
import org.fundacionjala.trello.trello.pages.TeamPage;
import org.fundacionjala.trello.trello.pages.popup.AddComponentPopup;
import org.fundacionjala.trello.trello.pages.popup.CreateTeamPopup;
import org.fundacionjala.trello.trello.pages.popup.MembersPopup;
import org.fundacionjala.trello.trello.pages.topmenu.TopMenu;
import org.testng.Assert;

import java.util.Map;

public class TeamSteps {
    private Context context;
    private Team team;
    private TopMenu topMenu;
    private AddComponentPopup addComponentPopup;
    private CreateTeamPopup createTeamPopup;
    private MembersPopup membersPopup;
    private TeamPage teamPage;

    /**
     * Constructor.
     * @param sharedContext
     */
    public TeamSteps(final Context sharedContext) {
        context = sharedContext;
        topMenu = new TopMenu();
        team = new Team();
    }

    /**
     * Select create team button.
     */
    @When("I select create team button")
    public void selectCreateTeamButton() {
        addComponentPopup = topMenu.clickAddButton();
        createTeamPopup = addComponentPopup.clickAddTeamButton();
    }

    /**
     * Create a new team.
     * @param teamInfo
     */
    @And("I create a team with the following information")
    public void createATeamWithTheFollowingInformation(final Map<String, String> teamInfo) {
        team.processInformation(teamInfo);
        membersPopup = createTeamPopup.createTeam(team);
        teamPage = membersPopup.clickAddMembersLate();
        context.saveData("organization", WebDriverManager.getInstance().getWebDriver().getCurrentUrl());
    }

    /**
     * Verify the new team's name.
     */
    @Then("I should see team name in Teams page")
    public void verifyTeamNameIsDisplayedInTeamsPage() {
        String actualName = teamPage.getTeamName();
        String expectedName = team.getName();
        Assert.assertEquals(actualName, expectedName);
    }
}
