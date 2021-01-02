package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.entities.Board;
import org.fundacionjala.trello.trello.pages.BoardPage;
import org.fundacionjala.trello.trello.pages.popup.AddComponentPopup;
import org.fundacionjala.trello.trello.pages.popup.CreateBoardPopup;
import org.fundacionjala.trello.trello.pages.topmenu.TopMenu;
import org.testng.Assert;
import java.util.Map;

public class BoardStepDef {
    private Context context;
    private TopMenu topMenu = new TopMenu();
    private AddComponentPopup addComponentPopup;
    private CreateBoardPopup createBoard;
    private Board board;
    private BoardPage boardPage;

    /**
     * Constructor.
     * @param sharedContext
     */
    public BoardStepDef(final Context sharedContext) {
        this.context = sharedContext;
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
    @Then("the board should be created")
    public void verifyBoardIsCreated() {
        String actualName = boardPage.getNameBoardCreated();
        String expectedName = board.getName();
        context.saveData("board", WebDriverManager.getInstance().getWebDriver().getCurrentUrl());
        Assert.assertEquals(actualName, expectedName);
    }
}
