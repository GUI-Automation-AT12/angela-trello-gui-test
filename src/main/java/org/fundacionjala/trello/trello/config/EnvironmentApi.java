package org.fundacionjala.trello.trello.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class EnvironmentApi {
    private static final Logger LOGGER = LogManager.getLogger(Environment.class);
    private static final String PATH = "settingsApi.properties";
    private static EnvironmentApi singleInstance;
    private Properties property;
    private FileReader reader;

    private EnvironmentApi() {
        try {
            reader = new FileReader(PATH);
            property = new Properties();
            property.load(reader);
        } catch (FileNotFoundException e) {
            LOGGER.error(e.getMessage());
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } finally {
            closeReader();
        }
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

    private void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
