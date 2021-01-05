package org.fundacionjala.trello.trello.config;

import org.fundacionjala.trello.core.utils.PropertyReader;
import java.util.Properties;

public final class EnvironmentApi {
    private static final String PATH = "settingsApi.properties";
    private static EnvironmentApi singleInstance;
    private Properties property;

    private EnvironmentApi() {
        property = PropertyReader.readProperty(PATH);
    }

    /**
     * get instance or create a new one.
     *
     * @return PropertiesReader instance.
     */
    public static EnvironmentApi getInstance() {
        if (singleInstance == null) {
            singleInstance = new EnvironmentApi();
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
     * Gets base url for API.
     * @return baseUrlApi
     */
    public String getBaseUrlApi() {
        return getEnvProperty("baseUrl");
    }

    /**
     * Get token.
     * @return token
     */
    public String getEnvApiToken() {
        return getEnvProperty("token");
    }

    /**
     * Get key.
     * @return key
     */
    public String getEnvApiKey() {
        return getEnvProperty("key");
    }
}
