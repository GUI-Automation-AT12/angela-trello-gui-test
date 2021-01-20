package org.fundacionjala.trello.trello.entities;

import org.fundacionjala.trello.core.utils.IdGenerator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Card extends TrelloEntity {
    private String name;
    private Set<String> updatedFields = new HashSet<>();

    /**
     * Gets name.
     * @return name
     */
    public String getName() {
        return name;
    }



    /**
     * Sets username.
     * @param newName
     */
    public void setName(final String newName) {
        this.name = newName.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
    }

    /**
     * Gets updated fields.
     * @return Set of updated fields.
     */
    public Set<String> getUpdatedFields() {
        return updatedFields;
    }

    /**
     * Composes strategy map.
     * @param cardInformation
     * @return HashMap
     */
    private HashMap<String, Runnable> composeStrategyMap(final Map<String, String> cardInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> setName(cardInformation.get("name")));
        return strategyMap;
    }

    /**
     * Sets user information.
     * @param cardInformation
     */
    public void processInformation(final Map<String, String> cardInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(cardInformation);
        cardInformation.keySet().forEach(key -> strategyMap.get(key).run());
        updatedFields = cardInformation.keySet();
    }
}
