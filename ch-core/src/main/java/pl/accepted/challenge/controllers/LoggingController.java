package pl.accepted.challenge.controllers;

import challenges.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.accepted.challenge.exceptions.UserAlreadyExistsException;
import pl.accepted.challenge.services.LoggingService;

@RestController
public class LoggingController {

    @Autowired
    private LoggingService loggingService;

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    @ResponseBody
    public User getLoggedUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        return loggingService.findUser(username, password);
    }


    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    @ResponseBody
    public User registerUser(@RequestBody User user) throws UserAlreadyExistsException {

        User existingUser = loggingService.findExistingUser(user.getUsername());

        if(existingUser != null) {
            throw new UserAlreadyExistsException("This username already exists");
        } else {
            loggingService.saveUser(user);
            return user;
        }

    }
}
