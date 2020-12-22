package org.fundacionjala.trello.trello.entities;

import org.fundacionjala.trello.core.utils.IdGenerator;
import org.fundacionjala.trello.trello.pages.ProfilePage;

import java.util.HashMap;
import java.util.Map;
import org.fundacionjala.trello.trello.pages.BasePage;

public class User {
    private String username;
    private String bio;

    public String getUsername() {
        return username;
    }

    public String getBio() {
        return bio;
    }

    public void setUsername(final String username) {
        this.username = username.replaceAll("UNIQUE_ID", IdGenerator.getUniqueId());
    }

    public void setBio(final String bio) {
        this.bio = bio;
    }
    
    public void processInformation(Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = composeStrategyMap(userInformation);
        userInformation.keySet().forEach(key-> strategyMap.get(key).run());
    }

    private HashMap<String, Runnable> composeStrategyMap(final Map<String, String> userInformation) {
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("username", () -> setUsername(userInformation.get("username")));
        strategyMap.put("bio", () -> setBio(userInformation.get("bio")));
        return strategyMap;
    }

    public void processUIInformation(final Map<String, String> userInformation, final BasePage page) {
        HashMap<String, Runnable> strategyMap = composeUIStrategyMap(page);
        userInformation.keySet().forEach(key-> strategyMap.get(key).run());
    }

    public HashMap<String, Runnable> composeUIStrategyMap(final BasePage page) {
        ProfilePage profilePage = (ProfilePage) page;
        HashMap<String, Runnable> strategyMap = new HashMap<>();
        strategyMap.put("username", () -> profilePage.setUsername(this.getUsername()));
        strategyMap.put("bio", () -> profilePage.setBio(this.getBio()));
        return null;
    }
}
