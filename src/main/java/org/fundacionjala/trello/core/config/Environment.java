package org.fundacionjala.trello.core.config;

import org.fundacionjala.trello.core.utils.PropertyReader;
import java.util.Properties;

public final class Environment {
    private static final String PATH = "gradle.properties";
    private static Environment singleInstance;
    private Properties property;


    private Environment() {
        property = PropertyReader.readProperty(PATH);
    }

    /**
     * Get filter tags.
     * @return filterTags
     */
    public String getFilterTags() {
        return getEnvProperty("filterTags");
    }
    private String getEnvProperty(final String env) {
        String localProperty = System.getProperty(env);
        if (localProperty == null) {
            return this.property.getProperty(env);
        }
        return localProperty;
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static Environment getInstance() {
        if (singleInstance == null) {
            singleInstance = new Environment();
        }
        return singleInstance;
    }
    /**
     * Gets browser.
     * @return browser
     */
    public String getBrowser() {
        return getEnvProperty("browser");
    }

    /**
     * Get quantity of threads.
     * @return cucumberThreadCount
     */
    public String getCucumberThreadCount() {
        return getEnvProperty("cucumberThreadCount");
    }
}
