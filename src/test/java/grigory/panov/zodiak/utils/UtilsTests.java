package grigory.panov.zodiak.utils;


import org.junit.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class UtilsTests {
    @Test
    public void testCorrectDates() throws ParseException {
        Integer year = 2017;
        String correctDate = "2017-01-20";
        assertEquals(new GregorianCalendar(year, 0, 20).getTime(), Utils.tryParseDate(correctDate));
        correctDate = "2017-02-18";
        assertEquals(new GregorianCalendar(year, 1, 18).getTime(), Utils.tryParseDate(correctDate));
    }

    @Test
    public void testCorrectShortDay() throws ParseException {
        Integer year = 2017;
        String correctDate = "2017-05-3";
        assertEquals(new GregorianCalendar(year, 4, 3).getTime(), Utils.tryParseDate(correctDate));
    }

    @Test
    public void testCorrectShortMonth() throws ParseException {
        Integer year = 2017;
        String correctDate = "2017-1-05";
        assertEquals(new GregorianCalendar(year, 0, 5).getTime(), Utils.tryParseDate(correctDate));
    }

    @Test
    public void testCorrectShortYear() throws ParseException {
        Integer year = 201;
        String correctDate = "201-01-05";
        assertEquals(new GregorianCalendar(year, 0, 5).getTime(), Utils.tryParseDate(correctDate));
    }

    @Test(expected = ParseException.class)
    public void testIncorrectDate() throws ParseException {
        String incorrectDate = String.format("-%d-%d", Calendar.JANUARY, 30);
        Utils.tryParseDate(incorrectDate);
    }

    @Test(expected = ParseException.class)
    public void testIncorrectFormatDate() throws ParseException {
        String incorrectFormatDate = "05/01/2017";
        Utils.tryParseDate(incorrectFormatDate);
    }

    @Test(expected = NullPointerException.class)
    public void testNullArgument() {
        ZodiakResolver.resolve(null);
    }

}