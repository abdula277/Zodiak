package grigory.panov.zodiak.utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.*;

public class HoroscopeUtils {
    private final static String HOROSCOPE_SOURCE_URL = "http://img.ignio.com/r/export/utf/xml/daily/com.xml";
    private static Map<String, String> horoscopesForToday = new HashMap<>();
    private static Calendar lastUpdateDate = new GregorianCalendar(2017, 0,0); //any date in the past
    private static void updateHoroscope() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            Document doc = factory.newDocumentBuilder().parse(new URL(HOROSCOPE_SOURCE_URL).openStream());
            NodeList signs = doc.getChildNodes().item(0).getChildNodes();
            for (int i = 0; i < signs.getLength(); i++) {
                Node sign = signs.item(i);
                NodeList daysHoro = sign.getChildNodes();
                for (int j = 0; j < daysHoro.getLength(); j++) {
                    Node dayHoro = daysHoro.item(j);
                    if (dayHoro.getNodeName().equals("today")) {
                        horoscopesForToday.put(sign.getNodeName(), dayHoro.getTextContent().trim());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        lastUpdateDate = Calendar.getInstance();
    }

    public static String getHoroscopeForToday(String signInRussian) {
        if (!Utils.isSameDay(lastUpdateDate, Calendar.getInstance())){
            updateHoroscope();
        }
        return horoscopesForToday.get(Utils.getSignInEnglish(signInRussian));
    }
}
