package pl.accepted.challenge.services;

import challenges.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.accepted.challenge.exceptions.UserAlreadyExistsException;
import pl.accepted.challenge.exceptions.UserNotFoundException;
import pl.accepted.challenge.persistence.UserRepository;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public User getUserByName(String nick) {
        return userRepository.findOne(nick);
    }

    public void update(User user) throws UserNotFoundException {
        if (userRepository.findByUsername(user.getUsername()) != null) {
            userRepository.save(user);
        } else {
            throw new UserNotFoundException();
        }
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    public void create(User user) throws UserAlreadyExistsException {
        if (userRepository.findByUsername(user.getUsername()) == null) {
            userRepository.save(user);
        } else {
            throw new UserAlreadyExistsException();
        }
    }
}