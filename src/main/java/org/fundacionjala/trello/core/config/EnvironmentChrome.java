package org.fundacionjala.trello.core.config;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class EnvironmentChrome {
    private static final String PATH = "chrome.properties";
    private static EnvironmentChrome singleInstance;
    private Properties property;
    private FileReader reader;

    private EnvironmentChrome() {
        try {
            reader = new FileReader(PATH);
            property = new Properties();
            property.load(reader);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            closeReader();
        }
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

    private void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
