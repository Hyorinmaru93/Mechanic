package pl.hyorinmaru.mechanic.service;

import org.springframework.stereotype.Service;
import pl.hyorinmaru.mechanic.domain.Calendar;
import pl.hyorinmaru.mechanic.repository.CalendarRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {

    private final CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public void create(Calendar calendar){
        calendarRepository.save(calendar);
    }

    public Optional<Calendar> readByDate(LocalDateTime localDateTime){
        return calendarRepository.findById(localDateTime);
    }

    public List<Calendar> readAll(){
        return calendarRepository.findAll();
    }

    public void update(LocalDateTime oldTime, LocalDateTime newTime){
        calendarRepository.update(newTime, oldTime);
    }

    public void updateOrderId(Long orderId, LocalDateTime calendarDate){
        calendarRepository.updateOrderId(orderId, calendarDate);
    }

    public void delete(Calendar calendar){
        calendarRepository.delete(calendar);
    }

    public void deleteByDate(LocalDateTime calendarDate){
        calendarRepository.deleteByDate(calendarDate);
    }
}
