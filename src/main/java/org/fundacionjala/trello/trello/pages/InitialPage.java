package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitialPage extends BasePage {
    //@FindBy(partialLinkText = "Iniciar")
    @FindBy(css = "a[href*='/login']")
    WebElement btnInitSession;

    public InitialPage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public LoginPage clickInitSession() {
        WebElementsHelper.clickElement(btnInitSession);
        return new LoginPage(getWebDriver(), getWebDriverWait());
    }

    public LoginAtlassianPage clickInitSessionAtlassian() {
        WebElementsHelper.clickElement(btnInitSession);
        return new LoginAtlassianPage(getWebDriver(), getWebDriverWait());
    }
}
