package grigory.panov.zodiak;


import grigory.panov.zodiak.utils.Utils;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class MyTests {
    @Test
    public void testMultiply() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String correctDate = "2017-01-01";
        Date date = sdf.parse(correctDate);
        assertEquals(Utils.tryParseDate(correctDate), date);
        assertEquals(Utils.tryParseDate(correctDate), date);
    }
}