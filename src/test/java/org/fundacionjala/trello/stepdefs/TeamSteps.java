package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.core.selenium.WebDriverManager;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.entities.Team;
import org.fundacionjala.trello.trello.pages.TeamPage;
import org.fundacionjala.trello.trello.pages.menu.BoardMenu;
import org.fundacionjala.trello.trello.pages.menu.LeftMenu;
import org.fundacionjala.trello.trello.pages.popup.AddComponentPopup;
import org.fundacionjala.trello.trello.pages.popup.CreateTeamPopup;
import org.fundacionjala.trello.trello.pages.popup.MembersPopup;
import org.fundacionjala.trello.trello.pages.menu.TopMenu;
import org.testng.Assert;
import java.util.List;
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
    @And("I define the following information for the team")
    public void defineTheFollowingInformation(final Map<String, String> teamInfo) {
        team.processInformation(teamInfo);
        membersPopup = createTeamPopup.createTeam(team);
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

    /**
     * Verify if the team's name is displayed on the board menu.
     */
    @And("the team name should be displayed on board menu")
    public void verifyTeamNameIsDisplayedOnBoardMenu() {
        BoardMenu boardMenu = topMenu.clickBoardButton();
        String actualTeamName = boardMenu.getTeamName(team.getName());
        String expectedBoardName = team.getName().toUpperCase();
        Assert.assertEquals(actualTeamName, expectedBoardName);
    }

    /**
     * Verify if the team's name is displayed on the left menu.
     */
    @Then("the team name should be displayed on left menu")
    public void verifyTeamNameIsDisplayedOnLeftMenu() {
        LeftMenu leftMenu = new LeftMenu();
        String actualTeamName = leftMenu.getTeamName(team.getName());
        String expectedBoardName = team.getName();
        Assert.assertEquals(actualTeamName, expectedBoardName);
    }

    /**
     * Create a team without members.
     */
    @And("I create a team without members")
    public void createATeamWithoutMembers() {
        teamPage = membersPopup.clickAddMembersLate();
        context.saveData("organization", WebDriverManager.getInstance().getWebDriver().getCurrentUrl());
    }
    /**
     * Add members to the team.
     * @param members for the team.
     */
    @And("I create a team with the following members")
    public void createATeamWithMembers(final List<String> members) {
        team.setMembers(members);
        teamPage = membersPopup.selectMember(team.getMembers());
        context.saveData("organization", WebDriverManager.getInstance().getWebDriver().getCurrentUrl());
    }


}
