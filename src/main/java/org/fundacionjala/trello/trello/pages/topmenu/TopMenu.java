package org.fundacionjala.trello.trello.pages.topmenu;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.fundacionjala.trello.trello.pages.popup.CreateBoardPopup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TopMenu extends BasePage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    @FindBy(css = "button[data-test-id='header-create-board-button']")
    WebElement btnAddBoard;

    public TopMenu(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public CreateBoardPopup clickAddBoard() {
        WebElementsHelper.clickElement(btnAddBoard);
        return new CreateBoardPopup(getWebDriver(), getWebDriverWait());
    }
}
