package org.fundacionjala.trello.trello.pages.menu;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.openqa.selenium.By;

public class BoardMenu extends BasePage {
    private String boardNameSelector = "//div[@data-test-id='header-boards-menu-popover']//div[contains(text(),'%s')]";
    private String teamNameSelector = "//span[contains(text(),'%s')]";

    private String getName(final String locator, final String name) {
        By board = By.xpath(String.format(locator, name));
        String nameOfElement = WebElementsHelper.getTextFromBy(board);
        return nameOfElement;
    }

    /**
     * Get board's name from boardMenu.
     * @param name of board
     * @return the name of board
     */
    public String getBoardName(final String name) {
        return getName(boardNameSelector, name);
    }

    /**
     * Get team's name from boardMenu.
     * @param name of team
     * @return the name of team
     */
    public String getTeamName(final String name) {
        return getName(teamNameSelector, name);
    }
}
