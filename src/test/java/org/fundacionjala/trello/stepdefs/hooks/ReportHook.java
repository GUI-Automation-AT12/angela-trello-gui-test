package org.fundacionjala.trello.stepdefs.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.fundacionjala.trello.core.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ReportHook {
    @After
    public void embedScreenshot(Scenario scenario) {
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

    }
}
