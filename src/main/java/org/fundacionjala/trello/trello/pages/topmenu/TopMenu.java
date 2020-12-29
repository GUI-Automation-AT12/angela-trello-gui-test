package org.fundacionjala.trello.trello.pages.topmenu;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.fundacionjala.trello.trello.pages.popup.CreateBoardPopup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends BasePage {
    @FindBy(css = "button[data-test-id='header-create-menu-button']")
    private WebElement btnAddBoard;

    /**
     * Clicks on add button.
     * @return CreateBoardPopup page
     */
    public CreateBoardPopup clickAddBoard() {
        WebElementsHelper.clickElement(btnAddBoard);
        return new CreateBoardPopup();
    }

    /**
     * Gets add board button.
     * @return WebElement
     */
    public WebElement getBtnAddBoard() {
        return btnAddBoard;
    }
}
