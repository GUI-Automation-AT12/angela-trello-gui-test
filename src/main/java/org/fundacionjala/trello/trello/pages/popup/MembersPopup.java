package org.fundacionjala.trello.trello.pages.popup;

import org.fundacionjala.trello.core.selenium.WebElementsHelper;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.fundacionjala.trello.trello.pages.TeamPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MembersPopup extends BasePage {
    @FindBy(css = "a[data-test-id='show-later-button']")
    private WebElement addMembersLateOption;

    @FindBy(css = "input[data-test-id='add-members-input']")
    private WebElement membersSearchBox;

    @FindBy(css = "button[data-test-id='team-invite-submit-button']")
    private WebElement inviteToTeamBtn;

    private String memberLocator = "//div[contains(text(),'%s')]";

    /**
     * Click add members late option.
     * @return a new TeamPage
     */
    public TeamPage clickAddMembersLate() {
        WebElementsHelper.clickElement(addMembersLateOption);
        return new TeamPage();
    }

    /**
     * Select members for the team.
     * @param members list of members
     * @return a new TeamPage
     */
    public TeamPage selectMember(final List<String> members) {
        for (String member: members) {
            WebElementsHelper.clickElement(membersSearchBox);
            WebElementsHelper.sendKeys(membersSearchBox, member);
        }
        WebElementsHelper.clickElement(inviteToTeamBtn);
        return new TeamPage();
    }
}
