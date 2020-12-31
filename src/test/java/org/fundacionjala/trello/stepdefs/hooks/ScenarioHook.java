package org.fundacionjala.trello.stepdefs.hooks;

import io.cucumber.java.After;
import org.fundacionjala.trello.core.WebDriverManager;

public class ScenarioHook {

    @After(value = "@Functional", order = 0)
    public void afterTest() {
        WebDriverManager.getInstance().quite();
    }
}
