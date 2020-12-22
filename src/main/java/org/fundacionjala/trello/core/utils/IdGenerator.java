package org.fundacionjala.trello.core.utils;
import java.sql.Timestamp;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IdGenerator {
    public static String convertDateString(Date date) {
        Format formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        return formatter.format(date);
    }

    public static String getUniqueId() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        return convertDateString(timestamp);
    }
}
