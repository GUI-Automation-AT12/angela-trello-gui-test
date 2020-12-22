package org.fundacionjala.trello.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverManager {
    private static WebDriverManager webDriverManager;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public WebDriverManager() {
        System.setProperty("webdriver.chrome.driver", "webdriver/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        //webDriver.manage().timeouts().implicitlyWait(30,40);
        webDriverWait = new WebDriverWait(webDriver, 30);
    }
    public static WebDriverManager getInstance() {
        if (webDriverManager == null) {
            webDriverManager = new WebDriverManager();
        }
        return webDriverManager;
    }
    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return webDriverWait;
    }

    public void quite() {
        webDriverManager = null;
        webDriver.quit();
    }
}
