package pl.accepted.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.accepted.challenge.model.users.User;
import pl.accepted.challenge.persistence.UserDAO;

/**
 * Created by Marcin on 2016-03-19.
 */

@EnableAutoConfiguration(exclude = {
        JpaRepositoriesAutoConfiguration.class
})

@RestController
public class BaseController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/testing")
    public String getHome(){
        userDAO.updateUsers(new User("ElChomiczur", "Mateusz", "Kmiecik", "pass"));
        return userDAO.findByIds(1).toString();
    }

}
