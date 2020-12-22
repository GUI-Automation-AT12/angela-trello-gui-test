package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    @FindBy(name = "username")
    WebElement username;
    @FindBy(css = "div[data-test-id='profile-tab-container'] textarea")
    WebElement bio;
    @FindBy(css = "div[data-test-id='profile-tab-container'] button")
    WebElement btnSave;

    public ProfilePage(final WebDriver webDriver, final WebDriverWait webDriverWait) {
        super(webDriver, webDriverWait);
    }

    public void setUsername(String strUser){
        WebElementsHelper.sendKeys(username, strUser);
    }

    public void setBio(String strBio) {
        WebElementsHelper.sendKeys(bio, strBio);
    }

    public void clickSave(){
        WebElementsHelper.clickElement(btnSave);
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param username
     * @param bio
     * @return
     */
    public void updateProfile(String username,String bio) {
        this.setUsername(username);
        this.setBio(bio);
        this.clickSave();
    }
}
