package org.fundacionjala.trello.hooks;

import org.fundacionjala.trello.core.client.RequestManager;
import org.fundacionjala.trello.core.context.ContextAPI;
import org.fundacionjala.trello.trello.config.Environment;
import org.fundacionjala.trello.trello.utils.Authentication;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class BoardHook {

    private ContextAPI contextAPI;

    /**
     * Initializes an instance of Context class.
     * @param contextAPI
     */
    public BoardHook(final ContextAPI contextAPI) {
        this.contextAPI = contextAPI;
    }
    /**
     * Creates thee board before execute the step with the createBoard tag.
     */
    @Before(value = "@createBoard", order = 0)
    public void createBoard() {
        String endpoint = Environment.getInstance().getBaseUrlApi() + "/boards/";
        JSONObject json = new JSONObject();
        json.put("name", "testBoard");
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        Response response = RequestManager.post(endpoint, json.toString());
        contextAPI.saveDataCollection("board", response.jsonPath().getMap(""));
    }

    /**
     * Delete the board after execute Stepdefs with the deleteBoard tag.
     */
    @After(value = "@deleteBoard", order = 1)
    public void deleteBoard() {
        String idBoard = contextAPI.getDataCollection("board").get("id");
        contextAPI.setRequestSpec(Authentication.getLoggedReqSpec());
        given(contextAPI.getRequestSpecification()).when().delete("/boards/".concat(idBoard));
    }
}

