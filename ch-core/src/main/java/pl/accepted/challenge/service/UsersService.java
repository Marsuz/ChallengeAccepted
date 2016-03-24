package pl.accepted.challenge.service;

import challenges.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

	public void createNewUser(User user) {
		userRepository.save(user);
	}
}