package org.fundacionjala.trello.unit;

import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.core.utils.user.UserReader;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.trello.pages.BoardPage;
import org.fundacionjala.trello.trello.pages.HomePage;
import org.fundacionjala.trello.trello.pages.InitialPage;
import org.fundacionjala.trello.trello.pages.LoginAtlassianPage;
import org.fundacionjala.trello.trello.pages.TransporterPage;
import org.fundacionjala.trello.trello.pages.popup.CreateBoardPopup;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
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
    public void createBoard() throws IOException, ParseException {
        String  expectedResult = "testBoard7";
        TransporterPage.navigateToPage();
        InitialPage initialPage = new InitialPage();
        LoginAtlassianPage loginAtlassianPage = initialPage.clickInitSessionAtlassian();
        loginAtlassianPage.login(UserReader.getEmail("Editable"), UserReader.getPassword("Editable"));
        HomePage homePage = new HomePage();
        CreateBoardPopup board = homePage.getTopMenu().clickAddButton().clickAddBoardBtn();
        BoardPage boardPage = board.createBoard(expectedResult);
        String  actualResult = boardPage.getBoardName();
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
        WebDriverManager.getInstance().quit();
    }
}
