package org.fundacionjala.trello.runner;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.fundacionjala.trello.core.config.Environment;
import org.testng.annotations.DataProvider;

/**
 * Cucumber TestNG runner class.
 */
@CucumberOptions(
        glue = {"org.fundacionjala.trello.stepdefs"},
        features = {"src/test/resources/features"},
        plugin = {"pretty", "json:build/targetJson/cucumber-report/cucumber.json",
                "html:build/targetJson/test-output.html/"}
)

public final class Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /**
     * Executes code before all scenarios.
     */
    @Before
    public void beforeAllScenarios() {
        System.setProperty("dataproviderthreadcount", Environment.getInstance().getCucumberThreadCount());
    }
}

