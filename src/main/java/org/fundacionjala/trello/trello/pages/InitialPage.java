package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InitialPage extends BasePage {
    @FindBy(css = "a[href*='/login']")
    private WebElement btnInitSession;

    /**
     * Clicks init session button.
     * @return LoginPage
     */
    public LoginPage clickInitSession() {
        WebElementsHelper.clickElement(btnInitSession);
        return new LoginPage();
    }

    /**
     * Clicks init session Atlassian button.
     * @return LoginAtlassianPage
     */
    public LoginAtlassianPage clickInitSessionAtlassian() {
        WebElementsHelper.clickElement(btnInitSession);
        return new LoginAtlassianPage();
    }
}
