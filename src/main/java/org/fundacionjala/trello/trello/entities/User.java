package org.fundacionjala.trello.trello.entities;

import org.fundacionjala.trello.core.utils.IdGenerator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;

public class User extends TrelloEntity {
    private String username;
    private String bio;
    private String email;
    private String password;
    private Set<String> updatedFields = new HashSet<>();

    /**
     * Gets username.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets bio.
     * @return bio
     */
    public String getBio() {
        return bio;
    }

    /**
     * Sets username.
     * @param newUsername
     */
    public void setUsername(final String newUsername) {
        this.username = newUsername.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
    }

    /**
     * Sets bio.
     * @param newBio
     */
    public void setBio(final String newBio) {
        this.bio = newBio.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
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
     * @param userInformation
     * @return HashMap
     */
    private HashMap<String, Runnable> composeStrategyMap(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("username", () -> setUsername(userInformation.get("username")));
        strategyMap.put("bio", () -> setBio(userInformation.get("bio")));
        return strategyMap;
    }

    /**
     * Sets user information.
     * @param userInformation
     */
    public void processInformation(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(userInformation);
        userInformation.keySet().forEach(key -> strategyMap.get(key).run());
        updatedFields = userInformation.keySet();
    }

    /**
     * Composes strategy map.
     * @return HashMap
     */
    private HashMap<String, Supplier<String>> composeStrategyGetterMap() {
        HashMap<String, Supplier<String>> strategyMap = new HashMap<>();
        strategyMap.put("username", () -> getUsername());
        strategyMap.put("bio", () -> getBio());
        return  strategyMap;
    }

    /**
     * Gets updated profile's information.
     * @return Map
     */
    public Map<String, String> getUpdatedInfo() {
        Map<String, String> userProfileUpdated = new HashMap<>();
        HashMap<String, Supplier<String>> strategyMap = composeStrategyGetterMap();
        updatedFields.forEach(key -> userProfileUpdated.put(key, strategyMap.get(key).get()));
        return userProfileUpdated;
    }

    /**
     * Set email.
     * @param newEmail
     */
    public void setEmail(final String newEmail) {
        email = newEmail;
    }

    /**
     * Get email.
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set password.
     * @param newPassword
     */
    public void setPassword(final String newPassword) {
        password = newPassword;
    }

    /**
     * get password.
     * @return password
     */
    public String getPassword() {
        return password;
    }
}
