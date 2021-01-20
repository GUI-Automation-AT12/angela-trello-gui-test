package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.selenium.WebElementsHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TeamPage extends BasePage {
    @FindBy(css = "div.tabbed-pane-header-details h1")
    private WebElement teamName;

    /**
     * Get team name.
     * @return name
     */
    public String getTeamName() {
        WebElementsHelper.waitElement(teamName);
        return WebElementsHelper.getTextFromElement(teamName);
    }
}
