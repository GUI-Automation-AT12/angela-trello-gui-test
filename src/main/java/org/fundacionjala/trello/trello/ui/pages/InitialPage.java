package org.fundacionjala.trello.trello.ui.pages;

import org.fundacionjala.trello.core.selenium.WebElementsHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitialPage extends BasePage {
    @FindBy(css = "a[href*='/login']")
    private WebElement initSessionBtn;

    /**
     * Clicks init session Atlassian button.
     * @return LoginAtlassianPage
     */
    public LoginAtlassianPage clickInitSessionAtlassian() {
        WebElementsHelper.clickElement(initSessionBtn);
        return new LoginAtlassianPage();
    }
}
