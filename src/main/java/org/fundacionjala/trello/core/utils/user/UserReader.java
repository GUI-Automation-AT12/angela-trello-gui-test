package org.fundacionjala.trello.core.utils.user;

import org.fundacionjala.trello.core.utils.JsonReader;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.HashMap;

public class UserReader {
    private static final String USER_FILE_PATH = "config/user.json";

    public static String getUsername(final String kindUser) throws IOException, ParseException {
        HashMap<String, Object> map = JsonReader.readJsonFile(USER_FILE_PATH);
        HashMap<String, String> userMap = (HashMap<String, String>) map.get(kindUser);
        return userMap.get("username");
    }

    public static String getPassword(final String kindUser) throws IOException, ParseException {
        HashMap<String, Object> map = JsonReader.readJsonFile(USER_FILE_PATH);
        HashMap<String, String> userMap = (HashMap<String, String>) map.get(kindUser);
        return userMap.get("password");
    }
}
