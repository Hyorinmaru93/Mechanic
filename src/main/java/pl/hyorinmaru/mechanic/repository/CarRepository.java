package pl.hyorinmaru.mechanic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hyorinmaru.mechanic.domain.Car;

@Repository
@Transactional(readOnly = true)
public interface CarRepository extends JpaRepository<Car, Long> {

    @Modifying
    @Transactional
    @Query("update Car c set c.brand = ?1, c.model = ?2, c.productionDate = ?3 where c.id =?4")
    void update(String brand, String model, int productionDate, Long id);

}
