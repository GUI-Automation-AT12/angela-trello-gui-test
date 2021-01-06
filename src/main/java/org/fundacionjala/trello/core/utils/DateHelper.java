package org.fundacionjala.trello.core.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateHelper {
    /**
     * Constructor.
     */
    private DateHelper() { }
    /**
     * Converts date to string.
     * @param date
     * @return date in string
     */
    public static String convertDateString(final Date date) {
        Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(date);
    }
}
