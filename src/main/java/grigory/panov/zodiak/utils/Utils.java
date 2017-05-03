package grigory.panov.zodiak.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class Utils {
    private final static String FORMAT_PATTERN = "\\d{4}-\\d{2}-\\d{2}";
    private final static String ERROR_FORMAT_MSG = "The date should match pattern yyyy-MM-dd";
    /*Pattern from regexlib*/
    private final static String RANGE_PATTERN = "^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$";
    private final static String ERROR_RANGE_MSG = "The date should have correct range";
    private final static String NULL_DATE_MSG = "The date should not be null";
    private final static String SDF_PATTERN = "yyyy-MM-dd";

    public static Date tryParseDate(String dateString) throws ParseException {
        Calendar cal = Calendar.getInstance();
        if (dateString == null) {
            throw new IllegalArgumentException(NULL_DATE_MSG);
        }

/*        Pattern patternFormat = Pattern.compile(FORMAT_PATTERN);
        if (!patternFormat.matcher(dateString).matches()) {
            throw new IllegalArgumentException(ERROR_FORMAT_MSG);
        }

        Pattern patternRange = Pattern.compile(RANGE_PATTERN);
        if (!patternRange.matcher(dateString).matches()) {
            throw new IllegalArgumentException(ERROR_RANGE_MSG);
        }*/

        SimpleDateFormat sdf = new SimpleDateFormat(SDF_PATTERN, Locale.ENGLISH);
        cal.setTime(sdf.parse(dateString));
        return sdf.parse(dateString);
    }
}

