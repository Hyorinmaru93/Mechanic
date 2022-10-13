package pl.hyorinmaru.mechanic.service;

import org.springframework.stereotype.Service;
import pl.hyorinmaru.mechanic.domain.UserData;
import pl.hyorinmaru.mechanic.repository.UserDataRepository;

import java.util.Optional;

@Service
public class UserDataService {
    private final UserDataRepository userDataRepository;

    public UserDataService(UserDataRepository userDataRepository) {
        this.userDataRepository = userDataRepository;
    }

    public void create(UserData userData) {
        userDataRepository.save(userData);
    }

    public Optional<UserData> readById(Long id) {
        return userDataRepository.findById(id);
    }

    public UserData readByEmail(String email) {
        return userDataRepository.readUserDataByEmail(email);
    }

    public void update(UserData userData) {
        userDataRepository.update(userData.getFirstName(), userData.getLastName(), userData.getPhoneNumber(), userData.getEmail(), userData.getId());
    }

    public void delete(UserData userData) {
        userDataRepository.delete(userData);
    }

    public void deleteById(Long id) {
        userDataRepository.deleteById(id);
    }
}
