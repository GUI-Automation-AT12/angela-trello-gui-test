package org.fundacionjala.trello.trello.config;

import java.util.Properties;
import org.fundacionjala.trello.core.utils.PropertyReader;

/**
 * PropertiesReader class.
 */
public final class EnvironmentTrello {
    private static final String PATH = "gradle.properties";
    private static EnvironmentTrello singleInstance;
    private Properties property;

    private EnvironmentTrello() {
        property = PropertyReader.readProperty(PATH);
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static EnvironmentTrello getInstance() {
        if (singleInstance == null) {
            singleInstance = new EnvironmentTrello();
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


