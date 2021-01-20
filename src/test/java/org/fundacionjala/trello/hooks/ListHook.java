package org.fundacionjala.trello.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.trello.core.client.RequestManager;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.config.EnvironmentApi;
import org.fundacionjala.trello.trello.api.Authentication;
import org.json.JSONObject;

public class ListHook {
    private Context context;

    /**
     * Initializes an instance of Context class.
     * @param sharedContext
     */
    public ListHook(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Creates list before execute the step with the createList tag.
     */
    @Before(value = "@CreateList", order = 1)
    public void createList() {
        String endpoint = EnvironmentApi.getInstance().getBaseUrlApi() + "/lists/";
        JSONObject json = new JSONObject();
        json.put("name", "testList");
        json.put("idBoard", context.getDataCollection("board").get("id"));
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        Response response = RequestManager.post(endpoint, json.toString());
        context.saveDataCollection("list", response.jsonPath().getMap(""));
    }

    /**
     * Delete the list after execute Stepdefs with the deleteList tag.
     */
    @After(value = "@DeleteList", order = 1)
    public void deleteList() {
        String listId = context.getDataCollection("list").get("id");
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        String endpoint = EnvironmentApi.getInstance().getBaseUrlApi().concat("/lists/").concat(listId);
        RequestManager.delete(endpoint);
    }
}

