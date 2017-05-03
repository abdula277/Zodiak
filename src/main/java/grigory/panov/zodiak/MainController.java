package grigory.panov.zodiak;

import grigory.panov.zodiak.utils.ZodiakResolver;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.Calendar;

import static grigory.panov.zodiak.utils.Utils.tryParseDate;

@Controller
public class MainController {

    @RequestMapping("/")
    public String entryPoint() throws ParseException {
        return "index";
    }

    @RequestMapping("/resolveZodiak")
    public @ResponseBody String resolveZodiak(@RequestParam(value="date", required=false) String date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(tryParseDate(date));

        return ZodiakResolver.resolve(cal);
    }
}
