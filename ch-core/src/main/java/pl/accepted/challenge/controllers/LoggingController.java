package pl.accepted.challenge.controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.accepted.challenge.authentication.Authenticator;
import pl.accepted.challenge.exceptions.UserAlreadyExistsException;
import pl.accepted.challenge.services.LoggingService;

@RestController
@RequestMapping(value = "/users")
public class LoggingController {

    @Autowired
    private LoggingService loggingService;

    @Autowired
    private Authenticator authenticator;


    @RequestMapping(value = "/logged", method = RequestMethod.POST)
    @ResponseBody
    public User getLoggedUser(@RequestHeader("username") String username, @RequestHeader("password") String password) {
        return loggingService.findUser(username, password);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String loginUser(@RequestHeader("username") String username, @RequestHeader("password") String password){
        User user = loggingService.findUser(username, password);
        if (user != null) {
            return authenticator.createAndAssignTokenToUser(user);
        } else {
            //TODO
            //throw some exception
            //or handle this in some other way
            return null;
        }
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
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
