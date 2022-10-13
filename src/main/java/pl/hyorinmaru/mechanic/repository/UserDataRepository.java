package pl.hyorinmaru.mechanic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hyorinmaru.mechanic.domain.UserData;

@Repository
@Transactional
public interface UserDataRepository extends JpaRepository<UserData, Long> {

    UserData readById(Long id);

    UserData readUserDataByEmail(String email);

    @Modifying
    @Transactional
    @Query("update UserData u set u.firstName = ?1, u.lastName = ?2, u.phoneNumber = ?3, u.email = ?4 where u.id=?5")
    void update(String firstName, String lastName, String phoneNumber, String email, Long id);

}
