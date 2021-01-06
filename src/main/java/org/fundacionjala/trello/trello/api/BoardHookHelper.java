package org.fundacionjala.trello.trello.api;

import org.fundacionjala.trello.core.client.RequestManager;
import org.fundacionjala.trello.trello.config.EnvironmentApi;
import org.fundacionjala.trello.trello.utils.Authentication;

public class BoardHookHelper {

    /**
     * Initializes an instance of Context class.
     */
    public BoardHookHelper() { }

    /**
     * Delete a board.
     * @param idBoard id of the board to delete
     */
    public void deleteBoard(final String idBoard) {
        RequestManager.setRequestSpec(Authentication.getLoggedReqSpec());
        String endpoint = EnvironmentApi.getInstance().getBaseUrlApi().concat("/boards/").concat(idBoard);
        RequestManager.delete(endpoint);
    }
}
