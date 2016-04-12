package pl.accepted.challenge.controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.accepted.challenge.exceptions.UserAlreadyExistsException;
import pl.accepted.challenge.exceptions.UserNotFoundException;
import pl.accepted.challenge.services.UsersService;

import java.util.List;

@RestController
@RequestMapping(value = "{userId}/users")
public class UsersController {

	@Autowired
	private UsersService userService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<User> getAllUsers(@PathVariable("userId") Integer userId) {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/{nick}", method = RequestMethod.GET)
	public User getOneUser(@PathVariable("userId") Integer userId, @PathVariable("nick") String nick) {
		return userService.getUserByName(nick);
	}

	@RequestMapping(value = "/create",method = RequestMethod.POST)
	public void createUser(@PathVariable("userId") Integer userId, @RequestBody User user) throws UserAlreadyExistsException {
		userService.create(user);
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public void updateUser(@PathVariable("userId") Integer userId, @RequestBody User user) throws UserNotFoundException {
		userService.update(user);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("userId") Integer userId, @RequestBody User user) {
		userService.deleteUser(user.getId());
	}

}
