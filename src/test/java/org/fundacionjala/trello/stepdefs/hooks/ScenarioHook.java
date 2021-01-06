package org.fundacionjala.trello.stepdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.fundacionjala.trello.core.selenium.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScenarioHook {

    /**
     * After each scenario.
     * @param scenario
     */
    @After(value = "@Functional", order = 0)
    public void afterTest(final Scenario scenario) {
        String screensHostName = scenario.getName().replaceAll(" ", "_");
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) WebDriverManager.getInstance().getWebDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", screensHostName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        WebDriverManager.getInstance().quit();
    }
}
