package pl.hyorinmaru.mechanic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hyorinmaru.mechanic.domain.Calendar;

import java.time.LocalDateTime;

@Repository
@Transactional(readOnly = true)
public interface CalendarRepository extends JpaRepository<Calendar, LocalDateTime> {

    @Modifying
    @Transactional
    @Query("update Calendar cal set cal.date = ?1 where cal.date = ?2")
    void update(LocalDateTime newDate, LocalDateTime oldDate);

    @Modifying
    @Transactional
    @Query("update Calendar cal set cal.orders = ?1 where cal.date = ?2")
    void updateOrderId(Long orderId, LocalDateTime calendarDate);

    @Modifying
    @Transactional
    @Query("delete Calendar cal where cal.date = ?1")
    void deleteByDate(LocalDateTime calendarDate);
}
