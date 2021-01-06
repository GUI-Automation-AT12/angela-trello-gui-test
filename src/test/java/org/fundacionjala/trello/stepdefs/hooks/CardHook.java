package org.fundacionjala.trello.stepdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.trello.core.client.RequestManager;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.config.EnvironmentApi;
import org.fundacionjala.trello.trello.utils.Authentication;
import org.json.JSONObject;

public class CardHook {
    private Context context;

    /**
     * Initializes an instance of Context class.
     * @param contextToSet
     */
    public CardHook(final Context contextToSet) {
        this.context = contextToSet;
    }

    /**
     * Creates card before execute the step with the createCard tag.
     */
    @Before(value = "@CreateCard", order = 2)
    public void createCard() {
        String endpoint = EnvironmentApi.getInstance().getBaseUrlApi() + "/cards/";
        JSONObject json = new JSONObject();
        json.put("name", "testCard");
        json.put("idList", context.getDataCollection("list").get("id"));
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        Response response = RequestManager.post(endpoint, json.toString());
        context.saveDataCollection("card", response.jsonPath().getMap(""));
    }

    /**
     * Delete the card after execute Stepdefs with the deleteCard tag.
     */
    @After(value = "@DeleteCard", order = 0)
    public void deleteCard() {
        String cardId = context.getDataCollection(("card")).get("id");
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        String endpoint = EnvironmentApi.getInstance().getBaseUrlApi().concat("/cards/").concat(cardId);
        RequestManager.delete(endpoint);
    }
}

