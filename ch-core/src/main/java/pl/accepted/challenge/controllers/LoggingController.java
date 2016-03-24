package pl.accepted.challenge.controllers;

import challenges.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.accepted.challenge.services.LoggingService;

@RestController
public class LoggingController {

    @Autowired
    private LoggingService loggingService;

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    @ResponseBody
    public User getLoggedUser(@RequestParam("username") String username, @RequestParam("password") String password) {

        User user = loggingService.findByUsername(username);

        if(user != null) {
            return user;
        }
        return null;

    }


    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    @ResponseBody
    public User registerUser(@RequestParam("username") String username, @RequestParam("name") String name, @RequestParam("surname") String surname,
                                             @RequestParam("password") String password) {

        User user = loggingService.findByUsername(username);

        if(user != null) {
            return null;
        } else {
            user = new User(username, name, surname, password);
            loggingService.saveUser(user);
            //user = userDAO.findByNick(username);
            return user;
        }

    }
}
