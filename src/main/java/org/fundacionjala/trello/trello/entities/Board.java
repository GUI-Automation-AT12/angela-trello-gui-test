package org.fundacionjala.trello.trello.entities;

public class Board {
    private String name;
    private String desc;

    /**
     * Constructor.
     */
    public Board() {
    }

    /**
     * Sets name.
     * @param newName
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Sets description.
     * @param newDesc
     */
    public void setDesc(final String newDesc) {
        this.desc = newDesc;
    }

    /**
     * Gets name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets description.
     * @return description
     */
    public String getDesc() {
        return desc;
    }
}
