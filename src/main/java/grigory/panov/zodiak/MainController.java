package grigory.panov.zodiak;

import grigory.panov.zodiak.utils.ZodiakResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;

import static grigory.panov.zodiak.utils.Utils.tryParseDate;

@Controller
public class MainController {
    private final static String ERROR_PARSE_MSG = "Can't parse the date! Please, check the date";

    @RequestMapping("/")
    public String entryPoint() throws ParseException {
        return "index";
    }

    @RequestMapping("/resolveZodiak")
    @ResponseBody
    public String resolveZodiak(@RequestParam(value = "date", required = false) String date, HttpServletResponse response) throws IOException {
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(tryParseDate(date));
        } catch (ParseException pe) {
            response.sendError(HttpStatus.BAD_REQUEST.value(), ERROR_PARSE_MSG);
        } catch (IllegalArgumentException argEx){
            response.sendError(HttpStatus.BAD_REQUEST.value(), argEx.getMessage());
        }
        return ZodiakResolver.resolve(cal);
    }
}
