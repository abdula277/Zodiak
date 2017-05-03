package grigory.panov.zodiak.utils;

import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class ZodiakResolverTests {
    private static final int YEAR = 2017;

    @Test
    public void testCapricorn() {
        assertEquals("Козерог", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 11, 22)));
        assertEquals("Козерог", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 0, 19)));
        assertEquals("Козерог", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 11, 30)));
    }

    @Test
    public void testAquarius() {
        assertEquals("Водолей", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 0, 20)));
        assertEquals("Водолей", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 1, 18)));
        assertEquals("Водолей", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 0, 30)));
    }

    @Test
    public void testPisces() {
        assertEquals("Рыбы", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 1, 19)));
        assertEquals("Рыбы", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 2, 20)));
        assertEquals("Рыбы", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 1, 28)));
    }

    @Test
    public void testAries() {
        assertEquals("Овен", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 2, 21)));
        assertEquals("Овен", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 3, 19)));
        assertEquals("Овен", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 2, 30)));
    }

    @Test
    public void testTaurus() {
        assertEquals("Телец", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 3, 20)));
        assertEquals("Телец", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 4, 20)));
        assertEquals("Телец", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 3, 30)));
    }

    @Test
    public void testGemini() {
        assertEquals("Близнецы", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 4, 21)));
        assertEquals("Близнецы", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 5, 21)));
        assertEquals("Близнецы", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 4, 30)));
    }

    @Test
    public void testCancer() {
        assertEquals("Рак", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 5, 22)));
        assertEquals("Рак", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 6, 22)));
        assertEquals("Рак", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 5, 30)));
    }

    @Test
    public void testLeo() {
        assertEquals("Лев", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 6, 23)));
        assertEquals("Лев", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 7, 22)));
        assertEquals("Лев", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 7, 8)));
    }

    @Test
    public void testVirgo() {
        assertEquals("Дева", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 7, 23)));
        assertEquals("Дева", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 8, 22)));
        assertEquals("Дева", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 7, 30)));
    }

    @Test
    public void testLibra() {
        assertEquals("Весы", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 8, 23)));
        assertEquals("Весы", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 9, 22)));
        assertEquals("Весы", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 8, 30)));
    }

    @Test
    public void testScorpio() {
        assertEquals("Скорпион", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 9, 23)));
        assertEquals("Скорпион", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 10, 21)));
        assertEquals("Скорпион", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 9, 30)));
    }

    @Test
    public void testSagittarius() {
        assertEquals("Стрелец", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 10, 22)));
        assertEquals("Стрелец", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 11, 21)));
        assertEquals("Стрелец", ZodiakResolver.resolve(new GregorianCalendar(YEAR, 10, 30)));
    }

    @Test(expected = NullPointerException.class)
    public void testNullArgument() {
        ZodiakResolver.resolve(null);
    }
}