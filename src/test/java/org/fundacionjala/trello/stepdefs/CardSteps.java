package org.fundacionjala.trello.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.checkerframework.checker.units.qual.C;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.entities.Card;
import org.fundacionjala.trello.trello.entities.Team;
import org.fundacionjala.trello.trello.pages.BoardPage;
import org.fundacionjala.trello.trello.pages.TeamPage;
import org.fundacionjala.trello.trello.pages.menu.TopMenu;
import org.fundacionjala.trello.trello.pages.popup.AddComponentPopup;
import org.fundacionjala.trello.trello.pages.popup.CreateTeamPopup;
import org.fundacionjala.trello.trello.pages.popup.MembersPopup;
import org.junit.Assert;

import java.util.Map;

public class CardSteps {
    private Context context;
    private BoardPage boardPage;
    private String cardName;
    private Card card;

    /**
     * Constructor.
     * @param sharedContext
     */
    public CardSteps(final Context sharedContext) {
        context = sharedContext;
        boardPage = new BoardPage();
        cardName = context.getDataCollection("card").get("name");
        card = new Card();
    }

    /**
     * Drag and drop a card to a target list.
     * @param target list
     */
    @And("I drag and drop a card between {word} lists")
    public void dragAndDropACardBetweenTwoLists(final String target) {
        boardPage.dragAndDropCard(target, cardName);
    }

    /**
     * Verify card is displayed on target list.
     */
    @Then("the card should be displayed on {word} list")
    public void verifyCardIsDisplayedOnList(final String target) {
        Assert.assertTrue(boardPage.isCardOnList(target, cardName));
    }

    /**
     * Verify card is not displayed on origin list.
     */
    @And("the card shouldn't be displayed on origin list")
    public void verifyCardIsNotDisplayedOnOriginList() {
        String originList = context.getDataCollection("list").get("name");
        Assert.assertFalse(boardPage.isCardOnList(originList, cardName));
    }

    @And("I create a card with the following form data")
    public void createACardWithTheFollowingFormData(final Map<String, String> cardInformation) {
        card.processInformation(cardInformation);
        boardPage.createCard(card, context.getDataCollection("list").get("name"));
    }

    @Then("the card should be created on list")
    public void theCardShouldBeCreatedOnList() {
        String list = context.getDataCollection("list").get("name");
        Assert.assertTrue(boardPage.isCardOnList(list, card.getName()));
    }
}
