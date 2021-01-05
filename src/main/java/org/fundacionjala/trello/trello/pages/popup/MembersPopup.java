package org.fundacionjala.trello.trello.pages.popup;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.fundacionjala.trello.trello.pages.TeamPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MembersPopup extends BasePage {
    @FindBy(css = "a[data-test-id='show-later-button']")
    private WebElement addMembersLate;

    /**
     * Click add members late option.
     * @return TeamPage
     */
    public TeamPage clickAddMembersLate() {
        WebElementsHelper.clickElement(addMembersLate);
        return new TeamPage();
    }
}
