package grigory.panov.zodiak;

import grigory.panov.zodiak.utils.ZodiakResolver;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.regex.Pattern;

@Controller
public class MainController {
    private final static String FORMAT_PATTERN = "\\d{4}-\\d{2}-\\d{2}";
    private final static String ERROR_FORMAT_MSG = "The date should match pattern yyyy-MM-dd";
    /*Pattern from regexlib*/
    private final static String RANGE_PATTERN = "^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30)))$";
    private final static String ERROR_RANGE_MSG = "The date should have correct range";
    private final static String ZODIAK_ATTR_TEMPLATE = "zodiak";
    private final static String SDF_PATTERN = "yyyy-MM-dd";

    @RequestMapping("/")
    public String hello(Model model, @RequestParam(value="date", required=false) String date) throws ParseException {
        Calendar cal = Calendar.getInstance();

        if (date != null) {
            Pattern patternFormat = Pattern.compile(FORMAT_PATTERN);
            if (!patternFormat.matcher(date).matches() && !date.isEmpty()){
                throw new IllegalArgumentException(ERROR_FORMAT_MSG);
            }
            Pattern patternRange = Pattern.compile(RANGE_PATTERN);
            if (!patternRange.matcher(date).matches()){
                throw new IllegalArgumentException(ERROR_RANGE_MSG);
            }
            SimpleDateFormat sdf = new SimpleDateFormat(SDF_PATTERN, Locale.ENGLISH);
            cal.setTime(sdf.parse(date));
        }

        model.addAttribute(ZODIAK_ATTR_TEMPLATE, ZodiakResolver.resolve(cal));
        return "index";
    }
    @RequestMapping("/resolveZodiak")
    public @ResponseBody String resolveZodiak(@RequestParam(value="date", required=false) String date) throws ParseException {
        Calendar cal = Calendar.getInstance();

        if (date != null) {
            Pattern patternFormat = Pattern.compile(FORMAT_PATTERN);
            if (!patternFormat.matcher(date).matches() && !date.isEmpty()){
                throw new IllegalArgumentException(ERROR_FORMAT_MSG);
            }
            Pattern patternRange = Pattern.compile(RANGE_PATTERN);
            if (!patternRange.matcher(date).matches()){
                throw new IllegalArgumentException(ERROR_RANGE_MSG);
            }
            SimpleDateFormat sdf = new SimpleDateFormat(SDF_PATTERN, Locale.ENGLISH);
            cal.setTime(sdf.parse(date));
        }
        JSONObject obj = new JSONObject("{\"zodiak\": \" " + ZodiakResolver.resolve(cal) + "\"}");

        return ZodiakResolver.resolve(cal);
    }
}
