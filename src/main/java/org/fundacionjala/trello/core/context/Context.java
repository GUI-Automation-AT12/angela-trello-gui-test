package org.fundacionjala.trello.core.context;

import org.fundacionjala.trello.trello.entities.Board;
import org.fundacionjala.trello.trello.entities.User;

/**
 * Context class.
 */
public class Context {
    private User user;
    private Board board;

    /**
     * Constructor for the Context.
     */
    public Context() {
    }

    public User getUser() {
        return user;
    }

    public Board getBoard() {
        return board;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
}

