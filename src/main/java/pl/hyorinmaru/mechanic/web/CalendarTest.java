package pl.hyorinmaru.mechanic.web;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.hyorinmaru.mechanic.domain.Calendar;
import pl.hyorinmaru.mechanic.service.CalendarService;

import java.time.LocalDateTime;
import java.util.Optional;


@Controller
@RequestMapping("/user")
public class CalendarTest {

    private final CalendarService calendarService;

    public CalendarTest(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @RequestMapping("/add")
    @ResponseBody
    public  String add(){
        LocalDateTime localDateTime = LocalDateTime.of(2022,11, 11, 8,0);
        Calendar calendar = new Calendar();
        calendar.setDate(localDateTime);
        calendarService.create(calendar);
        return "dodaned";
    }

    @RequestMapping("/see")
    @ResponseBody
    public String see(){
        Optional<Calendar> calendar = calendarService.readByDate(LocalDateTime.of(2022,11, 11, 8,0));
        return calendar.orElse(new Calendar()).toString();
    }
}
