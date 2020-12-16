package Trello;

import Trello.config.Environment;
import Trello.pageobjects.InitialPage;
import Trello.pageobjects.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class LoginTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        wait = new WebDriverWait(driver, 30);
        driver.get("https://trello.com/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginWithValidCredentials() {
        InitialPage initialPage = new InitialPage(driver, wait);
        LoginPage loginPage = initialPage.clickInitSession();
        loginPage.login(Environment.getInstance().getUser(), Environment.getInstance().getPassword());
    }
}
