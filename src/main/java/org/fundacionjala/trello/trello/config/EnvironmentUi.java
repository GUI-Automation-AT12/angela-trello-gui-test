package org.fundacionjala.trello.trello.config;

import java.util.Properties;
import org.fundacionjala.trello.core.utils.PropertyReader;

/**
 * PropertiesReader class.
 */
public final class EnvironmentUi {
    private static final String PATH = "trello.properties";
    private static EnvironmentUi singleInstance;
    private Properties property;

    private EnvironmentUi() {
        property = PropertyReader.readProperty(PATH);
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static EnvironmentUi getInstance() {
        if (singleInstance == null) {
            singleInstance = new EnvironmentUi();
        }
        return singleInstance;
    }

    /**
     * Gets the User from the file.properties.
     * @return User value.
     */
    public String getEmail() {
        return getEnvProperty("email");
    }

    /**
     * Gets the password from the file.properties.
     * @return Password value.
     */
    public String getPassword() {
        return getEnvProperty("password");
    }

    /**
     * Gets the base url.
     * @return baseUrl
     */
    public String getBaseUrl() {
        return getEnvProperty("baseUrl");
    }

    private String getEnvProperty(final String env) {
        String localProperty = System.getProperty(env);
        if (localProperty == null) {
            return this.property.getProperty(env);
        }
        return localProperty;
    }
}


