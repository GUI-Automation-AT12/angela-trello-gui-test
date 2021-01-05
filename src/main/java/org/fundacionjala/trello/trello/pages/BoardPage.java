package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage extends BasePage {
    @FindBy(css = "div.board-canvas")
    private WebElement boardLists;

    @FindBy(css = "h1.board-header-btn-text")
    private WebElement boardName;

    /**
     * Gets name of board.
     * @return name of board created
     */
    public String getBoardName() {
        WebElementsHelper.waitElement(boardLists);
        return WebElementsHelper.getTextFromElement(boardName);
    }
}
