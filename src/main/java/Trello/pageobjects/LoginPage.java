package Trello.pageobjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "user")
    WebElement user;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "login")
    WebElement btnLogin;

    public LoginPage(final WebDriver driver, final WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void setUserName(String strUser){
        user.sendKeys(strUser);
    }

    public void setPassword(String strPassword){
        password.sendKeys(strPassword);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    /**
     * This POM method will be exposed in test case to login in the application
     * @param strUser
     * @param strPassword
     * @return
     */
    public HomePage login(String strUser,String strPassword){
        this.setUserName(strUser);
        this.setPassword(strPassword);
        this.clickLogin();
        return new HomePage(driver, wait);
    }
}
