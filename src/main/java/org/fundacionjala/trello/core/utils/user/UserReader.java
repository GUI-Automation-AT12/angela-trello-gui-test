package org.fundacionjala.trello.core.utils.user;

import org.fundacionjala.trello.core.utils.JsonReader;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class UserReader {
    public static final String USER_FILE_PATH = "config/user.json";

    /**
     * Constructor.
     */
    private UserReader() { }

    /**
     * Gets username.
     * @param typeUser
     * @return username
     * @throws IOException
     * @throws ParseException
     */
    public static String getUsername(final String typeUser) throws IOException, ParseException {
        HashMap<String, Object> map = JsonReader.readJsonFile(USER_FILE_PATH);
        HashMap<String, String> userMap = (HashMap<String, String>) map.get(typeUser);
        return userMap.get("username");
    }

    /**
     * Gets email from user.
     * @param typeUser
     * @return email
     * @throws IOException
     * @throws ParseException
     */
    public static String getEmail(final String typeUser) throws IOException, ParseException {
        HashMap<String, Object> map = JsonReader.readJsonFile(UserReader.USER_FILE_PATH);
        HashMap<String, String> userMap = (HashMap<String, String>) map.get(typeUser);
        return userMap.get("email");
    }

    /**
     * Gets password.
     * @param typeUser
     * @return password
     * @throws IOException
     * @throws ParseException
     */
    public static String getPassword(final String typeUser) throws IOException, ParseException {
        HashMap<String, Object> map = JsonReader.readJsonFile(USER_FILE_PATH);
        HashMap<String, String> userMap = (HashMap<String, String>) map.get(typeUser);
        return userMap.get("password");
    }

    /**
     * Gets bio.
     * @param typeUser
     * @return bio
     * @throws IOException
     * @throws ParseException
     */
    public static String getBio(final String typeUser) throws IOException, ParseException {
        HashMap<String, Object> map = JsonReader.readJsonFile(USER_FILE_PATH);
        HashMap<String, String> userMap = (HashMap<String, String>) map.get(typeUser);
        return userMap.get("bio");
    }

    /**
     * Gets user's information as a map.
     * @return Map
     * @throws IOException
     * @throws ParseException
     */
    public static Map<String, Object> getUsersAsMap() throws IOException, ParseException {
        Map<String, Object> users = new HashMap<>();
        users = JsonReader.readJsonFile(USER_FILE_PATH);
        return users;
    }
}
