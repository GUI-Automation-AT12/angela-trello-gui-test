package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAtlassianPage extends BasePage {
    //@FindBy(id = "user")
    @FindBy(css = "div.email-password input[name='user']")
    WebElement user;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login")
    WebElement btnLogin;
    @FindBy(id = "login-submit")
    WebElement btnLoginAtlassian;


    public LoginAtlassianPage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    private void setUserName(String strUser){
        WebElementsHelper.sendKeys(user, strUser);
    }

    private void setPassword(String strPassword) {
        WebElementsHelper.sendKeys(password, strPassword);
    }

    private void clickLogin(){
        WebElementsHelper.clickElement(btnLogin);
    }

    private void clickLoginAtlassian() {
        WebElementsHelper.clickElement(btnLoginAtlassian);
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUser
     * @param strPassword
     * @return
     */
    public HomePage login(String strUser,String strPassword) {
        this.setUserName(strUser);
        this.clickLogin();
        this.waitElement(btnLoginAtlassian);
        this.setPassword(strPassword);
        this.clickLoginAtlassian();
        return new HomePage(getWebDriver(), getWebDriverWait());
    }
}
