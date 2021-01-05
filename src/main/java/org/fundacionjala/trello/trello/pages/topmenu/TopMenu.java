package org.fundacionjala.trello.trello.pages.topmenu;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.fundacionjala.trello.trello.pages.popup.AddComponentPopup;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopMenu extends BasePage {
    @FindBy(css = "button[data-test-id='header-create-menu-button']")
    private WebElement addBtn;

    /**
     * Clicks on add button.
     * @return CreateBoardPopup page
     */
    public AddComponentPopup clickAddButton() {
        WebElementsHelper.clickElement(addBtn);
        return new AddComponentPopup();
    }

    /**
     * Gets add board button.
     * @return WebElement
     */
    public WebElement getAddButton() {
        return addBtn;
    }
}
