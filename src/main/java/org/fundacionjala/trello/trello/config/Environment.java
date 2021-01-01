package org.fundacionjala.trello.trello.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * PropertiesReader class.
 */
public final class Environment {
    private static final Logger LOGGER = LogManager.getLogger(Environment.class);
    private static final String PATH = "gradle.properties";
    private static Environment singleInstance;
    private Properties property;
    private FileReader reader;

    private Environment() {
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
    public static Environment getInstance() {
        if (singleInstance == null) {
            singleInstance = new Environment();
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

    private void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
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

    /**
     * Get filter tags.
     * @return filterTags
     */
    public String getFilterTags() {
        return getEnvProperty("filterTags");
    }
}


