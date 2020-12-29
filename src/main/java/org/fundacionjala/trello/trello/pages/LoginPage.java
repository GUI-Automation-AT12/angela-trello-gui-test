package org.fundacionjala.trello.trello.pages;
import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "user")
    private WebElement user;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "login")
    private WebElement btnLogin;

    /**
     * Sets username.
     * @param strUser
     */
    public void setUserName(final String strUser) {
        WebElementsHelper.sendKeys(user, strUser);
    }

    /**
     * Sets password.
     * @param strPassword
     */
    public void setPassword(final String strPassword) {
        WebElementsHelper.sendKeys(password, strPassword);
    }

    /**
     * Clicks login button.
     */
    public void clickLogin() {
        WebElementsHelper.clickElement(btnLogin);
    }

    /**
     * This POM method will be exposed in test case to login in the application.
     * @param strUser
     * @param strPassword
     * @return HomePage
     */
    public HomePage login(final String strUser, final String strPassword) {
        this.setUserName(strUser);
        this.setPassword(strPassword);
        this.clickLogin();
        return new HomePage();
    }
}
