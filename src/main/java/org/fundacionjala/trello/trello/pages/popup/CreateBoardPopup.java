package org.fundacionjala.trello.trello.pages.popup;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.entities.Board;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.fundacionjala.trello.trello.pages.BoardPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

public class CreateBoardPopup extends BasePage {
    @FindBy(css = "div#layer-manager-overlay span[class*='ifeHxY']")
    private WebElement popupAtlasian; //wait
    @FindBy(css = "input[data-test-id='create-board-title-input']")
    private WebElement inputBoardName; //wait
    @FindBy(xpath = "//input[@data-test-id='create-board-title-input']/following-sibling::button[1]")
    private WebElement selectTeam; //team
    @FindBy(css = "section.js-react-root li:first-child")
    private WebElement listTeams; //listTeams
    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    private WebElement submit; //listTeams
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


    /**
     * Closes popup Atlassian.
     */
    public void closePopupAtlasian() {
        WebElement popup = waitElement(popupAtlasian);
        popup.click();
    }

    /**
     * Sets name of board.
     * @param nameBoard
     */
    private void setNameBoard(final String nameBoard) {
        WebElementsHelper.sendKeys(inputBoardName, nameBoard);
    }

    /**
     * Clicks select team.
     */
    private void clickSelectTeam() {
        WebElementsHelper.clickElement(selectTeam);
    }

    /**
     * Clicks list team.
     */
    private void clickSListTeam() {
        WebElementsHelper.clickElement(listTeams); //first team
    }

    /**
     * Clisk submit button.
     */
    private void clickSubmit() {
        WebElementsHelper.clickElement(submit);
    }

    private void selectTeam(final String team) {
        WebElementsHelper.clickElement(selectTeam);
        this.clickSListTeam(); //select the first team
    }

    /**
     * Set a team to board.
     * @param team
     */
    private void setTeam(final String team) {
        selectTeam(team);
    }

    /**
     * Set the privacy of board.
     * @param privacy
     */
    private void setPrivatePrivacy(final String privacy) {
        if (!privacy.equals("team")) {
            WebElementsHelper.clickElement(selectPrivacy);
            if (privacy.equals("private")) {
                WebElementsHelper.clickElement(privatePrivacy);
            } else {
                WebElementsHelper.clickElement(publicPrivacy);
                waitElement(confirmPublicPrivacy);
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
        strategyMap.put("name", () -> setNameBoard((board.getName())));
        strategyMap.put("team", () -> setTeam((board.getTeam())));
        strategyMap.put("privacy", () -> setPrivatePrivacy((board.getPrivacy())));
        return strategyMap;
    }

    /**
     * Fills board's fields.
     * @param board
     */
    public void setUserInformationToUpdate(final Board board) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(board);
        board.getFields().forEach(key -> strategyMap.get(key).run());
    }

    /**
     * This POM method will be exposed in test case to login in the application.
     * @param board
     * @return BoardPage
     */
    public BoardPage createBoard(final Board board) {
        this.waitElement(inputBoardName);
        setUserInformationToUpdate(board);
        this.clickSubmit();
        return new BoardPage();
    }

    /**
     * This POM method will be exposed in test case to login in the application.
     * @param nameBoard
     * @return BoardPage
     */
    public BoardPage createBoard(final String nameBoard) {
        this.waitElement(inputBoardName);
        this.setNameBoard(nameBoard);
        this.clickSelectTeam();
        this.clickSListTeam();
        this.clickSubmit();
        return new BoardPage();
    }
}
