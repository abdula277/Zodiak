package grigory.panov.zodiak.utils;

import java.util.Calendar;

public class ZodiakResolver {
    public static String resolve(Calendar date){
        int month = date.get(Calendar.MONTH);
        int day = date.get(Calendar.DAY_OF_MONTH);
        String value = "Козерог";
        if (month==Calendar.JANUARY && day>=20 || month==Calendar.FEBRUARY && day<=18) value="Водолей";
        else if (month==Calendar.FEBRUARY && day>=19 || month==Calendar.MARCH && day<=20) value="Рыбы";
        else if (month==Calendar.MARCH && day>=21 || month==Calendar.APRIL && day<=19) value="Овен";
        else if (month==Calendar.APRIL && day>=20 || month==Calendar.MAY && day<=20) value="Телец";
        else if (month==Calendar.MAY && day>=21 || month==Calendar.JUNE && day<=21) value="Близнецы";
        else if (month==Calendar.JUNE && day>=22 || month==Calendar.JULY && day<=22) value="Рак";
        else if (month==Calendar.JULY && day>=23 || month==Calendar.AUGUST && day<=22) value="Лев";
        else if (month==Calendar.AUGUST && day>=23 || month==Calendar.SEPTEMBER && day<=22) value="Дева";
        else if (month==Calendar.SEPTEMBER && day>=23 || month==Calendar.OCTOBER && day<=22) value="Весы";
        else if (month==Calendar.OCTOBER && day>=23 || month==Calendar.NOVEMBER && day<=21) value="Скорпион";
        else if (month==Calendar.NOVEMBER && day>=22 || month==Calendar.DECEMBER && day<=21) value="Стрелец";
       // else if (month==12 && day>=22 || month==1 && day<=19) value="Козерог";
        return value;
    }
}
