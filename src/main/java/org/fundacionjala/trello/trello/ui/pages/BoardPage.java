package org.fundacionjala.trello.trello.ui.pages;

import org.fundacionjala.trello.core.selenium.WebDriverManager;
import org.fundacionjala.trello.core.selenium.WebElementsHelper;
import org.fundacionjala.trello.trello.entities.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BoardPage extends BasePage {
    @FindBy(css = "div.board-canvas")
    private WebElement boardLists;

    @FindBy(css = "h1.board-header-btn-text")
    private WebElement boardName;

    @FindBy(css = "textarea.list-card-composer-textarea")
    private WebElement cardNameTextarea;

    @FindBy(css = "input[value='Add Card']")
    private WebElement addCardBtn;

    private String listLocator = "//textarea[contains(text(),'%s')]";
    private String cardLocator = "//span[contains(text(),'%s')]";
    private String cardOnListLocator = "%s//parent::div//parent::div%s";
    private String addCardBtnLocator =
            "//textarea[contains(text(),'%s')]//parent::div//parent::div//span[@class='js-add-a-card']";

    /**
     * Gets name of board.
     * @return name of board created
     */
    public String getBoardName() {
        WebElementsHelper.waitElement(boardLists);
        return WebElementsHelper.getTextFromElement(boardName);
    }

    /**
     * Drag and drop a card.
     * @param targetList target list
     * @param cardName name of the card
     */
    public void dragAndDropCard(final String targetList, final String cardName) {
        By byFrom = By.xpath(String.format(cardLocator, cardName));
        By byTo = By.xpath(String.format(listLocator, targetList));
        WebElementsHelper.dragAndDropByElement(byFrom, byTo);
    }

    /**
     * Verify if the card is on list.
     * @param list
     * @param cardName
     * @return a boolean
     */
    public boolean isCardOnList(final String list, final String cardName) {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        if (webDriver.findElements(By.xpath(String.format(cardOnListLocator, String.format(listLocator, list),
                String.format(cardLocator, cardName)))).size() != 0) {
            return true;
        }
        return false;
    }

    private void clickAddCardBtn(final String listName) {
        By by = By.xpath(String.format(addCardBtnLocator, listName));
        WebElementsHelper.clickElement(by);
    }

    /**
     * Create a card.
     * @param card
     * @param list
     */
    public void createCard(final Card card, final String list) {
        clickAddCardBtn(list);
        WebElementsHelper.clickElement(cardNameTextarea);
        WebElementsHelper.sendKeys(cardNameTextarea, card.getName());
        WebElementsHelper.clickElement(addCardBtn);
    }
}
