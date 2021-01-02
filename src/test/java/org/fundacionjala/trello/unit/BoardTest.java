package org.fundacionjala.trello.unit;

import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.config.Environment;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.trello.pages.BoardPage;
import org.fundacionjala.trello.trello.pages.HomePage;
import org.fundacionjala.trello.trello.pages.InitialPage;
import org.fundacionjala.trello.trello.pages.LoginAtlassianPage;
import org.fundacionjala.trello.trello.pages.TransporterPage;
import org.fundacionjala.trello.trello.pages.popup.CreateBoardPopup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class BoardTest {
    private Context context;

    /**
     * Constructor.
     */
    public BoardTest() {
        context = new Context();
    }

    /**
     * Create a new board.
     */
    @Test
    public void createBoard() {
        String  expectedResult = "testBoard7";
        TransporterPage.navigateToPage();
        InitialPage initialPage = new InitialPage();
        LoginAtlassianPage loginAtlassianPage = initialPage.clickInitSessionAtlassian();
        loginAtlassianPage.login(Environment.getInstance().getEmail(), Environment.getInstance().getPassword());
        HomePage homePage = new HomePage();
        CreateBoardPopup board = homePage.getTopMenu().clickAddButton().clickAddBoardBtn();
        BoardPage boardPage = board.createBoard(expectedResult);
        String  actualResult = boardPage.getNameBoardCreated();
        context.saveData("board", WebDriverManager.getInstance().getWebDriver().getCurrentUrl());
        assertEquals(expectedResult, actualResult);
    }

    /**
     * Quite WebDriver.
     */
    @AfterMethod
    public void tearDown() {
        BoardConditions boardConditions = new BoardConditions(context);
        boardConditions.deleteBoard();
        WebDriverManager.getInstance().quite();
    }
}
