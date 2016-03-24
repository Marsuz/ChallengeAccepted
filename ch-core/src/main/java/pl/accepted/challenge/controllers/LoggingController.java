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
        return loggingService.findUser(username);
    }


    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    @ResponseBody
    public User registerUser(@RequestParam("username") String username, @RequestParam("name") String name, @RequestParam("surname") String surname,
                                             @RequestParam("password") String password) throws UserAlreadyExistsException {

        User user = loggingService.findUser(username);

        if(user != null) {
            throw new UserAlreadyExistsException("This username already exists");
        } else {
            user = new User(username, name, surname, password);
            loggingService.saveUser(user);
            return user;
        }

    }
}
