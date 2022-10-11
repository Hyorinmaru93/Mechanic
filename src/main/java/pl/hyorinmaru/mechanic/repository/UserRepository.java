package pl.hyorinmaru.mechanic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.hyorinmaru.mechanic.domain.User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @Modifying
    @Query("update User u set u.username = ?1, u.password = ?2 where u.id = ?3")
    void setUserInfoById(String login, String password, Long userId);

    User findUserById(Long id);

    @Modifying
    @Query("update User u set u.active=?1 where u.id=?2")
    void changeActive(int active, Long id);
}

