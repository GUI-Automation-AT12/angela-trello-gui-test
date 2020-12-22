package org.fundacionjala.trello.trello.pages;
import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "user")
    WebElement user;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login")
    WebElement btnLogin;

    public LoginPage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public void setUserName(String strUser){
        WebElementsHelper.sendKeys(user, strUser);
    }

    public void setPassword(String strPassword) {
        WebElementsHelper.sendKeys(password, strPassword);
    }

    public void clickLogin(){
        WebElementsHelper.clickElement(btnLogin);
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUser
     * @param strPassword
     * @return
     */
    public HomePage login(String strUser,String strPassword) {
        this.setUserName(strUser);
        this.setPassword(strPassword);
        this.clickLogin();
        return new HomePage(getWebDriver(), getWebDriverWait());
    }
}
