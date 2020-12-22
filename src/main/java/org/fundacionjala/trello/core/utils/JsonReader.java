package org.fundacionjala.trello.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class JsonReader {

    //@SuppressWarnings("unchecked")
    public static HashMap<String,Object> readJsonFile(String path) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader(path));
        JSONObject jsonObject = (JSONObject) obj;
        return new ObjectMapper().readValue(jsonObject.toJSONString(), HashMap.class);
    }
}
