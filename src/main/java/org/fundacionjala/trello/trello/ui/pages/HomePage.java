package org.fundacionjala.trello.trello.ui.pages;

import org.fundacionjala.trello.trello.ui.menu.TopMenu;

public class HomePage extends BasePage {

    private TopMenu topMenu;

    /**
     * Constructor.
     */
    public HomePage() {
        topMenu = new TopMenu();
    }

    /**
     * Gets top menu.
     * @return TopMenu
     */
    public TopMenu getTopMenu() {
        return topMenu;
    }
}
