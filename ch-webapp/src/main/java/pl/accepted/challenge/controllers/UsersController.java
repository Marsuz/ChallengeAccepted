package pl.accepted.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.accepted.challenge.model.users.User;
import pl.accepted.challenge.persistence.UserDAO;

import java.util.List;

/**
 * Created by Marcin on 2016-03-19.
 */

@RestController
public class UsersController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping(value = "/users/all", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {

        List<User> users = userDAO.findAll();
        return users;
    }

    @RequestMapping(value = "/users/{nick}", method = RequestMethod.GET)
    @ResponseBody
    public User getOneUser(@PathVariable("nick") String nick) {

        User user = userDAO.findByNick(nick);
        return user;
        /*if(user == null) return new ResponseEntity<List<User>>(user, null, HttpStatus.OK);
        else return new ResponseEntity<List<User>>(user, HttpStatus.OK);*/
    }

}
