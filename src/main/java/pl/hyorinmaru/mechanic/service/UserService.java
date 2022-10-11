package pl.hyorinmaru.mechanic.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.hyorinmaru.mechanic.domain.Role;
import pl.hyorinmaru.mechanic.domain.User;
import pl.hyorinmaru.mechanic.repository.RoleRepository;
import pl.hyorinmaru.mechanic.repository.UserRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }


    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    public boolean checkPassword(String password) {
        return !password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–\\[{}\\]:;',?\\/*~$^+=<>]).{8,20}$");
    }

    public User findById(Long id){
        return userRepository.findUserById(id);
    }

    public void changeActive(int active, Long userId){
        userRepository.changeActive(active , userId);
    }
}
