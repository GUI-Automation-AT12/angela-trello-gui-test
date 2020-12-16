package Trello.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InitialPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(partialLinkText = "Iniciar")
    WebElement btnInitSession;

    public InitialPage(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickInitSession() {
        btnInitSession.click();
        return new LoginPage(driver, wait);
    }
}
