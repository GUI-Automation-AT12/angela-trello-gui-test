package org.fundacionjala.trello.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.fundacionjala.trello.core.config.EnvironmentChrome;
import org.fundacionjala.trello.trello.config.Environment;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

/**
 * Cucumber TestNG runner class.
 */
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"org.fundacionjala.trello.stepdefs"},
        plugin = {"pretty", "html:test-output", "json:target/cucumber-report/cucumber.json"}

)

public final class Runner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    /**
     * Executes code before all scenarios.
     */
    @BeforeTest
    public void beforeAllScenarios() {
        System.setProperty("dataproviderthreadcount", Environment.getInstance().getCucumberThreadCount());
        System.setProperty("webdriver.chrome.driver", EnvironmentChrome.getInstance().getDriverPath());
    }
}

