package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.entities.Board;
import org.fundacionjala.trello.trello.pages.BoardPage;
import org.fundacionjala.trello.trello.pages.DeletedBoardPage;
import org.fundacionjala.trello.trello.pages.TransporterPage;
import org.fundacionjala.trello.trello.pages.popup.AddComponentPopup;
import org.fundacionjala.trello.trello.pages.popup.BoardMenuPopup;
import org.fundacionjala.trello.trello.pages.popup.CreateBoardPopup;
import org.fundacionjala.trello.trello.pages.topmenu.TopMenu;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.util.Map;

public class BoardStepDef {
    private Context context;
    private TopMenu topMenu;
    private AddComponentPopup addComponentPopup;
    private CreateBoardPopup createBoard;
    private Board board;
    private BoardPage boardPage;
    private BoardMenuPopup boardPopup;
    private DeletedBoardPage deletedBoardPage;

    /**
     * Constructor.
     * @param sharedContext
     */
    public BoardStepDef(final Context sharedContext) {
        this.context = sharedContext;
        topMenu = new TopMenu();
        board = new Board();
    }

    /**
     * Create a new board.
     * @param boardInformation
     */
    @And("I create a board with the following form data")
    public void createBoardWithTheFollowingFormData(final Map<String, String> boardInformation) {
        addComponentPopup = topMenu.clickAddButton();
        createBoard = addComponentPopup.clickAddBoardBtn();
        board.processInformation(boardInformation);
        boardPage = createBoard.createBoard(board);
    }

    /**
     * Verify new board is created.
     */
    @Then("the board name should be displayed")
    public void verifyBoardNameIsDisplayed() {
        String actualName = boardPage.getBoardName();
        String expectedName = board.getName();
        context.saveData("board", WebDriverManager.getInstance().getWebDriver().getCurrentUrl());
        Assert.assertEquals(actualName, expectedName);
    }

    /**
     * Navigate to board page.
     * @throws MalformedURLException
     */
    @When("I navigate to specific board page")
    public void navigateToBoardPage() throws MalformedURLException {
        TransporterPage.navigateToSpecificUrl(context.getDataCollection("board").get("url"));
    }

    /**
     * Delete a board.
     */
    @And("I delete the board")
    public void deleteTheBoard() {
        boardPopup = new BoardMenuPopup();
        deletedBoardPage = boardPopup.closePermanentlyBoard();
    }

    /**
     * Verify if message of deleted board is displayed.
     */
    @Then("a message should be displayed")
    public void verifyMessageIsDisplayed() {
        String actualMessage = deletedBoardPage.getBoardNotFoundMessage();
        String expectedMessage = context.getDataCollection("board").get("name").concat(" is closed.");
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
