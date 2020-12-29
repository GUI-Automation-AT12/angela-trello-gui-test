package org.fundacionjala.trello.trello.pages.popup;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateBoardPopup extends BasePage {
    @FindBy(css = "div#layer-manager-overlay span[class*='ifeHxY']")
    private WebElement popupAtlasian; //wait
    @FindBy(css = "input[data-test-id='create-board-title-input']")
    private WebElement inputBoardName; //wait
    @FindBy(css = ".\\_1se-PM9Q1YyEtg > .sc-bdVaJa")
    private WebElement selectTeam; //team
    @FindBy(css = "li:nth-child(1) > .\\_2FCfpANq784raH")
    private WebElement listTeams; //listTeams
    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    private WebElement submit; //listTeams
    @FindBy(css = ".board-header-btn-text")
    private WebElement nameBoardCreated;

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
    public void setNameBoard(final String nameBoard) {
        WebElementsHelper.sendKeys(inputBoardName, nameBoard);
    }

    /**
     * Clicks select team.
     */
    public void clickSelectTeam() {
        WebElementsHelper.clickElement(selectTeam);
    }

    /**
     * Clicks list team.
     */
    public void clickSListTeam() {
        WebElementsHelper.clickElement(listTeams);
    }

    /**
     * Clisk submit button.
     */
    public void clickSubmit() {
        WebElementsHelper.clickElement(submit);
    }

    /**
     * Gets name of board.
     * @return name of board
     */
    public String getNameBoard() {
        return nameBoardCreated.getText();
    }

    /**
     * This POM method will be exposed in test case to login in the application.
     * @param nameBoard
     * @return
     */
    public void createBoard(final String nameBoard) {
        //this.waitElement(popupAtlasian);
        //this.closePopupAtlasian();
        this.waitElement(inputBoardName);
        this.setNameBoard(nameBoard);
        this.clickSelectTeam();
        this.clickSListTeam();
        this.clickSubmit();
        this.waitElement(nameBoardCreated);
    }
}
