package org.fundacionjala.trello.trello.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Board {
    private String name;
    private String team;
    private String privacy;
    private Set<String> fields;

    /**
     * Constructor.
     */
    public Board() {
    }

    /**
     * Gets team.
     * @return team
     */
    public String getTeam() {
        return team;
    }

    /**
     * Set Team.
     * @param teamBoard
     */
    public void setTeam(final String teamBoard) {
        this.team = teamBoard;
    }

    /**
     * Get privacy.
     * @return privacy
     */
    public String getPrivacy() {
        return privacy;
    }

    /**
     * Set privacy.
     * @param privacyBoard
     */
    public void setPrivacy(final String privacyBoard) {
        this.privacy = privacyBoard;
    }

    /**
     * Get updated fields.
     * @return set of updated fields
     */
    public Set<String> getFields() {
        return fields;
    }

    /**
     * Set updated fields.
     * @param updatedFields
     */
    public void setFields(final Set<String> updatedFields) {
        this.fields = updatedFields;
    }

    /**
     * Sets name.
     * @param newName
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Gets name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Composes strategy map.
     * @param boardInformation
     * @return HashMap
     */
    private HashMap<String, Runnable> composeStrategyMap(final Map<String, String> boardInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setName(boardInformation.get("name")));
        strategyMap.put("team", () -> setTeam(boardInformation.get("team")));
        strategyMap.put("privacy", () -> setPrivacy(boardInformation.get("privacy")));
        return strategyMap;
    }

    /**
     * Sets board information.
     * @param boardInformation
     */
    public void processInformation(final Map<String, String> boardInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(boardInformation);
        boardInformation.keySet().forEach(key -> strategyMap.get(key).run());
        fields = boardInformation.keySet();
    }
}
