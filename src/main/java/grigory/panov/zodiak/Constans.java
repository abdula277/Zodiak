package grigory.panov.zodiak;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Constans {
    public static Map<String, String> ZODIAK_MAP;

    static {
        ZODIAK_MAP = new HashMap<>();
        ZODIAK_MAP.put("Козерог", "capricorn");
        ZODIAK_MAP.put("Водолей", "aquarius");
        ZODIAK_MAP.put("Рыбы", "pisces");
        ZODIAK_MAP.put("Овен", "aries");
        ZODIAK_MAP.put("Телец", "taurus");
        ZODIAK_MAP.put("Близнецы", "gemini");
        ZODIAK_MAP.put("Рак", "cancer");
        ZODIAK_MAP.put("Лев", "leo");
        ZODIAK_MAP.put("Дева", "virgo");
        ZODIAK_MAP.put("Весы", "libra");
        ZODIAK_MAP.put("Скорпион", "scorpio");
        ZODIAK_MAP.put("Стрелец", "sagittarius");
        ZODIAK_MAP = Collections.unmodifiableMap(ZODIAK_MAP);
    }
}