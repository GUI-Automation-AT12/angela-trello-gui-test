package org.fundacionjala.trello.trello.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Team {
    private String name;
    private String type;
    private String description;
    private List<User> members;
    private Set<String> updatedFields;

    /**
     * Contructor.
     */
    public Team() {
        updatedFields = new HashSet<>();
    }

    /**
     * Get updated fields.
     * @return a Set
     */
    public Set<String> getUpdatedFields() {
        return updatedFields;
    }

    /**
     * Set updatedFields.
     * @param fields
     */
    public void setUpdatedFields(final Set<String> fields) {
        this.updatedFields = fields;
    }

    /**
     * Get name.
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set name.
     * @param newName
     */
    public void setName(final String newName) {
        this.name = newName;
    }

    /**
     * Get type.
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Set type.
     * @param newType
     */
    public void setType(final String newType) {
        this.type = newType;
    }

    /**
     * Get description.
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description.
     * @param desc
     */
    public void setDescription(final String desc) {
        this.description = desc;
    }

    /**
     * Get members.
     * @return list of members
     */
    public List<User> getMembers() {
        return members;
    }

    /**
     * Set members.
     * @param listMembers
     */
    public void setMembers(final List<User> listMembers) {
        this.members = listMembers;
    }

    /**
     * Composes strategy map.
     * @param teamInformation
     * @return HashMap
     */
    private HashMap<String, Runnable> composeStrategyMap(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setName(teamInformation.get("name")));
        strategyMap.put("type", () -> setType(teamInformation.get("type")));
        strategyMap.put("description", () -> setDescription(teamInformation.get("description")));
        return strategyMap;
    }

    /**
     * Sets team information.
     * @param teamInformation
     */
    public void processInformation(final Map<String, String> teamInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(teamInformation);
        teamInformation.keySet().forEach(key -> strategyMap.get(key).run());
        updatedFields = teamInformation.keySet();
    }
}
