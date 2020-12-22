package org.fundacionjala.trello.unit;

import org.fundacionjala.trello.trello.config.Environment;
import org.fundacionjala.trello.core.WebDriverManager;
import org.fundacionjala.trello.trello.pages.*;
import org.fundacionjala.trello.trello.pages.popup.CreateBoardPopup;
import org.fundacionjala.trello.trello.pages.topmenu.TopMenu;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static org.testng.Assert.assertEquals;

public class BoardTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private WebDriverWait wait;

    @BeforeTest
    public void setUp() {
        driver = WebDriverManager.getInstance().getWebDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        wait = WebDriverManager.getInstance().getWebDriverWait();
        driver.get(Environment.getInstance().getBaseUrl());
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void createBoard() {
        String  expectedResult = "testBoard7";
        InitialPage initialPage = new InitialPage(driver, wait);
        LoginAtlassianPage loginAtlassianPage = initialPage.clickInitSessionAtlassian();
        loginAtlassianPage.login(Environment.getInstance().getEmail(), Environment.getInstance().getPassword());
        HomePage homePage = new HomePage(driver, wait);
        TopMenu topMenu = homePage.clickAdd();
        CreateBoardPopup board = topMenu.clickAddBoard();
        board.createBoard(expectedResult);
        String  actualResult = board.getNameBoard();
        assertEquals(expectedResult, actualResult);
    }
}
