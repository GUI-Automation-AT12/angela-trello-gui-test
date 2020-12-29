package org.fundacionjala.trello.core.utils;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class IdGenerator {
    /**
     * Constructor.
     */
    private IdGenerator() { }

    /**
     * Converts date to string.
     * @param date
     * @return date in string
     */
    private static String convertDateString(final Date date) {
        Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(date);
    }

    /**
     * Gets unique id.
     * @return unique id.
     */
    public static String getUniqueId() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return convertDateString(timestamp);
    }
}
