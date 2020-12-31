package org.fundacionjala.trello.trello.pages.popup;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddComponentPopup extends BasePage {
    @FindBy(css = "button[data-test-id='header-create-board-button']")
    private WebElement addBoardButton;

    /**
     * Click addButton.
     * @return CreateBoardPopup
     */
    public CreateBoardPopup clickAddBoardBtn() {
        waitElement(addBoardButton);
        WebElementsHelper.clickElement(addBoardButton);
        return new CreateBoardPopup();
    }

    /**
     * Get addButton.
     * @return WebElement
     */
    public WebElement getAddBoardButton() {
        return addBoardButton;
    }
}
