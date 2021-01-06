package org.fundacionjala.trello.core.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.fundacionjala.trello.trello.config.EnvironmentTrello;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public final class PropertyReader {
    private static final Logger LOGGER = LogManager.getLogger(EnvironmentTrello.class);
    private static FileReader reader;

    private PropertyReader() { }

    /**
     * Read properties from file.
     * @param path
     * @return Properties
     */
    public static Properties readProperty(final String path) {
        Properties properties = new Properties();
        try {
            reader = new FileReader(path);
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            System.exit(1);
        } finally {
            closeReader();
        }
        return properties;
    }

    private static void closeReader() {
        try {
            reader.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
