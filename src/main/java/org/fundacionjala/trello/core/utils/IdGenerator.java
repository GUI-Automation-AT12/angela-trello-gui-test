package org.fundacionjala.trello.core.utils;

import java.sql.Timestamp;

public final class IdGenerator {
    /**
     * Constructor.
     */
    private IdGenerator() { }

    /**
     * Gets unique id.
     * @return unique id.
     */
    public static String getUniqueId() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return DateHelper.convertDateString(timestamp);
    }
}
