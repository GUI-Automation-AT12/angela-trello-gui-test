package org.fundacionjala.trello.trello.pages.popup;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.entities.Board;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.fundacionjala.trello.trello.pages.BoardPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class CreateBoardPopup extends BasePage {
    private static final String PRIVATE = "private";
    private static final String TEAM = "team";

    @FindBy(css = "div#layer-manager-overlay span[class*='ifeHxY']")
    private WebElement popupAtlasian; //wait

    @FindBy(css = "input[data-test-id='create-board-title-input']")
    private WebElement inputBoardName; //wait

    @FindBy(xpath = "//input[@data-test-id='create-board-title-input']/following-sibling::button[1]")
    private WebElement dropdownSelectTeam; //team

    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    private WebElement submit;

    @FindBy(xpath = "//input[@data-test-id='create-board-title-input']/following-sibling::button[2]")
    private WebElement selectPrivacy; //select to select privacy

    @FindBy(css = "ul span[name='private']")
    private WebElement privatePrivacy;

    @FindBy(css = "ul span[name='organization']")
    private WebElement teamPrivacy;

    @FindBy(css = "ul span[name='public']")
    private WebElement publicPrivacy;

    @FindBy(css = "button._21upOlzpUQJcdT:nth-child(2)")
    private WebElement confirmPublicPrivacy;

    private String team = "//button//span[contains(text(),'%s')]";

    /**
     * Closes popup Atlassian.
     */
    public void closePopupAtlasian() {
        WebElementsHelper.clickElement(popupAtlasian);
    }

    /**
     * Sets name of board.
     * @param boardName
     */
    private void setBoardName(final String boardName) {
        WebElementsHelper.sendKeys(inputBoardName, boardName);
    }

    /**
     * Clisk submit button.
     */
    private void clickSubmit() {
        WebElementsHelper.clickElement(submit);
    }

    private void selectTeam(final String teamName) {
        WebElementsHelper.clickElement(dropdownSelectTeam);
        By dropDownOption = By.xpath(String.format(team, teamName));
        WebElementsHelper.clickElement(dropDownOption);
    }

    /**
     * Set a team to board.
     * @param teamToSelect for the board
     */
    private void setTeam(final String teamToSelect) {
        selectTeam(teamToSelect);
    }

    /**
     * Set the privacy of board.
     * @param privacy od the board
     */
    private void setPrivatePrivacy(final String privacy) {
        if (!privacy.equals(TEAM)) {
            WebElementsHelper.clickElement(selectPrivacy);
            if (privacy.equals(PRIVATE)) {
                WebElementsHelper.clickElement(privatePrivacy);
            } else {
                WebElementsHelper.clickElement(publicPrivacy);
                WebElementsHelper.clickElement(confirmPublicPrivacy);
            }
        }
    }

    /**
     * Composes strategy map.
     * @param board
     * @return HashMap
     */
    public HashMap<String, Runnable> composeStrategyMap(final Board board) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setBoardName((board.getName())));
        strategyMap.put("team", () -> setTeam((board.getTeam())));
        strategyMap.put("privacy", () -> setPrivatePrivacy((board.getPrivacy())));
        return strategyMap;
    }

    /**
     * Fills board's fields.
     * @param board
     */
    public void setBoardInformation(final Board board) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(board);
        board.getFields().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * This POM method will be exposed in test case to login in the application.
     * @param board
     * @return BoardPage
     */
    public BoardPage createBoard(final Board board) {
        WebElementsHelper.waitElement(inputBoardName);
        setBoardInformation(board);
        this.clickSubmit();
        return new BoardPage();
    }
}
