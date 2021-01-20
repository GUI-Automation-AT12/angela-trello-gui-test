package org.fundacionjala.trello.hooks;

import io.cucumber.java.Before;
import io.restassured.response.Response;
import org.fundacionjala.trello.core.client.RequestManager;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.api.BoardHelper;
import org.fundacionjala.trello.trello.config.EnvironmentApi;
import org.fundacionjala.trello.trello.api.Authentication;
import io.cucumber.java.After;
import org.json.JSONObject;

public class BoardHook {
    public static final int POS_INI_ID = 21;
    public static final int POS_FIN_ID = 29;
    private Context context;
    private BoardHelper boardHelper;

    /**
     * Initializes an instance of Context class.
     * @param sharedContext
     */
    public BoardHook(final Context sharedContext) {
        this.context = sharedContext;
        boardHelper = new BoardHelper();
    }

    /**
     * Delete the board after execute Stepdefs with the deleteBoard tag.
     */
    @Before(value = "@CreateBoard", order = 0)
    public void createBoard() {
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        String endpoint = EnvironmentApi.getInstance().getBaseUrlApi().concat("/boards/");
        JSONObject json = new JSONObject();
        json.put("name", "TestBoard");
        Response response = RequestManager.post(endpoint, json.toString());
        context.saveDataCollection("board", response.jsonPath().getMap(""));
    }

    /**
     * Delete the board after execute Stepdefs with the deleteBoard tag.
     */
    @After(value = "@DeleteBoard", order = 1)
    public void deleteBoardByUrl() {
        String boardUrl = context.getValueData("board");
        String idBoard = boardUrl.substring(POS_INI_ID, POS_FIN_ID);
        boardHelper.deleteBoard(idBoard);
    }

    /**
     * Delete the board after execute Stepdefs with the deleteBoard tag.
     */
    @After(value = "@DeleteABoard", order = 1)
    public void deleteBoard() {
        String boardId = context.getDataCollection("board").get("id");
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        String endpoint = EnvironmentApi.getInstance().getBaseUrlApi().concat("/boards/").concat(boardId);
        RequestManager.delete(endpoint);
    }
}
