package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeletedBoardPage extends BasePage {
    @FindBy(css = "div#content h1")
    private WebElement boardNotFoundText;

    /**
     * Get board not found message.
     * @return message
     */
    public String getBoardNotFoundMessage() {
        WebElementsHelper.waitElement(boardNotFoundText);
        return WebElementsHelper.getTextFromElement(boardNotFoundText);
    }
}
