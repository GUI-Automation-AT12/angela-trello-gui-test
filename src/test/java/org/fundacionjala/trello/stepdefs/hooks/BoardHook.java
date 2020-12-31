package org.fundacionjala.trello.stepdefs.hooks;

import org.fundacionjala.trello.core.client.RequestManager;
import org.fundacionjala.trello.core.context.Context;
import org.fundacionjala.trello.trello.config.EnvironmentApi;
import org.fundacionjala.trello.trello.utils.Authentication;
import io.cucumber.java.After;

public class BoardHook {
    public static final int POS_INI_ID = 21;
    public static final int POS_FIN_ID = 29;
    private Context context;

    /**
     * Initializes an instance of Context class.
     * @param sharedContext
     */
    public BoardHook(final Context sharedContext) {
        this.context = sharedContext;
    }

    /**
     * Delete the board after execute Stepdefs with the deleteBoard tag.
     */
    @After(value = "@DeleteBoard", order = 1)
    public void deleteBoard() {
        String boardUrl = context.getValueData("board");
        String idBoard = boardUrl.substring(POS_INI_ID, POS_FIN_ID);
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        String endpoint = EnvironmentApi.getInstance().getBaseUrlApi().concat("/boards/").concat(idBoard);
        RequestManager.delete(endpoint);
    }
}
