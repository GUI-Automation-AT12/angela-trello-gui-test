package org.fundacionjala.trello.trello.pages;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.entities.User;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class ProfilePage extends BasePage {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(css = "div[data-test-id='profile-tab-container'] textarea")
    private WebElement bio;

    @FindBy(css = "div[data-test-id='profile-tab-container'] button")
    private WebElement btnSave;

    @FindBy(id = "layer-manager-alert")
    private WebElement messageUpdated;

    @FindBy(css = "div.tabbed-pane-header span:nth-child(2)")
    private WebElement usernameInTopContent;

    /**
     * Gets success message of updated profile.
     * @return if the message is displayed or not
     */
    public boolean isUpdatedProfileMessageDisplayed() {
        //get message updated user
        if (WebElementsHelper.waitElement(messageUpdated).isDisplayed()) {
            return true;
        }
        return false;
    }

    /**
     * Sets username.
     * @param strUser
     */
    public void setUsername(final String strUser) {
        WebElementsHelper.sendKeys(username, strUser);
    }

    /**
     * Sets bio.
     * @param strBio
     */
    public void setBio(final String strBio) {
        WebElementsHelper.sendKeys(bio, strBio);
    }

    /**
     * Clicks on button save.
     */
    public void clickSave() {
        WebElementsHelper.clickElement(btnSave);
    }

    /**
     * Returns username.
     * @return username
     */
    public String getUsername() {
        return WebElementsHelper.getAttributeValueFromElement(username, "value");
    }

    /**
     * Returns bio.
     * @return bio
     */
    public String getBio() {
        return WebElementsHelper.getTextFromElement(bio);
    }

    /**
     * Composes strategy map.
     * @param user
     * @return HashMap
     */
    public HashMap<String, Runnable> composeStrategySetterMap(final User user) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("username", () -> setUsername(user.getUsername()));
        strategyMap.put("bio", () -> setBio(user.getBio()));
        return strategyMap;
    }

    /**
     * Fills profile's field with user information.
     * @param user
     */
    public void setUserInformationToUpdate(final User user) {
        HashMap<String, Runnable> strategyMap = composeStrategySetterMap(user);
        user.getUpdatedFields().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * Update user's profile.
     * @param user
     * @return
     */
    public void updateProfile(final User user) {
        this.setUserInformationToUpdate(user);
        this.clickSave();
    }

    /**
     * Gets user's information as a map.
     * @param fields
     * @return Map with user's information
     */
    public Map<String, String> getUserInformationAsMap(final Set<String> fields) {
        Map userInfoMap = new HashMap();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetterMap();
        fields.forEach(field -> userInfoMap.put(field, strategyMap.get(field).get()));
        return userInfoMap;
    }

    /**
     * Composes strategy getter map.
     * @return HashMap
     */
    private HashMap<String, Supplier<String>> composeStrategyGetterMap() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("username", () -> getUsername());
        strategyMap.put("bio", () -> getBio());
        return strategyMap;
    }

    /**
     * Gets username from top content.
     * @return username
     */
    public String getUsernameFromTopContent() {
        return WebElementsHelper.getTextFromElement(usernameInTopContent);
    }
}
