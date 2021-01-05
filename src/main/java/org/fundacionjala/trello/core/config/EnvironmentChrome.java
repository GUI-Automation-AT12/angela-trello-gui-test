package org.fundacionjala.trello.core.config;

import org.fundacionjala.trello.core.utils.PropertyReader;

import java.util.Properties;

public final class EnvironmentChrome {
    private static final String PATH = "chrome.properties";
    private static EnvironmentChrome singleInstance;
    private Properties property;

    private EnvironmentChrome() {
        property = PropertyReader.readProperty(PATH);
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static EnvironmentChrome getInstance() {
        if (singleInstance == null) {
            singleInstance = new EnvironmentChrome();
        }
        return singleInstance;
    }

    private String getEnvProperty(final String env) {
        String localProperty = System.getProperty(env);
        if (localProperty == null) {
            return this.property.getProperty(env);
        }
        return localProperty;
    }

    /**
     * Gets DriverPath.
     * @return driverPath
     */
    public String getDriverPath() {
        return getEnvProperty("chromePath");
    }
}
