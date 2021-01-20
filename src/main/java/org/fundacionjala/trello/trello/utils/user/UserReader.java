package org.fundacionjala.trello.trello.utils.user;

import org.fundacionjala.trello.core.utils.JsonReader;
import org.fundacionjala.trello.trello.entities.User;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class UserReader {
    public static final String USER_FILE_PATH = "config/user.json";
    private static final Map<String, String> TYPE_USERS = new HashMap<>();
    static {
        TYPE_USERS.put("Editable", "config/editableUser.json");
    }

    /**
     * Constructor.
     */
    private UserReader() { }

    private static Map<String, String> getUserMap(final String typeUser) throws IOException, ParseException {
        HashMap<String, Object> map = JsonReader.readJsonFile(USER_FILE_PATH);
        HashMap<String, String> userMap = (HashMap<String, String>) map.get(typeUser);
        return userMap;
    }
    /**
     * Gets username.
     * @param typeUser
     * @return username
     * @throws IOException
     * @throws ParseException
     */
    public static String getUsername(final String typeUser) throws IOException, ParseException {
        return getUserMap(typeUser).get("username");
    }

    /**
     * Gets email from user.
     * @param typeUser
     * @return email
     * @throws IOException
     * @throws ParseException
     */
    public static String getEmail(final String typeUser) throws IOException, ParseException {
        return getUserMap(typeUser).get("email");
    }

    /**
     * Gets password.
     * @param typeUser
     * @return password
     * @throws IOException
     * @throws ParseException
     */
    public static String getPassword(final String typeUser) throws IOException, ParseException {
        return getUserMap(typeUser).get("password");
    }

    /**
     * Gets bio.
     * @param typeUser
     * @return bio
     * @throws IOException
     * @throws ParseException
     */
    public static String getBio(final String typeUser) throws IOException, ParseException {
        return getUserMap(typeUser).get("bio");
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

    /**
     * Get User from json file.
     * @param typeUser to read
     * @return a User
     */
    public static User getUser(final String typeUser) {
        User user = JsonReader.getEntityFromJSON(User.class, TYPE_USERS.get(typeUser));
        return user;
    }
}
