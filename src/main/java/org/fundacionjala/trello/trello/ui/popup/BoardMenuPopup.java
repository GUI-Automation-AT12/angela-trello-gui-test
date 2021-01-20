package org.fundacionjala.trello.trello.ui.popup;

import org.fundacionjala.trello.core.selenium.WebElementsHelper;
import org.fundacionjala.trello.trello.ui.pages.BasePage;
import org.fundacionjala.trello.trello.ui.pages.DeletedBoardPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardMenuPopup extends BasePage {
    @FindBy(css = ".board-menu-header-title")
    private WebElement boardMenuTitle;

    @FindBy(css = ".js-open-more")
    private WebElement openMoreOption;

    @FindBy(css = ".js-close-board")
    private WebElement closeBoardOption;

    @FindBy(css = ".no-back input")
    private WebElement closeBoardBtn;

    @FindBy(css = "a.js-delete")
    private WebElement closePermanentlyOption;

    /**
     * Delete a board.
     * @return new DeletedBoardPage
     */
    public DeletedBoardPage closePermanentlyBoard() {
        WebElementsHelper.waitElement(boardMenuTitle);
        WebElementsHelper.clickElement(openMoreOption);
        WebElementsHelper.clickElement(closeBoardOption);
        WebElementsHelper.clickElement(closeBoardBtn);
        WebElementsHelper.clickElement(closePermanentlyOption);
        WebElementsHelper.clickElement(closeBoardBtn);
        return new DeletedBoardPage();
    }
}
