package pl.accepted.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.accepted.challenge.model.users.User;
import pl.accepted.challenge.persistence.UserDAO;
import pl.accepted.challenge.services.Encryptor;


/**
 * Created by Marcin on 2016-03-19.
 */
//@EnableAutoConfiguration(exclude = {
//        JpaRepositoriesAutoConfiguration.class
//})

@RestController
public class LoggingController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Encryptor encryptor;



    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> getLoggedUser(@PathVariable("username") String username, @PathVariable("password") String password) {

        String encryptedPass = encryptor.encrypt(password);

        User user = userDAO.findByNickAndPass(username, encryptedPass);

        if(user != null) {
            return new ResponseEntity<User>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(null, null ,HttpStatus.UNAUTHORIZED);
        }

    }


    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> registerUser(@PathVariable("username") String username, @PathVariable("name") String name, @PathVariable("surname") String surname,
                                             @PathVariable("password") String password) {

        String encryptedPass = encryptor.encrypt(password);

        User user = userDAO.findByNickAndPass(username, encryptedPass);

        if(user != null) {
            return new ResponseEntity<User>(null, null , HttpStatus.UNPROCESSABLE_ENTITY);
        } else {
            user = new User(username, name, surname, encryptedPass);
            userDAO.updateUsers(user);
            return new ResponseEntity<User>(user, HttpStatus.OK);
        }

    }
}
