package org.fundacionjala.trello.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public final class JsonReader {
    /**
     * Contructor.
     */
    private JsonReader() { }

    /**
     * Reads information from json file.
     * @param path
     * @return HashMap
     * @throws IOException
     * @throws ParseException
     */
    public static HashMap<String, Object> readJsonFile(final String path) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(path));
        JSONObject jsonObject = (JSONObject) obj;
        return new ObjectMapper().readValue(jsonObject.toJSONString(), HashMap.class);
    }

    /**
     * Gets an entity instance with the information populated from a JSON file.
     *
     * @param entityType - Entity class.
     * @param path - JSON file path.
     * @param <T> the type of entity obtained by the method.
     *
     * @return entity populated with the information from the JSON file.
     */
    public static <T> T getEntityFromJSON(final Class<T> entityType, final String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(path), entityType);
        } catch (IOException e) {
            throw new IllegalArgumentException("The json path is not correct", e);
        }
    }
}
