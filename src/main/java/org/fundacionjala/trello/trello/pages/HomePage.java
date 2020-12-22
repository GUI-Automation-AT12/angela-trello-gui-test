package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.trello.pages.topmenu.TopMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(css = "div#header span[aria-label='AddIcon']")
    WebElement btnAdd;
    public HomePage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public TopMenu clickAdd() {
        this.waitElement(btnAdd);
        btnAdd.click();
        return new TopMenu(getWebDriver(), getWebDriverWait());
    }
}
