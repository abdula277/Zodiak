package grigory.panov.zodiak.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static grigory.panov.zodiak.Constans.ZODIAK_MAP;

public class Utils {

    private final static String NULL_DATE_MSG = "The date should not be null";
    private final static String SDF_PATTERN = "yyyy-MM-dd";
    private final static String HOROSCOPE_SOURCE_URL = "http://img.ignio.com/r/export/utf/xml/daily/com.xml";
    public static Date tryParseDate(String dateString) throws ParseException {
        Calendar cal = Calendar.getInstance();
        if (dateString == null) {
            throw new IllegalArgumentException(NULL_DATE_MSG);
        }
        SimpleDateFormat sdf = new SimpleDateFormat(SDF_PATTERN, Locale.ENGLISH);
        cal.setTime(sdf.parse(dateString));
        return sdf.parse(dateString);
    }

    static boolean isSameDay(Calendar date1, Calendar date2){
        return !(date1.get(Calendar.YEAR) != date2.get(Calendar.YEAR) ||
                date1.get(Calendar.MONTH) != date2.get(Calendar.MONTH) ||
                date1.get(Calendar.DAY_OF_MONTH) != date2.get(Calendar.DAY_OF_MONTH));
    }

    static String getSignInEnglish(String signInRussian){
        return ZODIAK_MAP.get(signInRussian);
    }
}