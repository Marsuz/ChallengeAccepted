package pl.accepted.challenge.controllers;

import challenges.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.accepted.challenge.service.UsersService;

import java.util.List;

@RestController(value = "/users")
public class UsersController {

	@Autowired
	private UsersService userService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/{nick}", method = RequestMethod.GET)
	public User getOneUser(@PathVariable("nick") String nick) {
		return userService.getUserByName(nick);
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void createUser(@RequestBody User user) {
		userService.createNewUser(user);
	}

}
