package org.fundacionjala.trello.trello.pages.menu;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.openqa.selenium.By;

public class LeftMenu extends BasePage {
    private String teamNameLocator = "//span[@data-test-id='home-team-tab-name' and contains(text(),'%s')]";

    /**
     * Get name of team.
     * @param teamName to find
     * @return the name of the team
     */
    public String getTeamName(final String teamName) {
        By by = By.xpath(String.format(teamNameLocator, teamName));
        String team = WebElementsHelper.getTextFromBy(by);
        return team;
    }
}
