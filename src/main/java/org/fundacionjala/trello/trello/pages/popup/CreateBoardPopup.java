package org.fundacionjala.trello.trello.pages.popup;

import org.fundacionjala.trello.core.utils.WebElementsHelper;
import org.fundacionjala.trello.trello.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateBoardPopup extends BasePage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;

    @FindBy(css = "div#layer-manager-overlay span[class*='ifeHxY']")
    WebElement popupAtlasian; //wait
    @FindBy(css = "input[data-test-id='create-board-title-input']")
    WebElement inputBoardName; //wait
    @FindBy(css = ".\\_1se-PM9Q1YyEtg > .sc-bdVaJa")
    WebElement selectTeam; //team
    @FindBy(css = "li:nth-child(1) > .\\_2FCfpANq784raH")
    WebElement listTeams; //listTeams
    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    WebElement submit; //listTeams
    @FindBy(css = ".board-header-btn-text")
    WebElement nameBoardCreated;

    public CreateBoardPopup(final WebDriver webDriver, final WebDriverWait webDriverWait) {
       super(webDriver, webDriverWait);
    }

    public void closePopupAtlasian() {
        WebElement popup = waitElement(popupAtlasian);
        popup.click();
    }

    public void insertNameBoard(final String nameBoard){
        WebElementsHelper.sendKeys(inputBoardName,nameBoard);
    }
    public void clickSelectTeam(){
        WebElementsHelper.clickElement(selectTeam);
    }
    public void clickSListTeam(){
        WebElementsHelper.clickElement(listTeams);
    }
    public void clickSubmit(){
        WebElementsHelper.clickElement(submit);
    }

    public String getNameBoard() {
        return nameBoardCreated.getText();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param nameBoard
     * @return
     */
    public void createBoard(String nameBoard) {
        //this.waitElement(popupAtlasian);
        //this.closePopupAtlasian();
        this.waitElement(inputBoardName);
        this.insertNameBoard(nameBoard);
        this.clickSelectTeam();
        this.clickSListTeam();
        this.clickSubmit();
        this.waitElement(nameBoardCreated);
    }
}
