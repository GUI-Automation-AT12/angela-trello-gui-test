package org.fundacionjala.trello.trello.pages.popup;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.entities.Team;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class CreateTeamPopup extends BasePage {
    @FindBy(css = "input[data-test-id='header-create-team-name-input']")
    private WebElement inputTeamName;

    @FindBy(css = "div[data-test-id='header-create-team-type-input']")
    private WebElement dropdownSelectType;

    @FindBy(css = "textarea[id*='create-team-org-description']")
    private WebElement teamDescription;

    @FindBy(css = "button[data-test-id='header-create-team-submit-button']")
    private WebElement submitBtn;

    private void selectType(final String newType) {
        WebElementsHelper.clickElement(dropdownSelectType);
        By dropDownOption = By.xpath("//*[contains(text(),'" + newType + "')]");
        WebElementsHelper.clickElement(dropDownOption);
    }

    /**
     * Set name.
     * @param newName
     */
    private void setName(final String newName) {
        WebElementsHelper.sendKeys(inputTeamName, newName);
    }

    /**
     * Set description.
     * @param desc
     */
    private void setDescription(final String desc) {
        WebElementsHelper.sendKeys(teamDescription, desc);
    }

    /**
     * Create team.
     * @param team
     * @return new MembersPopup
     */
    public MembersPopup createTeam(final Team team) {
        setTeamInformation(team);
        WebElementsHelper.clickElement(submitBtn);
        return new MembersPopup();
    }

    /**
     * Composes strategy map.
     * @param team
     * @return HashMap
     */
    public HashMap<String, Runnable> composeStrategyMap(final Team team) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setName((team.getName())));
        strategyMap.put("type", () -> selectType((team.getType())));
        strategyMap.put("description", () -> setDescription((team.getDescription())));
        return strategyMap;
    }

    /**
     * Fills board's fields.
     * @param team
     */
    public void setTeamInformation(final Team team) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(team);
        team.getUpdatedFields().forEach(key -> strategyMap.get(key).run());
    }
}
