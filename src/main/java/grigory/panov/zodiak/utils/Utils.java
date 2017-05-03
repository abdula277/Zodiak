package grigory.panov.zodiak.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class Utils {

    private final static String NULL_DATE_MSG = "The date should not be null";
    private final static String SDF_PATTERN = "yyyy-MM-dd";

    public static Date tryParseDate(String dateString) throws ParseException {
        Calendar cal = Calendar.getInstance();
        if (dateString == null) {
            throw new IllegalArgumentException(NULL_DATE_MSG);
        }
        SimpleDateFormat sdf = new SimpleDateFormat(SDF_PATTERN, Locale.ENGLISH);
        cal.setTime(sdf.parse(dateString));
        return sdf.parse(dateString);
    }
}

