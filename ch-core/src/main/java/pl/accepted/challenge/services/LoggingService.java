package pl.accepted.challenge.services;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.accepted.challenge.persistence.UserRepository;

@Service
public class LoggingService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findExistingUser(String username) {
        return userRepository.findByUsername(username);
    }

    public User findUser(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }


}
