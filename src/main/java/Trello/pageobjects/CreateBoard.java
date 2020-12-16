package Trello.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateBoard {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "div#layer-manager-overlay span[class*='ifeHxY']")
    WebElement popupAtlasian; //wait
    @FindBy(css = "div#header span[aria-label='AddIcon']")
    WebElement btnAdd;
    @FindBy(css = "button[data-test-id='header-create-board-button']")
    WebElement btnAddBoard;
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

    public CreateBoard(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void closePopupAtlasian(){
        WebElement popup = waitElement(popupAtlasian);
        popup.click();
    }

    public void clickAdd(){
        btnAdd.click();
    }

    public void clickAddBoard(){
        btnAddBoard.click();
    }

    public void insertNameBoard(String nameBoard){
        inputBoardName.sendKeys(nameBoard);
    }
    public void clickSelectTeam(){
        selectTeam.click();
    }
    public void clickSListTeam(){
        listTeams.click();
    }
    public void clickSubmit(){
        submit.click();
    }
    public WebElement waitElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getNameBoard() {
        return nameBoardCreated.getText();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param nameBoard
     * @return
     */
    public void createBoard(String nameBoard){
        this.waitElement(popupAtlasian);
        this.closePopupAtlasian();
        this.clickAdd();
        this.clickAddBoard();
        this.waitElement(inputBoardName);
        this.insertNameBoard(nameBoard);
        this.clickSelectTeam();
        this.clickSListTeam();
        this.clickSubmit();
        this.waitElement(nameBoardCreated);
    }
}
