package org.fundacionjala.trello.core.context;

import java.util.HashMap;
import java.util.Map;

/**
 * Context class.
 */
public class Context {
    private Map<String, String> data;
    private Map<String, Map<String, String>> dataCollection;

    /**
     * Constructor for the Context.
     */
    public Context() {
        data = new HashMap<>();
        dataCollection = new HashMap<String, Map<String, String>>();
    }

    /**
     * Gets data map collection.
     * @param key
     * @return dataCollection
     */
    public Map<String, String> getDataCollection(final String key) {
        return dataCollection.getOrDefault(key, new HashMap<String, String>());
    }

    /**
     * Saves the data in to data collection.
     * @param key
     * @param dataMap
     */
    public void saveDataCollection(final String key, final Map<String, String> dataMap) {
        dataCollection.put(key, dataMap);
    }

    /**
     * Saves the data of form data in data.
     * @param key
     * @param value
     */
    public void saveData(final String key, final String value) {
        data.put(key, value);
    }

    /**
     * Gets data map.
     * @return data map
     */
    public Map<String, String> getData() {
        return data;
    }

    /**
     * Gets the value of key given.
     * @param key
     * @return a String data
     */
    public String getValueData(final String key) {
        return data.getOrDefault(key, "");
    }
}
