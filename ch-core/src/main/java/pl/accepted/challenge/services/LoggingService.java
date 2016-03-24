package pl.accepted.challenge.services;

import challenges.User;
import org.springframework.beans.factory.annotation.Autowired;
import pl.accepted.challenge.persistence.UserRepository;

/**
 * Created by wiktor on 25/03/16.
 */
public class LoggingService {

    @Autowired
    private UserRepository userRepository;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


}
