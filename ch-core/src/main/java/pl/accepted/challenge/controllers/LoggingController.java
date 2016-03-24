package pl.accepted.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.accepted.challenge.persistence.UserDAO;
import pl.accepted.challenge.services.Encryptor;
import users.User;

@RestController
public class LoggingController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Encryptor encryptor;



    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    @ResponseBody
    public User getLoggedUser(@RequestParam("username") String username, @RequestParam("password") String password) {

        String encryptedPass = encryptor.encrypt(password);

        User user = userDAO.findByNickAndPass(username, encryptedPass);

        if(user != null) {
            return user;
        }
        return null;

    }


    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    @ResponseBody
    public User registerUser(@RequestParam("username") String username, @RequestParam("name") String name, @RequestParam("surname") String surname,
                                             @RequestParam("password") String password) {

        String encryptedPass = encryptor.encrypt(password);

        User user = userDAO.findByNick(username);

        if(user != null) {
            return null;
        } else {
            user = new User(username, name, surname, encryptedPass);
            userDAO.updateUsers(user);
            //user = userDAO.findByNick(username);
            return user;
        }

    }
}
