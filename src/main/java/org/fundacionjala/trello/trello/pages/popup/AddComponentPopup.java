package org.fundacionjala.trello.trello.pages.popup;

import org.fundacionjala.trello.core.selenium.WebElementsHelper;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddComponentPopup extends BasePage {
    @FindBy(css = "button[data-test-id='header-create-board-button']")
    private WebElement addBoardButton;

    @FindBy(css = "button[data-test-id='header-create-team-button']")
    private WebElement addTeamButton;

    /**
     * Click addBoardButton.
     * @return CreateBoardPopup
     */
    public CreateBoardPopup clickAddBoardBtn() {
        WebElementsHelper.clickElement(addBoardButton);
        return new CreateBoardPopup();
    }

    /**
     * Click addTeamButton.
     * @return CreateTeamPopup
     */
    public CreateTeamPopup clickAddTeamButton() {
        WebElementsHelper.clickElement(addTeamButton);
        return new CreateTeamPopup();
    }
}
