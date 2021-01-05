package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginAtlassianPage extends BasePage {
    @FindBy(css = "div.email-password input[name='user']")
    private WebElement user;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login")
    private WebElement btnLogin;

    @FindBy(id = "login-submit")
    private WebElement btnLoginAtlassian;

    /**
     * Sets username.
     * @param strUser
     */
    private void setUserName(final String strUser) {
        WebElementsHelper.sendKeys(user, strUser);
    }

    /**
     * Sets password.
     * @param strPassword
     */
    private void setPassword(final String strPassword) {
        WebElementsHelper.sendKeys(password, strPassword);
    }

    /**
     * Clicks login button.
     */
    private void clickLogin() {
        WebElementsHelper.clickElement(btnLogin);
    }

    /**
     * Clicks login Atlassian button.
     */
    private void clickLoginAtlassian() {
        WebElementsHelper.clickElement(btnLoginAtlassian);
    }

    /**
     * This POM method will be exposed in test case to login in the application.
     * @param strUser
     * @param strPassword
     * @return HomePage
     */
    public HomePage login(final String strUser, final String strPassword) {
        this.setUserName(strUser);
        this.clickLogin();
        WebElementsHelper.waitElement(btnLoginAtlassian);
        this.setPassword(strPassword);
        this.clickLoginAtlassian();
        HomePage homePage = new HomePage();
        WebElementsHelper.waitElement(homePage.getTopMenu().getAddButton());
        return new HomePage();
    }
}
